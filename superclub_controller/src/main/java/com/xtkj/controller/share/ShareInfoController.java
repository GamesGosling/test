package com.xtkj.controller.share;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.UserShare;
import com.xtkj.service.share.IShareSerive;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/share")
public class ShareInfoController {

	@Autowired
	private IShareSerive shareService;
		
	/**
	 * -保存分享渠道,时间和分享链接,并返回JSON数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody()
	public	ObjectResult saveShareInfo(HttpServletRequest request,UserShare userShare) {
		ObjectResult json = null; 
		try {
			int i=shareService.saveShareInfo(userShare);		
			if(i<=0) {
				json=new ObjectResult("500", "fail");
			}
			
			json=new ObjectResult("200", "success","分享成功");
			
		} catch (Exception e) {
			json=new ObjectResult("503", "error",e.getMessage());
		}
		
		return json;
	}
	
	
	/**
	 * -邀请好友注册
	 * @param request
	 * @param jsonString--界面传来jsonString的字符串，键为telphone，值为电话json字符串
	 * @return 返回一个含有已登录和未登录的map的json字符串
	 */
	@RequestMapping("/invitationRegister")
	@ResponseBody()
	public	ObjectResult invitationMailListFriedsRegister(HttpServletRequest request,String jsonString) {
		ObjectResult json = null; 
		try {
			Map<String, List<String>> tel=shareService.invitationRegister(jsonString);
			
			if(tel.isEmpty()) {
				json=new ObjectResult("500", "fail");
			}else {
				json=new ObjectResult("200", "success",tel);
			}	
			
		} catch (Exception e) {
			json=new ObjectResult("503", "error",e.getMessage());
		}
		
		return json;
	}
	
}
