package com.xtkj.service.album;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.PhotoLibraryMapper;
import com.xtkj.pojo.PhotoLibrary;
import com.xtkj.utils.FastDFSClientUtils;
@Service("photoLibraryService")
public class PhotoLibraryServiceImpl implements PhotoLibraryService {
	@Autowired
	private PhotoLibraryMapper photoLibraryMapper;

	@Override
	public int deletePhotos(List<String> uriString,List<String> idStrings) {
		int cnt = 0;
		try {

			for (int i = 0; i < idStrings.size(); i++) { 
				cnt=photoLibraryMapper.deleteByPrimaryKey(idStrings.get(i)); 
			}

			for(String uri:uriString) {
				FastDFSClientUtils.delete("group1", uri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int savePhotos(List<PhotoLibrary> photoLibrarys) {
		int cnt = 0;
		try {
			for (PhotoLibrary photoLibrary : photoLibrarys) {
				cnt = photoLibraryMapper.insertSelective(photoLibrary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<PhotoLibrary> getPhotoLibraries(String albumId) {
		List<PhotoLibrary> photoLibraries = null;
		try {
			photoLibraries = photoLibraryMapper.selectPhotoByAlbumId(albumId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photoLibraries;
	}
	/**
	 * 获取相册中相片个数
	 */
	@Override
	public int getAlbumPhotoCnt(String albumId) {
		int cnt = 0;
		try {
			cnt = photoLibraryMapper.selectAlbumPhotoCnt(albumId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<String> getTimeByAlbumId(String albumId) {
		List<String> times = null;
		times = photoLibraryMapper.selectTimeByAlbumId(albumId);
		if(times!=null) {
			return times;
		}else {
			return null;
		}
	}

	@Override
	public List<PhotoLibrary> getPhotosByTime(String albumId, String dateString) {
		List<PhotoLibrary> photos = photoLibraryMapper.selectPhotosByTime(albumId, dateString);
		return photos;
	}



}
