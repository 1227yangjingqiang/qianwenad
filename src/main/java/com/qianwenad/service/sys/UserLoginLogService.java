package com.qianwenad.service.sys;

import com.qianwenad.model.sys.UserLoginLog;

public interface UserLoginLogService {

    public int create(UserLoginLog userLoginLog);

    public int createSelective(UserLoginLog userLoginLog);

    public UserLoginLog findByPrimaryKey(Long id);

    public int updateByPrimaryKey(UserLoginLog userLoginLog);

    public int updateByPrimaryKeySelective(UserLoginLog userLoginLog);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(UserLoginLog userLoginLog);

}