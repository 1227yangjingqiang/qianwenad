
package com.qianwenad.service.sys.impl;

import com.qianwenad.model.sys.User;
import com.qianwenad.service.sys.UserService;
import com.qianwenad.storage.sys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	

	@Override
	public int deleteByPrimaryKey(Long id) {
		return userRepo.deleteByPrimaryKey(id);
	}
	


	@Override
	public User findByPrimaryKey(Long id) {
		return userRepo.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(User u) {
		return userRepo.updateByPrimaryKey(u);
	}

	@Override
	public int updateByPrimaryKeySelective(User u) {
		return userRepo.updateByPrimaryKeySelective(u);
	}

	@Override
	public int create(User u) {
		return userRepo.insert(u);
	}


	@Override
	public int createSelective(User u) {
		return userRepo.insertSelective(u);
	}


	@Override
	public int selectCount(User u) {
		return userRepo.selectCount(u);
	}

	@Override
	public List<User> selectPage(User u, Pageable pageable) {
		return userRepo.selectPage(u,pageable);
	}


}
