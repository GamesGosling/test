package com.xtkj.service.share;

import java.util.List;
import java.util.Map;

import com.xtkj.pojo.UserShare;

public interface IShareSerive {

	//用户上传的接口,保存分享渠道,时间和分享链接
	int saveShareInfo(UserShare userShare);
	
	/*
	 * -邀请好友注册
	 */
	Map<String, List<String>> invitationRegister(String jsonString);
}
