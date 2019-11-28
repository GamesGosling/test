package com.xtkj.controller.activity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xtkj.utils.FastDFSClientUtils;
@Controller
@RequestMapping("/upload")
public class uploadUEditorImageController {

	
	@RequestMapping("/uploadUEditorImage")
	@ResponseBody
	public Map<String, Object> uploadUEditorImage(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			MultipartRequest multipartRequest = (MultipartRequest) request;
			CommonsMultipartFile files = (CommonsMultipartFile) multipartRequest.getFile("upfile");
			DiskFileItem fis=(DiskFileItem)files.getFileItem();
			File file = fis.getStoreLocation();

			String path = files.getOriginalFilename();
			String fileId = FastDFSClientUtils.upload(file, path);
			//String ipString = "http://120.79.191.71/";
			//String photoUrl = ipString+fileId;
			map.put("state", "上传成功");
			map.put("url", fileId);
			map.put("title", path);
		} catch (Exception e) {
			e.printStackTrace();
			map = null;
		}
		return map;
	}

}
