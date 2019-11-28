package com.xtkj.service.accessoryfunction;

import java.util.List;

import com.xtkj.pojo.LoginHistory;

public interface IUserActivityDataService {

	/**
	 * @Description:年
	 * @return
	 */
	List<LoginHistory> userActivityDateYear();
	
	/**
	 * @Description:季
	 * @return
	 */
	List<LoginHistory> userActivityDateQuarter();
	
	/**
	 * @Description:月
	 * @return
	 */
	List<LoginHistory> userActivityDateMonth();
	
	/**
	 * @Description:日
	 * @return
	 */
	List<LoginHistory> userActivityDateDay();
}
