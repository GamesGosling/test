package com.xtkj.service.album;

import java.util.List;

import com.xtkj.pojo.PhotoLibrary;

public interface PhotoLibraryService {
	
	//删除相册照片(选择照片批量删除)
	//根据albumId和photoId删除一张照片
	public int deletePhotos(List<String> uriString,List<String> idStrings);
	
	//上传相册照片(选择照片批量上传)
	public int savePhotos(List<PhotoLibrary> photoLibrarys);
	
	//获得相册照片列表
	public List<PhotoLibrary> getPhotoLibraries(String albumId);
	
	public int getAlbumPhotoCnt(String albumId);
	
	public List<String> getTimeByAlbumId(String albumId);
	
	public List<PhotoLibrary> getPhotosByTime(String albumId,String dateString);
}
