package com.xtkj.controller.friendscircle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.Activity;
import com.xtkj.service.friendcircle.IFriendCircleService;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/friendCircle")
public class FriendCircleController {

	@Autowired
	private IFriendCircleService friendCircleService;

	/**
	 * -1.查询用户所发的动态
	 * @param request
	 * @return 
	 */
	@RequestMapping("/circle")
	@ResponseBody
	public ObjectResult allFriendsCircle(HttpServletRequest request) {
		ObjectResult json = null; 
		try {
			List<Activity> listActivity=friendCircleService.findFriendCircle();
			json=new ObjectResult("200", "success",listActivity);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
}
