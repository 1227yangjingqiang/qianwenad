
package com.qianwenad.service.sys;

import com.qianwenad.model.sys.Resource;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResourceService {

    public int create(Resource r);

    public int createSelective(Resource r);

    public Resource findByPrimaryKey(Long id);

    public int updateByPrimaryKey(Resource r);

    public int updateByPrimaryKeySelective(Resource r) throws Exception;

    public int deleteByPrimaryKey(Long id);

    public int deleteRelativeResource(Long id) throws Exception;

    public int selectCount(Resource r);

    public int assignResourceToRole(Long roleId, Long[] resourceIds) throws Exception;

    public List<Resource> selectPage(Resource r, Pageable pageable);

}