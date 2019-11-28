package com.xtkj.service.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.LoginHistoryMapper;
import com.xtkj.pojo.LoginHistory;

@Service
public class UserActivityDataServiceImp implements IUserActivityDataService {

	@Autowired
	private LoginHistoryMapper loginHistoryMapper;
	
	@Override
	public List<LoginHistory> userActivityDateYear() {
		
		return loginHistoryMapper.selectYear();
	}

	@Override
	public List<LoginHistory> userActivityDateQuarter() {
		
		return loginHistoryMapper.selectQuarter();
	}

	@Override
	public List<LoginHistory> userActivityDateMonth() {
		
		return loginHistoryMapper.selectMonth();
	}

	@Override
	public List<LoginHistory> userActivityDateDay() {
		
		return loginHistoryMapper.selectDay();
	}

}
