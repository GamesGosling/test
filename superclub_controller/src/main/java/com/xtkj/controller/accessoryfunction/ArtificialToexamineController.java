package com.xtkj.controller.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.Activity;
import com.xtkj.service.accessoryfunction.IArtificialToexamineService;
import com.xtkj.utils.ObjectResult;

/**
 * @version:
 * @Description: 人工审核接口
 * @author: HCC
 * @date: 2019年6月27日下午7:58:46
 */
@Controller
@RequestMapping("/accessory")
public class ArtificialToexamineController {

	@Autowired
	private IArtificialToexamineService iArtificialToexamineService;

	/**
	 * @Description:用户活动审核
	 * @return
	 */
	@RequestMapping("/userActivityToexamine")
	@ResponseBody
	public ObjectResult userActivityToexamine() {
		ObjectResult json = null; 
		try {
			List<Activity> listIsNotOK=iArtificialToexamineService.listUserActivityNotOk();
			json=new ObjectResult("200", "success",listIsNotOK);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
	
	
	@RequestMapping("/activityToexamine")
	@ResponseBody
	public ObjectResult activityToexamine(Activity activity) {
		ObjectResult json = null; 
		try {
			int i=iArtificialToexamineService.examineActivity(activity);
			if(i>0) {
				json=new ObjectResult("200", "success","审核完成");
			}else {
				json=new ObjectResult("400", "fail","审核失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
}
