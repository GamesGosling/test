package com.xtkj.controller.user;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xtkj.pojo.LoginHistory;
import com.xtkj.pojo.User;
import com.xtkj.pojo.UserAdvice;
import com.xtkj.service.loginhistory.ILoginHistory;
import com.xtkj.service.user.IUserService;
import com.xtkj.utils.FastDFSClientUtils;
import com.xtkj.utils.GetAddress;
import com.xtkj.utils.GetConputerIp;
import com.xtkj.utils.IConstant;
import com.xtkj.utils.Md5Encrypt;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ILoginHistory loginHistory;
	@Autowired
	private IUserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public ObjectResult checkLogin(HttpServletRequest request, User user) {
		ObjectResult result = null;
		try {

			String telphone = user.getTelephone();
			String loginPwd = user.getUserPassword();

			UsernamePasswordToken upToken = new UsernamePasswordToken(telphone, Md5Encrypt.md5(loginPwd));
			upToken.setRememberMe(true);
			// 获取Subject => 去登陆
			Subject subject = SecurityUtils.getSubject();

			try {
				subject.login(upToken);// 登陆

				// 取出用户
				User currentUser = (User) subject.getPrincipal();
				request.getSession().setAttribute(IConstant.CURRENT_USER, currentUser);

				// 得到地址
				String address = GetAddress.getAddressByIp(request);
				System.out.println(address);
				LoginHistory record = new LoginHistory();
				record.setId(UUID.randomUUID().toString());// 登录历史id
				record.setUserId(currentUser.getUserId());// 用户id
				record.setIp(GetConputerIp.getIpAddr(request));// ip地址
				record.setLoginAddress(address);// 地址
				record.setLoginType("电脑");// 登录类型
				int i = loginHistory.addLoginHistory(record);
				if (i > 0) {
					return new ObjectResult("200", "OK", "main.jsp");
				}

			} catch (UnknownAccountException un) {
				un.printStackTrace();
				return new ObjectResult("500", "账号不存在");
			} catch (IncorrectCredentialsException ine) {
				ine.printStackTrace();
				return new ObjectResult("500", "密码不正确");
			} catch (LockedAccountException lockException) {
				lockException.printStackTrace();
				return new ObjectResult("500", "用户被锁定，请联系管理员");
			} catch (Exception e) {
				e.printStackTrace();
				return new ObjectResult("500", "系统错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new ObjectResult("500", "系统错误:" + e.getMessage());
		}

		return result;
	}

	/*
	 * 注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public ObjectResult register(User user, @RequestParam("upload") CommonsMultipartFile upload) {
		ObjectResult result = null;
		try {
			String tel = user.getTelephone();
			User usr = userService.checkLogin(tel);
			if (usr != null) {
				return new ObjectResult("500", "用户已经存在");
			}
			// 生成主键
			
			try {
			user.setUserId(UUID.randomUUID().toString());
			File file = ((DiskFileItem) upload.getFileItem()).getStoreLocation();
			String path = upload.getOriginalFilename();
			System.out.println(file + "fvds" + path);
			String fileId = FastDFSClientUtils.upload(file, path);
			System.out.println(fileId);
			// 插入头像名
			user.setHeadPortrait(fileId);
			user.setIslimit((short) 0);
			// 加密密码
			String password = Md5Encrypt.md5(user.getUserPassword());
			user.setUserPassword(password);

			int i = userService.register(user);
			if (i > 0) {
				System.out.println("注册成功");
				result = new ObjectResult("200", "successful", "main.jsp");
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				result =new  ObjectResult("500", e.getMessage());
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new ObjectResult("500", "系统错误", e.getMessage());
		}

	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 */
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute(IConstant.CURRENT_USER);
		return "redirect:/pages/main.jsp";
	}

	@RequestMapping("/update")
	@ResponseBody
	public ObjectResult updateUser(HttpServletRequest request, User user,
			@RequestParam("upload") CommonsMultipartFile upload) {
		ObjectResult result = null;
		String fileId = null;

		try {
			String path = upload.getOriginalFilename();
			if (path != null && !"".equals(path)) {
				File file = ((DiskFileItem) upload.getFileItem()).getStoreLocation();
				fileId = FastDFSClientUtils.upload(file, path);
			}
			System.out.println(fileId);

			user.setHeadPortrait(fileId);

			int i = userService.updateByUserIdSelective(user);
			if (i > 0) {
				System.out.println("修改成功");

				User currentUser = userService.checkLogin(user.getTelephone());
				request.getSession().setAttribute(IConstant.CURRENT_USER, currentUser);
				result = new ObjectResult("200", "successful", "main.jsp");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new ObjectResult("500", "系统错误", e.getMessage());

		}

	}

	/**
	 * -修改密码
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/updatePwd")
	public String updatePasssword(HttpServletRequest request, User user) {

		String password = Md5Encrypt.md5(user.getUserPassword());
		user.setUserPassword(password);

		int i = userService.updateByUserIdSelective(user);
		if (i > 0) {
			request.getSession().removeAttribute(IConstant.CURRENT_USER);
			return "redirect:/pages/main.jsp";

		}
		return "redirect:/pages/error.jsp";

	}

	@RequestMapping("/userAdvice")
	public String addUserAdvice(UserAdvice userAdvice, HttpServletRequest request) {
		try {
			UserAdvice advice = new UserAdvice();
			User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);

			advice.setId(UUID.randomUUID().toString());

			advice.setUserId(user.getUserId());

			advice.setContactWay(userAdvice.getContactWay());

			advice.setDoStatus((short) 0);

			advice.setInfoLevel((short) 0);

			advice.setShenHeStatus((short) 0);

			advice.setIsUpperTracker((short) 0);

			advice.setAdvice(userAdvice.getAdvice());

			int i = userService.insertUserAdvice(advice);

			if (i > 0) {
				return "redirect:/pages/main.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/pages/error.jsp";

	}

}
