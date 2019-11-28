package com.xtkj.service.user;

import com.xtkj.pojo.User;
import com.xtkj.pojo.UserAdvice;

public interface IUserService {
	
	User checkLogin(String telephone);
	
	int register(User user);
	
	int updateByUserIdSelective(User user);
	
	int insertUserAdvice(UserAdvice userAdvice);
}
