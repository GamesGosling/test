package com.xtkj.controller.checkmessage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.utils.ALiYunMsg;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/captcha")
public class MessageController {

	/**
	 * -调用短信接口并用用户的唯一键作为session的key value =验证码
	 * -得到修改密码的验证码
	 * @param request
	 * @param tel
	 * @param userId
	 * @throws Exception
	 */
	@RequestMapping("/updatePwd")
	@ResponseBody
	public ObjectResult updatePwd(HttpServletRequest request, @RequestParam("phone")String phone) throws Exception {

		String capcha = ALiYunMsg.getCapcha(phone, "updatePwd");

	
		return new ObjectResult("200", "success", capcha);			
	
	}
	
	/**
	 * 得到注册的验证码
	 * @param request
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/register")
	@ResponseBody
	public ObjectResult register(HttpServletRequest request, @RequestParam("phone")String phone) throws Exception {
		
		String capcha = ALiYunMsg.getCapcha(phone, "register");
       return new ObjectResult("200", "success", capcha);			
	
	}

}
