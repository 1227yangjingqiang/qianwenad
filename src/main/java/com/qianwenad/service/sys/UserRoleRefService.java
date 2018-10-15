
package com.qianwenad.service.sys;

import com.qianwenad.model.sys.UserRoleRef;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRoleRefService {

    public int create(UserRoleRef ur);

    public int createSelective(UserRoleRef ur);

    public UserRoleRef findByPrimaryKey(Long id);

    public int updateByPrimaryKey(UserRoleRef ur);

    public int updateByPrimaryKeySelective(UserRoleRef ur);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(UserRoleRef ur);

    public List<UserRoleRef> selectPage(UserRoleRef ur, Pageable pageable);

}