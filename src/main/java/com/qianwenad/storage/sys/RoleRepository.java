package com.qianwenad.storage.sys;

import com.qianwenad.model.sys.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository{

  	int deleteByPrimaryKey(Long id);
	
	Role selectByPrimaryKey(Long id);
	
	    
    int updateByPrimaryKey(Role role);

    int updateByPrimaryKeySelective(Role role);

  	int insert(Role role);
  	
	int insertSelective(Role role);


    int selectCount(Role role);

    List<Role> selectPage(@Param("role") Role role, @Param("pageable") Pageable pageable);
	
}