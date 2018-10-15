package com.qianwenad.storage.sys;

import com.qianwenad.model.sys.UserLoginLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginLogRepository {

    int deleteByPrimaryKey(Long id);

    UserLoginLog selectByPrimaryKey(Long id);


    int updateByPrimaryKey(UserLoginLog userLoginLog);

    int updateByPrimaryKeySelective(UserLoginLog userLoginLog);

    int insert(UserLoginLog userLoginLog);

    int insertSelective(UserLoginLog userLoginLog);


    int selectCount(UserLoginLog userLoginLog);

    List<UserLoginLog> selectPage(@Param("userLoginLog") UserLoginLog userLoginLog, @Param("pageable") Pageable pageable);

}