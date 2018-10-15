
package com.qianwenad.service.sys.impl;

import com.qianwenad.model.sys.RoleResourceRef;
import com.qianwenad.service.sys.RoleResourceRefService;
import com.qianwenad.storage.sys.RoleResourceRefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleResourceRefServiceImpl implements RoleResourceRefService {

    @Autowired
    private RoleResourceRefRepository roleResourceRefRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleResourceRefRepo.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteRef(RoleResourceRef rr) {
        return roleResourceRefRepo.deleteRef(rr);
    }


    @Override
    public RoleResourceRef findByPrimaryKey(Long id) {
        return roleResourceRefRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(RoleResourceRef rr) {
        return roleResourceRefRepo.updateByPrimaryKey(rr);
    }


    @Override
    public int updateByPrimaryKeySelective(RoleResourceRef rr) {
        return roleResourceRefRepo.updateByPrimaryKeySelective(rr);
    }


    @Override
    public int create(RoleResourceRef rr) {
        return roleResourceRefRepo.insert(rr);
    }


    @Override
    public int createSelective(RoleResourceRef rr) {
        return roleResourceRefRepo.insertSelective(rr);
    }

    @Override
    public int selectCount(RoleResourceRef rr) {
        return roleResourceRefRepo.selectCount(rr);
    }

    @Override
    public List<RoleResourceRef> selectPage(RoleResourceRef rr,Pageable pageable) {
        return roleResourceRefRepo.selectPage(rr, pageable);
    }

}
