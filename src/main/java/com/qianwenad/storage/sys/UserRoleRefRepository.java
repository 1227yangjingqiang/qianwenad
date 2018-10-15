package com.qianwenad.storage.sys;

import com.qianwenad.model.sys.UserRoleRef;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRefRepository{

  	int deleteByPrimaryKey(Long id);

    int deleteRef(UserRoleRef userRoleRef);
	
	UserRoleRef selectByPrimaryKey(Long id);
	
	    
    int updateByPrimaryKey(UserRoleRef userRoleRef);

    int updateByPrimaryKeySelective(UserRoleRef userRoleRef);

  	int insert(UserRoleRef userRoleRef);
  	
	int insertSelective(UserRoleRef userRoleRef);


    int selectCount(UserRoleRef userRoleRef);

    List<UserRoleRef> selectPage(@Param("userRoleRef") UserRoleRef userRoleRef, @Param("pageable") Pageable pageable);
	
}