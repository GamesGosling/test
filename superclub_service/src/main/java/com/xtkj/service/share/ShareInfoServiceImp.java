package com.xtkj.service.share;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xtkj.dao.UserMapper;
import com.xtkj.dao.UserShareMapper;
import com.xtkj.pojo.User;
import com.xtkj.pojo.UserShare;
import com.xtkj.utils.JSONStringUtils;

@Service
public class ShareInfoServiceImp implements IShareSerive {

	@Autowired
	private UserShareMapper share;
	@Autowired
	private UserMapper user;

	//保存用户分享的信息
	public int saveShareInfo(UserShare userShare) {
		return share.insertSelective(userShare);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<String>> invitationRegister(String jsonString) {
		
		//拿到前面传来json字符串
		JSONObject jsonObj=JSONObject.parseObject(jsonString);
		
		//从中取出telphone的json字符串，然后转成list<String>
		String teljson=jsonObj.getString("telphone");
		
		List<String> listTelphone = null;
		
		List<String> registeredTel = null;
		
		//用来装已注册的电话号码和未注册的电话号码
		Map<String,List<String>> tels = null;
		try {	
			listTelphone=JSONStringUtils.jsonToJava(teljson, String.class);
			
		} catch (Exception e) {
			System.out.println("转换出错");
			e.getStackTrace();
		}
		
		//从数据库查询所有的用户再进行比对
		List<User> listUser=user.listUser();
		for(User alluser:listUser) {
			if(listTelphone!=null) {
				for(String telString:listTelphone) {
					if(alluser.getTelephone()!=null||!"".equals(alluser.getTelephone())&&alluser.getTelephone().equals(telString)){
						//此时表示已注册的
						registeredTel.add(telString);
						listTelphone.remove(alluser.getTelephone());
					}
				}
			}
		}
		//已注册的
		tels.put("registeredTel", registeredTel);
		//为注册的
		tels.put("unregisteredTel", listTelphone);
		
		return tels;
	}

}
