package com.xtkj.controller.album;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import com.xtkj.pojo.ActivityPhotoAlbumKey;
import com.xtkj.pojo.PersonalPhotoAlbumKey;
import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.PhotoLibrary;
import com.xtkj.pojo.User;
import com.xtkj.service.album.ActivityAlbumService;
import com.xtkj.service.album.PersonalAlbumService;
import com.xtkj.service.album.PhotoLibraryService;
import com.xtkj.utils.FastDFSClientUtils;
import com.xtkj.utils.IConstant;
import com.xtkj.utils.JSONStringUtils;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/album")
public class AlbumController {
	@Autowired
	@Qualifier("personalAlbumService")
	private PersonalAlbumService personalAlbumService;
	@Autowired
	@Qualifier("activityAlbumService")
	private ActivityAlbumService activityAlbumService;
	@Autowired
	@Qualifier("photoLibraryService")
	private PhotoLibraryService photoLibraryService;

	/**
	 * 获取个人相册列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPersonalAlbums")
	@ResponseBody
	public ObjectResult getPersonalAlbumList(HttpServletRequest request) {
		ObjectResult json = null;
		User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);
		if (user != null) {
			List<PhotoAlbum> personalAlbums = personalAlbumService.getPersonalAlbums(user.getUserId());
			if (personalAlbums != null) {
				json = new ObjectResult("200", "OK", personalAlbums);
			} else {
				json = new ObjectResult("200", "个人相册空空如也，快去创建个人相册吧");
			}
		} else {
			json = new ObjectResult("500", "请登录");
		}
		return json;
	}

	/**
	 * 获取活动相册列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getActivityAlbums")
	@ResponseBody
	public ObjectResult getActivityAlbumList(HttpServletRequest request) {
		ObjectResult json = null;
		User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);
		if (user != null) {
			List<PhotoAlbum> activityAlbums = activityAlbumService.getActivityAlbums(user.getUserId());
			if (activityAlbums != null) {
				json = new ObjectResult("200", "OK", activityAlbums);
			} else {
				json = new ObjectResult("200", "活动相册空空如也，快去创建活动吧");
			}
		} else {
			json = new ObjectResult("500", "请登录");
		}
		return json;
	}

	/**
	 * 根据albumId查询查找相片列表
	 * 
	 * @param albumId
	 * @return
	 */
	@RequestMapping("/getAlbumPhotos")
	@ResponseBody
	public ObjectResult getAlbumPhotos(String albumId) {
		ObjectResult json = null;
		System.err.println(albumId);
		List<PhotoLibrary> albumPhotos = photoLibraryService.getPhotoLibraries(albumId);
		if (albumPhotos != null) {
			json = new ObjectResult("200", "OK", albumPhotos);
		} else {
			json = new ObjectResult("200", "相册空空如也，快去上传照片吧");
		}
		return json;
	}

	/**
	 * 创建个人相册
	 * 
	 * @param personalAlbumName
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPersonalAlbum")
	@ResponseBody
	public ObjectResult addPersonalAlbum(String personalAlbumName, HttpServletRequest request) {
		ObjectResult json = null;
		try {
			User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);
			int cnt = personalAlbumService.addPersonalAlbum(personalAlbumName, user);
			if (cnt > 0) {
				json = new ObjectResult("200", "创建成功");
			} else {
				json = new ObjectResult("500", "创建失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json = new ObjectResult("500", "系统错误");
		}
		return json;
	}

	@RequestMapping("/getPersonalAlbumPhotoCnt")
	@ResponseBody
	public ObjectResult getPersonalAlbumPhotoCnt(String albumId) {
		ObjectResult json = null;
		int photoCnt = photoLibraryService.getAlbumPhotoCnt(albumId);
		json = new ObjectResult("200", "OK", photoCnt);
		return json;
	}

	@RequestMapping("/getTimes")
	@ResponseBody
	public ObjectResult getTimeByAlbumId(String albumId) {
		ObjectResult json = null;
		List<String> timeStrings = photoLibraryService.getTimeByAlbumId(albumId);
		if (timeStrings != null) {
			json = new ObjectResult("200", "OK", timeStrings);
		} else {
			json = new ObjectResult("500", "系统错误");
		}
		return json;
	}

	@RequestMapping("/getPhotosByTime")
	@ResponseBody
	public ObjectResult getPhotos(String albumId, String dateString) {
		ObjectResult json = null;
		SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sbf.parse(dateString);
			dateString = sbf.format(date);
			System.out.println(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<PhotoLibrary> photos = photoLibraryService.getPhotosByTime(albumId, dateString);
		if (photos != null) {
			json = new ObjectResult("200", "OK", photos);
		} else {
			json = new ObjectResult("200", "OK");
		}
		return json;
	}

	@RequestMapping("/uploadPhotos")
	@ResponseBody
	public ObjectResult uploadPhotos(HttpServletRequest request, String albumId, String activityId,
			@RequestParam("files") CommonsMultipartFile[] files) {
		ObjectResult json = null;
		System.err.println(files);
		try {
			System.out.println(files.length);
			List<PhotoLibrary> photoLibraries = new ArrayList<PhotoLibrary>();
			User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);
			for (int i = 0; i < files.length; i++) {
				DiskFileItem fi = (DiskFileItem) files[i].getFileItem();
				File file = fi.getStoreLocation();
				String path = files[i].getOriginalFilename();
				String fileId = FastDFSClientUtils.upload(file, path);
				String ipString = "http://120.79.191.71/";
				String photoUrl = ipString + fileId;
				PhotoLibrary photoLibrary = new PhotoLibrary();
				String id = UUID.randomUUID().toString().replace("-", "");
				photoLibrary.setId(id);
				photoLibrary.setPhotoUrl(photoUrl);
				photoLibrary.setUserId(user.getUserId());
				photoLibrary.setAlbumId(albumId);
				if (activityId != null) {
					photoLibrary.setActivityId(activityId);
				}
				short ok = -1;
				photoLibrary.setOk(ok);
				photoLibrary.setCreateTime(new Date());
				photoLibrary.setUpdateTime(new Date());
				photoLibraries.add(photoLibrary);
			}
			int cnt = photoLibraryService.savePhotos(photoLibraries);
			if (cnt > 0) {
				json = new ObjectResult("200", "上传成功！");
			} else {
				json = new ObjectResult("500", "上传失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json = new ObjectResult("500", "系统错误！");
		}

		return json;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/deletePhotos")
	@ResponseBody
	public ObjectResult deletePhotos(@RequestParam("idString") String idString,@RequestParam("urlString") String urlString) {
		
		ObjectResult json = null;
		try {
			List<String> photoIds = JSONStringUtils.jsonToJava(idString, String.class);
			List<String> photoUrls = JSONStringUtils.jsonToJava(urlString, String.class);
			int cnt = photoLibraryService.deletePhotos(photoUrls,photoIds);
			if (cnt > 0) {
				json = new ObjectResult("200", "删除成功！");
			} else {
				json = new ObjectResult("500", "删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json = new ObjectResult("500", "系统错误！");
		}
		return json;
	}
	@RequestMapping("/modifyAlbum")
	@ResponseBody
	public ObjectResult modifyAlbum(PhotoAlbum photoAlbum) {
		ObjectResult json = null;
		System.out.println("======photoAlbum======="+photoAlbum.getId()+"\t"+photoAlbum.getAlbumName());
		int cnt = personalAlbumService.modifyAlbumName(photoAlbum);
		if (cnt > 0) {
			json = new ObjectResult("200", "修改成功！");
		} else {
			json = new ObjectResult("500", "修改失败！");
		}
		return json;
	}
	@RequestMapping("/deleteAlbum")
	@ResponseBody
	public ObjectResult deleteAlbum(HttpServletRequest request,ActivityPhotoAlbumKey activityPhotoAlbumKey) {
		ObjectResult json = null;
		User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);
		if(activityPhotoAlbumKey.getActivityId()==null || "".equals(activityPhotoAlbumKey.getActivityId())) {
			//删除个人相册
			PersonalPhotoAlbumKey personalPhotoAlbumKey = new PersonalPhotoAlbumKey();
			personalPhotoAlbumKey.setUserId(user.getUserId());
			personalPhotoAlbumKey.setPhotoAlbumId(activityPhotoAlbumKey.getPhotoAlbumId());
			int cnt = personalAlbumService.deletePersonalAlbum(personalPhotoAlbumKey);
			if(cnt >0) {
				json = new ObjectResult("200", "删除个人相册成功");
			}else {
				System.out.println(cnt+"++++++++++++++++++++++");
				json = new ObjectResult("500", "删除个人相册失败");
			}
		}else {
			//删除活动相册
			int cnt = activityAlbumService.deleteActivityAlbum(activityPhotoAlbumKey);
			if(cnt >0) {
				json = new ObjectResult("200", "删除活动相册成功");
			}else {
				json = new ObjectResult("500", "删除活动相册失败");
			}
		}
		return json;
	}
}
