package com.xtkj.controller.friendscircle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.Activity;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/friendcircle")
public class FriendscircleSendFriendsInfoController {

	@RequestMapping("/sendFrinendCircle")
	@ResponseBody
	public ObjectResult sendFriendCircle(Activity activity) {

		ObjectResult json = null; 
		try {
			
			json=new ObjectResult("200", "success","此功能待开放");

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
}
