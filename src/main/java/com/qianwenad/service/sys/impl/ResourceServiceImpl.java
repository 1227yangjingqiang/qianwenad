
package com.qianwenad.service.sys.impl;

import com.google.common.collect.Sets;
import com.qianwenad.model.sys.Resource;
import com.qianwenad.model.sys.RoleResourceRef;
import com.qianwenad.service.sys.ResourceService;
import com.qianwenad.storage.sys.ResourceRepository;
import com.qianwenad.storage.sys.RoleResourceRefRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepo;

    @Autowired
    private RoleResourceRefRepository roleResourceRefRepository;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return resourceRepo.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRelativeResource(Long id) throws Exception {
        //删除资源本身
        int result = 0;
        try {
            resourceRepo.deleteByPrimaryKey(id);

            //删除角色与资源的关联关系
            RoleResourceRef ref = new RoleResourceRef();
            ref.setResourceId(id);
            roleResourceRefRepository.deleteRef(ref);
            result = 1;
        } catch (Exception ex) {
            log.error("ResourceServiceImpl.deleteRelativeResource() >>> business exception:", ex);
            throw new Exception("delete resource occur exception", ex);
        }

        return result;
    }


    @Override
    public Resource findByPrimaryKey(Long id) {
        return resourceRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(Resource r) {
        return resourceRepo.updateByPrimaryKey(r);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Resource r) throws Exception {
        try {

            if (r != null && r.getStatus() == Resource.UN_AVAILABLE_RESOURCE) {
                //如果资源更新为禁用，删除角色与资源的关联关系
                RoleResourceRef ref = new RoleResourceRef();
                ref.setResourceId(r.getId());
                roleResourceRefRepository.deleteRef(ref);
            }

            return resourceRepo.updateByPrimaryKeySelective(r);
        } catch (Exception ex) {
            log.error("ResourceServiceImpl.updateByPrimaryKeySelective() >>> business exception:", ex);
            throw new Exception("updateByPrimaryKeySelective resource occur exception", ex);
        }
    }


    @Override
    public int create(Resource r) {
        return resourceRepo.insert(r);
    }


    @Override
    public int createSelective(Resource r) {
        return resourceRepo.insertSelective(r);
    }


    @Override
    public int selectCount(Resource r) {
        return resourceRepo.selectCount(r);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int assignResourceToRole(Long roleId, Long[] resourceIds) throws Exception {
        try {
            RoleResourceRef ref = new RoleResourceRef();
            ref.setRoleId(roleId);
            roleResourceRefRepository.deleteRef(ref);

            int result = 0;
            //记录下存在父id的集合
            Set<Long> pidSet = Sets.newHashSet();
            for (Long resourceId : resourceIds) {
                Resource resource = resourceRepo.selectByPrimaryKey(resourceId);
                if (resource == null) {  //资源不存在
                    continue;
                }
                RoleResourceRef roleResource = new RoleResourceRef();
                roleResource.setResourceId(resourceId);
                roleResource.setRoleId(roleId);
                roleResource.setCreateTime(new Date());
                result = roleResourceRefRepository.insertSelective(roleResource);
                if (resource.getPid() != 0) {
                    pidSet.add(resource.getPid());
                }
            }

            //将父级节点递归也添加到角色资源中
            if (pidSet != null) {
                for (Long pid : pidSet) {
                    if (ArrayUtils.contains(resourceIds, pid)) {
                        continue;
                    }
                    RoleResourceRef roleResource = new RoleResourceRef();
                    roleResource.setResourceId(pid);
                    roleResource.setRoleId(roleId);
                    roleResource.setCreateTime(new Date());
                    result = roleResourceRefRepository.insertSelective(roleResource);
                }
            }
            return result;
        } catch (Exception e) {
            log.error("assignResourceToRole occur exception ", e);
            throw new Exception("assignResourceToRole occur exception ", e);
        }

    }

    @Override
    public List<Resource> selectPage(Resource r, Pageable pageable) {
        return resourceRepo.selectPage(r, pageable);
    }


}
