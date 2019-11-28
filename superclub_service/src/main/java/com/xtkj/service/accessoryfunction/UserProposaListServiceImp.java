package com.xtkj.service.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.UserAdviceMapper;
import com.xtkj.pojo.UserAdvice;

@Service
public class UserProposaListServiceImp implements IUserProposaListService {

	@Autowired
	private UserAdviceMapper userAdviceMapper;
	
	public List<UserAdvice> userProposaList() {
		
		return userAdviceMapper.listUserAdvice();
	}
}
