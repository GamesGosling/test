package com.xtkj.service.travel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.TravelMapper;
import com.xtkj.pojo.Travel;
import com.xtkj.pojo.User;

@Service("travelService")
public class TravelServiceImpl implements ITravelService{
	@Autowired
	private TravelMapper travelMapper;

	@Override
	public List<Travel> listTravel(User user) {
		return travelMapper.listTrvel(user);
	}

}
