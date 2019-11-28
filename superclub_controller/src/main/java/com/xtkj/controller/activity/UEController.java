package com.xtkj.controller.activity;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.ActionEnter;

/**
 *  UEditor富文本编辑器，后端控制器 
 * @author 秋枫艳梦
 * @date 2019-06-22
 **/
@Controller
@RequestMapping(value = "/ueditor")
public class UEController {
	/**
	 *  设置配置信息，供前端富文本编辑器检验是否可以使用IO流的操作
	 * @param request 请求体
	 * @param response 响应体
	 * @return 
	 * */
	@RequestMapping(value="/config")
	@ResponseBody
	public String config(HttpServletRequest request, HttpServletResponse response) {
		String configStr = null;
		try {
			request.setCharacterEncoding( "utf-8" );
			response.setHeader("Content-Type" , "text/html");
			String roolPath = request.getSession().getServletContext().getRealPath("/");
			configStr = new ActionEnter(request, roolPath).exec();			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return configStr;
	}
}
