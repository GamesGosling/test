package com.xtkj.service.loginhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.LoginHistoryMapper;
import com.xtkj.pojo.LoginHistory;

@Service
public class LoginHistoryImpl implements ILoginHistory {
	@Autowired
	private LoginHistoryMapper loginHistoryMapper;

	/*
	 * 添加登录历史记录
	 */
	@Override
	public int addLoginHistory(LoginHistory record) {
		return loginHistoryMapper.addLoginHistory(record);
	}

}
