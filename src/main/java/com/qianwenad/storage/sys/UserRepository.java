package com.qianwenad.storage.sys;

import com.qianwenad.model.sys.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    int deleteByPrimaryKey(Long id);

    User selectByPrimaryKey(Long id);


    int updateByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User user);

    int insert(User user);

    int insertSelective(User user);


    int selectCount(User user);

    List<User> selectPage(@Param("user") User user, @Param("pageable") Pageable pageable);

}