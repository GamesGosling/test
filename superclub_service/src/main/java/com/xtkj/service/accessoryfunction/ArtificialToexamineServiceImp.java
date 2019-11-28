package com.xtkj.service.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.ActivityMapper;
import com.xtkj.pojo.Activity;

@Service
public class ArtificialToexamineServiceImp implements IArtificialToexamineService {

	@Autowired
	private ActivityMapper activityMapper;
	
	@Override
	public List<Activity> listUserActivityNotOk() {
		return activityMapper.selectByIsOK();
	}

	@Override
	public int examineActivity(Activity activity) {
		
		int i = 0;
		try {
			i=activityMapper.updateByPrimaryKeySelective(activity);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return i;
	}

	
}
