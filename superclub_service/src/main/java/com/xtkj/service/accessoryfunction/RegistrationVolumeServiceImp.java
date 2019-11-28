package com.xtkj.service.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.UserMapper;
import com.xtkj.pojo.User;

@Service
public class RegistrationVolumeServiceImp implements IRegistrationVolumeService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> userRegistrationVolumeOnYear() {
		
		return  userMapper.listUserOnYear();
	}

	@Override
	public List<User> userRegistrationVolumeOnQueter() {
		
		return userMapper.listUserOnQuarter();
	}

	@Override
	public List<User> userRegistrationVolumeOnMonth() {
		
		return userMapper.listUserOnMonth();
	}

	@Override
	public List<User> userRegistrationVolumeOnDay() {
		
		return userMapper.listUserOnDay();
	}
	
}
