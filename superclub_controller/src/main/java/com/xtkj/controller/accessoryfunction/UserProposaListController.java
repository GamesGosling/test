package com.xtkj.controller.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.UserAdvice;
import com.xtkj.service.accessoryfunction.IUserProposaListService;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/accessory")
public class UserProposaListController {

	@Autowired
	private IUserProposaListService IUserProposaListService;

	/**
	 * @Description:用户建议反馈接口
	 * @return
	 */
	@RequestMapping("/userProposaList")
	@ResponseBody
	public ObjectResult userProposaList() {
		ObjectResult json = null; 
		try {
			List<UserAdvice> listUserAdvice=IUserProposaListService.userProposaList();
			json=new ObjectResult("200", "success",listUserAdvice);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
}
