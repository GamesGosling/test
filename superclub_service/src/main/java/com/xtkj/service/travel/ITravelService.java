package com.xtkj.service.travel;

import java.util.List;

import com.xtkj.pojo.Travel;
import com.xtkj.pojo.User;

public interface ITravelService {
	
	List<Travel> listTravel(User user);
}
