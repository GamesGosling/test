package com.xtkj.controller.activity;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageInfo;
import com.xtkj.pojo.Activity;
import com.xtkj.pojo.ActivityType;
import com.xtkj.pojo.User;
import com.xtkj.service.activity.ActivityService;
import com.xtkj.utils.FastDFSClientUtils;
import com.xtkj.utils.IConstant;
import com.xtkj.utils.ObjectResult;
@Controller
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	/**
	 * 发布活动
	 * @param request
	 * @param activity
	 * @param picture
	 * @return
	 */
	@RequestMapping("/publish")
	@ResponseBody
	public ObjectResult publishActivity(HttpServletRequest request,Activity activity,@RequestParam("picture") CommonsMultipartFile picture) {
		System.out.println(activity.toString());
		ObjectResult json = null;
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			activity.setId(id);
			User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);
			activity.setUser(user);
			ActivityType activityType = new ActivityType();
			String activityTypeId = request.getParameter("activityTypeId");
			activityType.setActivityTypeId(activityTypeId);
			activity.setActivityType(activityType);
			//获取手机唯一识别码
			//上传图片
			DiskFileItem fi = (DiskFileItem)picture.getFileItem(); 
			File file = fi.getStoreLocation(); 
			String path = picture.getOriginalFilename();
			String fileId = FastDFSClientUtils.upload(file, path);
			String ipString = "http://120.79.191.71/";
			String photoUrl = ipString+fileId;
			activity.setActivityCover(photoUrl);
			
			String ip = request.getRemoteAddr();
			activity.setIp(ip);
			activity.setCreateTime(new Date());
			activity.setUpdateTime(new Date());
			int cnt = activityService.publishActivity(activity,user); 
			if(cnt>0) { 
				json = new ObjectResult("200", "活动保存成功");
			}else { 
				json = new ObjectResult("500","保存失败"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("/findList")
	@ResponseBody
	public ObjectResult findActivitys(int limit,int offset) {
		ObjectResult json = null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("limit", limit);
		params.put("offset", offset);
		if(params!=null) {
			PageInfo<Activity> pageInfo=activityService.getActivitiesByMap(params);
			json = new ObjectResult("200", "Ok",pageInfo);
		}
		return json;
	}
	@RequestMapping("/modify")
	@ResponseBody
	public ObjectResult modifyActivity(Activity activity) {
		ObjectResult json = null;
		int cnt = activityService.modifyActivity(activity);
		if(cnt>0) {
			json = new ObjectResult("200", "修改成功");
		}else {
			json = new ObjectResult("500", "修改失败");
		}
		return json;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public ObjectResult deleteActivity(Activity activity) {
		ObjectResult json = null;
		int cnt = activityService.deleteActivity(activity.getId());
		if(cnt>0) {
			json = new ObjectResult("200", "删除成功");
		}else {
			json = new ObjectResult("500", "删除失败");
		}
		return json;
	}
	@RequestMapping("/findTypeList")
	@ResponseBody
	public ObjectResult getActivityTypes() {
		ObjectResult json = null;
		List<ActivityType> activityTypes = activityService.getActivityTypes();
		if(activityTypes!=null) {
			json = new ObjectResult("200", "OK", activityTypes);
		}else {
			json = new ObjectResult("500", "查询失败");
		}
		return json;
	}
	@RequestMapping("/findHotList")
	@ResponseBody
	public ObjectResult getHotActivityList() {
		ObjectResult json = null;
		List<Activity> hotActivitys = activityService.getHotActivitys();
		if(hotActivitys!=null) {
			json = new ObjectResult("200", "OK", hotActivitys);
		}else {
			json = new ObjectResult("500", "没找到热门活动");
		}
		return json;
	}
	@RequestMapping("/findMoreHotList")
	@ResponseBody
	public ObjectResult getMoreHotActivitys() {
		ObjectResult json = null;
		List<Activity> hotActivitys = activityService.getMoreHotActivitys();
		if(hotActivitys!=null) {
			json = new ObjectResult("200", "OK", hotActivitys);
		}else {
			json = new ObjectResult("500", "没找到热门活动");
		}
		return json;
	}
	@RequestMapping("/findLatestList")
	@ResponseBody
	public ObjectResult getLatestActivitys() {
		ObjectResult json = null;
		List<Activity> latestActivitys = activityService.getLatestActivitys();
		if(latestActivitys!=null) {
			json = new ObjectResult("200", "OK", latestActivitys);
		}else {
			json = new ObjectResult("500", "没找到最新活动");
		}
		return json;
	}
	@RequestMapping("/findMoreLatestList")
	@ResponseBody
	public ObjectResult getMoreLatestActivitys() {
		ObjectResult json = null;
		List<Activity> latestActivitys = activityService.getMoreLatestActivitys();
		if(latestActivitys!=null) {
			json = new ObjectResult("200", "OK", latestActivitys);
		}else {
			json = new ObjectResult("500", "没找到最新活动");
		}
		return json;
	}
	@RequestMapping("/findSameCityList")
	@ResponseBody
	public ObjectResult getSameCityActivitys(String location) {
		ObjectResult json = null;
		List<Activity> latestActivitys = activityService.getSameCityActivitys(location);
		if(latestActivitys!=null) {
			json = new ObjectResult("200", "OK", latestActivitys);
		}else {
			json = new ObjectResult("500", "没找到同城活动");
		}
		return json;
	}
	
	@RequestMapping("/findMoreSameCityList")
	@ResponseBody
	public ObjectResult getMoreSameCityActivitys(String location) {
		ObjectResult json = null;
		List<Activity> latestActivitys = activityService.getMoreSameCityActivitys(location);
		if(latestActivitys!=null) {
			json = new ObjectResult("200", "OK", latestActivitys);
		}else {
			json = new ObjectResult("500", "没找到同城活动");
		}
		return json;
	}
	@RequestMapping("/enroll")
	@ResponseBody
	public ObjectResult enrollActivity() {
		
		return null;
	}
	
	@RequestMapping("/activityDetail")
	public String activityDetail(HttpServletRequest request,String activityId) {
		Activity activity = activityService.findActivityById(activityId);
		request.setAttribute("activity", activity);
		if(activity!=null) {
			return "forward:/pages/activity/activitydetail.jsp";
		}else {
			return "redirect:/pages/main.jsp";
		}
	}
	
	
	@RequestMapping("/uploadUEditorImage")
	@ResponseBody
	public Map<String, Object> uploadUEditorImage(@RequestParam("upfile") CommonsMultipartFile upfile) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			DiskFileItem fi = (DiskFileItem)upfile.getFileItem(); 
			File file = fi.getStoreLocation(); 
			String path = upfile.getOriginalFilename();
			String fileId = FastDFSClientUtils.upload(file, path);
			String ipString = "http://120.79.191.71/";
			String photoUrl = ipString+fileId;
			map.put("state", "上传成功");
			map.put("url", photoUrl);
			map.put("title", path);
			map.put("original", path);
		} catch (Exception e) {
			e.printStackTrace();
			map = null;
		}
		return map;
	}
	
	@RequestMapping("/getListByUserId")
	@ResponseBody
	public ObjectResult getActivityListByUserId(String userId) {
		ObjectResult json = null;
		try {
			List<Activity> activities = activityService.getActListByUserId(userId);
			if(activities!=null) {
				json = new ObjectResult("200", "Ok",activities);
			}else {
				json = new ObjectResult("200", "您还没有发布任何活动哦，赶快去发布自己的活动吧");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json = new ObjectResult("500", "系统错误");
		}
		return json;
	}
}

