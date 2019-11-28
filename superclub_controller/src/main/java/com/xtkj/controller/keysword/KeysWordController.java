package com.xtkj.controller.keysword;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.KeyWords;
import com.xtkj.service.keyswordfilter.IKeysWordFilterService;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/keys")
public class KeysWordController {

	@Autowired
	private IKeysWordFilterService IKeysWordFilterService;

	@RequestMapping("/listkeys")
	@ResponseBody
	public ObjectResult listKeys() {
		ObjectResult json = null; 
		try {
			List<KeyWords> list=IKeysWordFilterService.listKeys();
			json=new ObjectResult("200", "success",list);
		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}
		return json;		
	}

	@RequestMapping("/addkeys")
	@ResponseBody
	public ObjectResult addKeys(HttpServletRequest request,KeyWords keyWords) {
		ObjectResult json = null; 
		try {
			int i=IKeysWordFilterService.addKeys(keyWords);
			if(i>0) {
				json=new ObjectResult("200", "success","添加成功");
			}else {
				json=new ObjectResult("400", "fail","添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}
		return json;		
	}


	@RequestMapping("/updatekeys")
	@ResponseBody
	public ObjectResult updatekeys(HttpServletRequest request,KeyWords keyWord) {
		ObjectResult json = null; 
		try {
			int i=IKeysWordFilterService.updateKeys(keyWord);
			if(i>0) {
				json=new ObjectResult("200", "success","修改成功");
			}else {
				json=new ObjectResult("400", "fail","修改失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}
}
