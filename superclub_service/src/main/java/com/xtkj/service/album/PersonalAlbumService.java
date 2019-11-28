package com.xtkj.service.album;

import java.util.List;

import com.xtkj.pojo.PersonalPhotoAlbumKey;
import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.User;

public interface PersonalAlbumService {
	//创建个人相册
	public int addPersonalAlbum(String personalAlbumName,User user);
	
	//删除个人相册
	public int deletePersonalAlbum(PersonalPhotoAlbumKey personalPhotoAlbumKey);
	
	//查询个人相册列表(包括游记列表(只有一个游记相册))
	public List<PhotoAlbum> getPersonalAlbums(String userId);
	
	//修改相册名称
	public int modifyAlbumName(PhotoAlbum photoAlbum);
	
}
