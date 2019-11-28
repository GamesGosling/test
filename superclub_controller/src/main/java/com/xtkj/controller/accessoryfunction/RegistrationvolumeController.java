package com.xtkj.controller.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.User;
import com.xtkj.service.accessoryfunction.IRegistrationVolumeService;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/userRegister")
public class RegistrationvolumeController {

	@Autowired
	private IRegistrationVolumeService iRegistrationVolumeService;
	
	@RequestMapping("/year")
	@ResponseBody
	public ObjectResult userActivityDateYear() {
		ObjectResult json = null; 
		try {
			List<User> listUser=iRegistrationVolumeService.userRegistrationVolumeOnYear();
			json=new ObjectResult("200", "success",listUser);

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
			List<User> listUser=iRegistrationVolumeService.userRegistrationVolumeOnQueter();
			json=new ObjectResult("200", "success",listUser);


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
			List<User> listUser=iRegistrationVolumeService.userRegistrationVolumeOnMonth();
			json=new ObjectResult("200", "success",listUser);


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
			List<User> listUser=iRegistrationVolumeService.userRegistrationVolumeOnDay();
			json=new ObjectResult("200", "success",listUser);


		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
}
