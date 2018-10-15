package com.qianwenad.storage.sys;

import com.qianwenad.model.sys.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository{

  	int deleteByPrimaryKey(Long id);
	
	Resource selectByPrimaryKey(Long id);
	
	    
    int updateByPrimaryKey(Resource resource);

    int updateByPrimaryKeySelective(Resource resource);

  	int insert(Resource resource);
  	
	int insertSelective(Resource resource);


    int selectCount(Resource resource);

    List<Resource> selectPage(@Param("resource") Resource resource, @Param("pageable") Pageable pageable);
	
}