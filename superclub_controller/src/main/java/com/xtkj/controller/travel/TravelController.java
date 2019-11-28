package com.xtkj.controller.travel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.Travel;
import com.xtkj.pojo.User;
import com.xtkj.service.travel.ITravelService;
import com.xtkj.utils.IConstant;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	private ITravelService travelService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public ObjectResult  getListTravel(HttpServletRequest request) {
		ObjectResult result = null;
		try {
		User user = (User)request.getSession().getAttribute(IConstant.CURRENT_USER);
		System.out.println(user.getUserId());
		List <Travel> listTravel = travelService.listTravel(user);
		result  = new ObjectResult("200", "sucessful",listTravel);
		} catch (Exception e) {
			e.printStackTrace();
			return new ObjectResult("500", e.getMessage());
			}
		return result;
	}
	


}
