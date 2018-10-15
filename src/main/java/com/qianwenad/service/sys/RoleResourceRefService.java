
package com.qianwenad.service.sys;

import com.qianwenad.model.sys.RoleResourceRef;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleResourceRefService {

    public int create(RoleResourceRef rr);

    public int createSelective(RoleResourceRef rr);

    public RoleResourceRef findByPrimaryKey(Long id);

    public int updateByPrimaryKey(RoleResourceRef rr);

    public int updateByPrimaryKeySelective(RoleResourceRef rr);

    public int deleteByPrimaryKey(Long id);

    public int deleteRef(RoleResourceRef rr);


    public int selectCount(RoleResourceRef rr);

    public List<RoleResourceRef> selectPage(RoleResourceRef rr,Pageable pageable);
}