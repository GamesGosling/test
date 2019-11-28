package com.xtkj.service.album;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.ActivityPhotoAlbumMapper;
import com.xtkj.dao.PersonalPhotoAlbumMapper;
import com.xtkj.dao.PhotoAlbumMapper;
import com.xtkj.dao.PhotoLibraryMapper;
import com.xtkj.pojo.ActivityPhotoAlbumKey;
import com.xtkj.pojo.PersonalPhotoAlbum;
import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.User;
@Service("activityAlbumService")
public class ActivityAlbumServiceImpl implements ActivityAlbumService {
	
	@Autowired
	private ActivityPhotoAlbumMapper activityAlbumMapper;
	@Autowired
	private PhotoAlbumMapper albumMapper;
	@Autowired
	private PhotoLibraryMapper photoLibraryMapper;
	
	private PersonalPhotoAlbumMapper personalAlbumMapper;
	/**
	 *删除活动相册
	 */
	@Override
	public int deleteActivityAlbum(ActivityPhotoAlbumKey activityPhotoAlbumKey) {
		int cnt = 0;
		try {
			//删除活动相册映射行
			activityAlbumMapper.deleteByPrimaryKey(activityPhotoAlbumKey);
			//删除照片
			int photoNum = photoLibraryMapper.selectAlbumPhotoCnt(activityPhotoAlbumKey.getPhotoAlbumId());
			if(photoNum>0) {
				photoLibraryMapper.deleteByAlbumId(activityPhotoAlbumKey.getPhotoAlbumId());
				
			}
			//删除相册
			cnt = albumMapper.deleteByPrimaryKey(activityPhotoAlbumKey.getPhotoAlbumId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 查询用户 活动相册  列表
	 */
	@Override
	public List<PhotoAlbum> getActivityAlbums(String userId) {
		List<PhotoAlbum> photoAlbums = null;
		try {
			photoAlbums = albumMapper.selectActivityAlbums(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photoAlbums;
	}
	/**
	 * 移动到个人相册
	 */
	@Override
	public int moveActivityAlbumtoPersonal(ActivityPhotoAlbumKey activityPhotoAlbumKey,User user) {
		int cnt = 0;
		try {
			//删除活动活动相册映射
			activityAlbumMapper.deleteByPrimaryKey(activityPhotoAlbumKey);
			//创建个人相册映射
			PersonalPhotoAlbum personalAlbum = new PersonalPhotoAlbum(user.getUserId(), activityPhotoAlbumKey.getPhotoAlbumId(), new Date(), new Date());
			cnt = personalAlbumMapper.insertSelective(personalAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
