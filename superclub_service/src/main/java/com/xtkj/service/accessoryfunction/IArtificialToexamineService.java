package com.xtkj.service.accessoryfunction;

import java.util.List;

import com.xtkj.pojo.Activity;

public interface IArtificialToexamineService {

	/**
	 * @Description:查询未审核的活动
	 * @return
	 */
	List<Activity> listUserActivityNotOk();
	
	/**
	 * @Description:审核活动
	 * @param activity
	 * @return
	 */
	int examineActivity(Activity activity);
}
