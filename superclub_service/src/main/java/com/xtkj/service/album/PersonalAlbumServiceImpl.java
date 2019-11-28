package com.xtkj.service.album;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.PersonalPhotoAlbumMapper;
import com.xtkj.dao.PhotoAlbumMapper;
import com.xtkj.dao.PhotoLibraryMapper;
import com.xtkj.pojo.PersonalPhotoAlbum;
import com.xtkj.pojo.PersonalPhotoAlbumKey;
import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.User;
@Service("personalAlbumService")
public class PersonalAlbumServiceImpl implements PersonalAlbumService {
	@Autowired
	private PersonalPhotoAlbumMapper personalAlbumMapper;
	@Autowired
	private PhotoAlbumMapper albumMapper;
	@Autowired
	private PhotoLibraryMapper photoLibraryMapper;
	
	@Override
	public int addPersonalAlbum(String albumName,User user) {
		 int cnt = 0; 
		try {
			//创建相册
			String albumId = UUID.randomUUID().toString().replace("_", "");
			String albumDefaultPictureString = "http://120.79.191.71/group1/M00/00/01/rBEPOV0Zz6-AbVrGAAAjYA7E4Ew780.jpg";
			PhotoAlbum photoAlbum = new PhotoAlbum(albumId, new Date(), new Date(), albumName, albumDefaultPictureString);
			albumMapper.insertSelective(photoAlbum);
			//添加个人相册映射行
			PersonalPhotoAlbum personalPhotoAlbum = new PersonalPhotoAlbum(user.getUserId(), albumId, new Date(), new Date());
			  cnt = personalAlbumMapper.insertSelective(personalPhotoAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	
	}

	@Override
	public int deletePersonalAlbum(PersonalPhotoAlbumKey personalPhotoAlbumKey) {
		int cnt = 0;
		try {
			//删除个人相册映射行
			personalAlbumMapper.deleteByPrimaryKey(personalPhotoAlbumKey);
			//删除个人相册里对应的照片
			int photoNum = photoLibraryMapper.selectAlbumPhotoCnt(personalPhotoAlbumKey.getPhotoAlbumId());
			if(photoNum>0) {
				photoLibraryMapper.deleteByAlbumId(personalPhotoAlbumKey.getPhotoAlbumId());
			}
			//删除相册
			cnt = albumMapper.deleteByPrimaryKey(personalPhotoAlbumKey.getPhotoAlbumId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<PhotoAlbum> getPersonalAlbums(String userId) {
		List<PhotoAlbum> personalAlbums = null;
		try {
			personalAlbums = albumMapper.selectPersonAlbums(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personalAlbums;
	}

	@Override
	public int modifyAlbumName(PhotoAlbum photoAlbum) {
		int cnt = 0;
		try {
			cnt = albumMapper.updateByPrimaryKeySelective(photoAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
