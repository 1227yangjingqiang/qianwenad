
package com.qianwenad.service.sys;

import com.qianwenad.model.sys.Role;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    public int create(Role r);

    public int createSelective(Role r);

    public Role findByPrimaryKey(Long id);

    public int updateByPrimaryKey(Role r);

    public int updateByPrimaryKeySelective(Role r) throws Exception;

    public int deleteByPrimaryKey(Long id);

    public int deleteRelativeRole(Long id) throws Exception;

    public int selectCount(Role r);

    public List<Role> selectPage(Role r, Pageable pageable);

}