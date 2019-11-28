package com.xtkj.controller.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.LoginHistory;
import com.xtkj.service.accessoryfunction.IUserActivityDataService;
import com.xtkj.utils.ObjectResult;

/**
 * @version:1.0
 * @Description: 用户活跃度接口
 * @author: HCC
 * @date: 2019年7月3日下午3:54:57
 */
@Controller
@RequestMapping("/userActivityData")
public class UserActivityDataController{

	@Autowired
	private IUserActivityDataService iUserActivityDataService;
	
	@RequestMapping("/year")
	@ResponseBody
	public ObjectResult userActivityDateYear() {
		ObjectResult json = null; 
		try {
			List<LoginHistory> listLogin=iUserActivityDataService.userActivityDateYear();
			json=new ObjectResult("200", "success",listLogin);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}


	@RequestMapping("/quarter")
	@ResponseBody
	public ObjectResult userActivityDateQuarter() {
		ObjectResult json = null; 
		try {
			List<LoginHistory> listLogin=iUserActivityDataService.userActivityDateQuarter();
			json=new ObjectResult("200", "success",listLogin);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}


	@RequestMapping("/month")
	@ResponseBody
	public ObjectResult userActivityDateMonth() {
		ObjectResult json = null; 
		try {
			List<LoginHistory> listLogin=iUserActivityDataService.userActivityDateMonth();
			json=new ObjectResult("200", "success",listLogin);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}

	@RequestMapping("/day")
	@ResponseBody
	public ObjectResult userActivityDateDay() {
		ObjectResult json = null; 
		try {
			List<LoginHistory> listLogin=iUserActivityDataService.userActivityDateDay();
			json=new ObjectResult("200", "success",listLogin);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
}
