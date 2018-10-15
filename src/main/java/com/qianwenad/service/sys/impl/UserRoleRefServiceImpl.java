
package com.qianwenad.service.sys.impl;

import com.qianwenad.model.sys.UserRoleRef;
import com.qianwenad.service.sys.UserRoleRefService;
import com.qianwenad.storage.sys.UserRoleRefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleRefServiceImpl implements UserRoleRefService {


    @Autowired
    private UserRoleRefRepository userRoleRefRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return userRoleRefRepo.deleteByPrimaryKey(id);
    }

    @Override
    public UserRoleRef findByPrimaryKey(Long id) {
        return userRoleRefRepo.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(UserRoleRef ur) {
        return userRoleRefRepo.updateByPrimaryKey(ur);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRoleRef ur) {
        return userRoleRefRepo.updateByPrimaryKeySelective(ur);
    }


    @Override
    public int create(UserRoleRef ur) {
        return userRoleRefRepo.insert(ur);
    }

    @Override
    public int createSelective(UserRoleRef ur) {
        return userRoleRefRepo.insertSelective(ur);
    }

    @Override
    public int selectCount(UserRoleRef ur) {
        return userRoleRefRepo.selectCount(ur);
    }

    @Override
    public List<UserRoleRef> selectPage(UserRoleRef ur, Pageable pageable) {
        return userRoleRefRepo.selectPage(ur, pageable);
    }


}
