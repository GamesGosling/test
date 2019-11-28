package com.xtkj.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.UserAdviceMapper;
import com.xtkj.dao.UserMapper;
import com.xtkj.pojo.User;
import com.xtkj.pojo.UserAdvice;

@Service("userSevice")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserAdviceMapper userAdviceMapper;

	public User checkLogin(String userTel) {

		User currentUser = userMapper.checkLogin(userTel);
		if(currentUser==null) {
			return null;
		}
		return currentUser;
	}

	@Override
	public int register(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int updateByUserIdSelective(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int insertUserAdvice(UserAdvice userAdvice) {
		return  userAdviceMapper.insert(userAdvice);
	}
	
	

}
