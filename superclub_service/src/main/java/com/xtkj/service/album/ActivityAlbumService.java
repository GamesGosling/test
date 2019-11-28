package com.xtkj.service.album;

import java.util.List;

import com.xtkj.pojo.ActivityPhotoAlbumKey;
import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.User;

public interface ActivityAlbumService {
	
	//删除活动相册
	public int deleteActivityAlbum(ActivityPhotoAlbumKey activityPhotoAlbumKey);
	
	//查询用户活动相册列表
	public List<PhotoAlbum> getActivityAlbums(String userId);
	
	//移到个人相册
	public int moveActivityAlbumtoPersonal(ActivityPhotoAlbumKey activityPhotoAlbumKey,User user);
}
