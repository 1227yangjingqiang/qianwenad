
package com.qianwenad.service.sys.impl;

import com.qianwenad.model.sys.Role;
import com.qianwenad.model.sys.RoleResourceRef;
import com.qianwenad.model.sys.UserRoleRef;
import com.qianwenad.service.sys.RoleService;
import com.qianwenad.storage.sys.RoleRepository;
import com.qianwenad.storage.sys.RoleResourceRefRepository;
import com.qianwenad.storage.sys.UserRoleRefRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private RoleResourceRefRepository roleResourceRefRepository;


    @Autowired
    private UserRoleRefRepository userRoleRefRepository;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleRepo.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRelativeRole(Long id) throws Exception {

        Integer result = 0;
        try {
            //删除角色本身
            result = roleRepo.deleteByPrimaryKey(id);

            //删除角色与资源的关联关系
            RoleResourceRef ref = new RoleResourceRef();
            ref.setRoleId(id);
            roleResourceRefRepository.deleteRef(ref);

            //删除用户与角色的关联关系
            UserRoleRef userRoleRef = new UserRoleRef();
            userRoleRef.setRoleId(id);
            userRoleRefRepository.deleteRef(userRoleRef);

            result = 1;
        } catch (Exception ex) {
            log.error("ResourceServiceImpl.deleteRelativeResource() >>> business exception:", ex);
            throw new Exception("delete resource occur exception", ex);
        }

        return result;
    }


    @Override
    public Role findByPrimaryKey(Long id) {
        return roleRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(Role r) {
        return roleRepo.updateByPrimaryKey(r);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Role r) throws Exception {
        try {
            //如果更新状态为 禁用， 删除用户与角色的关联关系
            if (r != null && r.getStatus() == Role.UN_AVAILABLE_ROLE) {
                UserRoleRef userRoleRef = new UserRoleRef();
                userRoleRef.setRoleId(r.getId());
                userRoleRefRepository.deleteRef(userRoleRef);
            }

            return roleRepo.updateByPrimaryKeySelective(r);
        } catch (Exception ex) {
            log.error("RoleServiceImpl.updateByPrimaryKeySelective() >>> business exception:", ex);
            throw new Exception("updateByPrimaryKeySelective resource occur exception", ex);
        }
    }


    @Override
    public int create(Role r) {
        return roleRepo.insert(r);
    }

    @Override
    public int createSelective(Role r) {
        return roleRepo.insertSelective(r);
    }

    @Override
    public int selectCount(Role r) {
        return roleRepo.selectCount(r);
    }

    @Override
    public List<Role> selectPage(Role r, Pageable pageable) {
        return roleRepo.selectPage(r, pageable);
    }

}
