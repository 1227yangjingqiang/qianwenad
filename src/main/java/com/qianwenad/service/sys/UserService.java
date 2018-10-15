
package com.qianwenad.service.sys;

import com.qianwenad.model.sys.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    public int create(User u);

    public int createSelective(User u);

    public User findByPrimaryKey(Long id);

    public int updateByPrimaryKey(User u);

    public int updateByPrimaryKeySelective(User u);

    public int deleteByPrimaryKey(Long id);

    public int selectCount(User u);

    public List<User> selectPage(User u, Pageable pageable);

}