package com.qianwenad.storage.sys;

import com.qianwenad.model.sys.RoleResourceRef;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleResourceRefRepository{

  	int deleteByPrimaryKey(Long id);

  	int deleteRef(RoleResourceRef roleResourceRef);

	RoleResourceRef selectByPrimaryKey(Long id);
	
	    
    int updateByPrimaryKey(RoleResourceRef roleResourceRef);

    int updateByPrimaryKeySelective(RoleResourceRef roleResourceRef);

  	int insert(RoleResourceRef roleResourceRef);
  	
	int insertSelective(RoleResourceRef roleResourceRef);


    int selectCount(RoleResourceRef roleResourceRef);

    List<RoleResourceRef> selectPage(@Param("roleResourceRef") RoleResourceRef roleResourceRef, @Param("pageable") Pageable pageable);
	
}