package com.xtkj.controller.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.xtkj.pojo.User;
import com.xtkj.service.user.IUserService;

public class UserRealm extends JdbcRealm {
	
	@Autowired
	private IUserService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		// 转换
		UsernamePasswordToken upToken = (UsernamePasswordToken) authToken;
		// 拿到前面传递过来的账号和密码,默认是没有加密的,但是我们可以在 Controller中加密，或者用shiro框架的自带加密.
		User user = userService.checkLogin(upToken.getUsername());
		if (user != null) {
			if(user.getIslimit()==1) {
				LockedAccountException lockedException = new LockedAccountException("用户被锁定，联系管理员");
						throw lockedException;
			}
			AuthenticationInfo authInfo = new SimpleAuthenticationInfo(user,user.getUserPassword(),this.getName());

			return authInfo;
		}
		
		return null;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("授权");
		return super.doGetAuthorizationInfo(arg0);
	}

}
