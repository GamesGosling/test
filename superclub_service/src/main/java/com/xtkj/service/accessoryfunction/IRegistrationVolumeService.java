package com.xtkj.service.accessoryfunction;

import java.util.List;

import com.xtkj.pojo.User;

public interface IRegistrationVolumeService {

	List<User> userRegistrationVolumeOnYear();
	
	List<User> userRegistrationVolumeOnQueter();
	
	List<User> userRegistrationVolumeOnMonth();
	
	List<User> userRegistrationVolumeOnDay();
}
