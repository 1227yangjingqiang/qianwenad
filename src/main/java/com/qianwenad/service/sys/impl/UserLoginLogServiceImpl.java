
package com.qianwenad.service.sys.impl;

import com.qianwenad.model.sys.UserLoginLog;
import com.qianwenad.service.sys.UserLoginLogService;
import com.qianwenad.storage.sys.UserLoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {

    @Autowired
    private UserLoginLogRepository userLoginLogRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return userLoginLogRepo.deleteByPrimaryKey(id);
    }


    @Override
    public UserLoginLog findByPrimaryKey(Long id) {
        UserLoginLog userLoginLog = userLoginLogRepo.selectByPrimaryKey(id);
        return userLoginLogRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(UserLoginLog userLoginLog) {
        return userLoginLogRepo.updateByPrimaryKey(userLoginLog);
    }

    @Override
    public int updateByPrimaryKeySelective(UserLoginLog userLoginLog) {
        return userLoginLogRepo.updateByPrimaryKeySelective(userLoginLog);
    }


    @Override
    public int create(UserLoginLog userLoginLog) {
        return userLoginLogRepo.insert(userLoginLog);
    }


    @Override
    public int createSelective(UserLoginLog userLoginLog) {
        return userLoginLogRepo.insertSelective(userLoginLog);
    }


    @Override
    public int selectCount(UserLoginLog userLoginLog) {
        return userLoginLogRepo.selectCount(userLoginLog);
    }


}
