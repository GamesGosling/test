package com.xtkj.controller.friendscircle;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.Activity;
import com.xtkj.pojo.User;
import com.xtkj.service.friendcircle.IFriendsFabulousService;
import com.xtkj.utils.IConstant;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/friendCircle")
public class FriendsCircleFabulousContraller {

	@Autowired
	private IFriendsFabulousService friendsFabulousService;
	
	/**
	 * -得到活动点赞的数量
	 * @param activity
	 * @return 
	 */
	@RequestMapping("/fabulous")
	@ResponseBody
	public ObjectResult getfriendsCircleFabulous(HttpServletRequest request,Activity activity) {
		User user=(User) request.getSession().getAttribute(IConstant.CURRENT_USER);
		ObjectResult json = null; 
		if(user==null) {
			System.out.println("用户失效了");
			try {
				
				json=new ObjectResult("300", "success","main.jsp");
				
			} catch (Exception e) {		
				e.printStackTrace();
			}
			return json;
		}
		
		
		try {
			
			Map<String, String> maps=friendsFabulousService.getActivityFabulous(activity.getId(),user);
			json=new ObjectResult("200", "success",maps);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
	
	
	/**
	 * -增加和取消点赞
	 * @param activity
	 * @param user
	 * @return
	 */
	@RequestMapping("/getAddAndDelfabulous")
	@ResponseBody
	public ObjectResult addAndDelCircleFabulous(HttpServletRequest request,HttpServletResponse response, Activity activity) {
		User user=(User) request.getSession().getAttribute(IConstant.CURRENT_USER);
		ObjectResult json = null; 
		
		if(user==null) {
			System.out.println("用户失效了");
			try {				
				json=new ObjectResult("300", "success","main.jsp");
				
			} catch (Exception e) {		
				e.printStackTrace();
			}
			return json;
		}
		
		try {
			Map<String, Object> maps=friendsFabulousService.addAnddelActivityFabulous(activity.getId(), user);
			
			json=new ObjectResult("200", "success",maps);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}
		return json;	
	}	
}
