package com.xtkj.service.activity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtkj.dao.ActivityMapper;
import com.xtkj.dao.ActivityPhotoAlbumMapper;
import com.xtkj.dao.ActivityTypeMapper;
import com.xtkj.dao.PhotoAlbumMapper;
import com.xtkj.dao.PhotoLibraryMapper;
import com.xtkj.pojo.Activity;
import com.xtkj.pojo.ActivityPhotoAlbum;
import com.xtkj.pojo.ActivityType;
import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.PhotoLibrary;
import com.xtkj.pojo.User;
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private ActivityTypeMapper activityTypeMapper;
	@Autowired
	private ActivityPhotoAlbumMapper activityAlbumMapper;
	@Autowired
	private PhotoAlbumMapper albumMapper;
	@Autowired
	private PhotoLibraryMapper photoLibraryMapper;
	
	/**
	 * 发布活动
	 */
	@Override
	public int publishActivity(Activity activity,User user) {
		int cnt = 0;
		try {
			//创建活动行
			activityMapper.insertSelective(activity);
			//创建相册行
			String albumId = UUID.randomUUID().toString().replace("-", "");
			String albumName = activity.getActivityTitle();
			String albumDefaultPicture = activity.getActivityCover();
			PhotoAlbum photoAlbum = new PhotoAlbum(albumId, new Date(), new Date(), albumName, albumDefaultPicture);
			albumMapper.insertSelective(photoAlbum);
			//创建活动相册映射行
			ActivityPhotoAlbum activityAlbum = new ActivityPhotoAlbum();
			activityAlbum.setActivityId(activity.getId());
			activityAlbum.setPhotoAlbumId(albumId);
			activityAlbum.setCreateTime(new Date());
			activityAlbum.setUpdateTime(new Date());
			cnt = activityAlbumMapper.insertSelective(activityAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public Activity findActivityById(String id) {
		Activity activity = null;
		try {
			activity = activityMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activity;
	}

	@Override
	public List<Activity> getActivityList() {
		List<Activity> activities = null;
		try {
			activities = activityMapper.selectActivitys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activities; 
	}

	@Override
	public PageInfo<Activity> getActivitiesByMap(Map<String, Object> params) {
		PageInfo<Activity> pageInfo = null;
		int offset = (Integer) params.get("offset");
		int limit = (Integer) params.get("limit");
		PageHelper.offsetPage(offset, limit);
		try {
			List<Activity> activitys = activityMapper.selectActivitys();
			pageInfo = new PageInfo<Activity>(activitys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	@Override
	public int modifyActivity(Activity activity) {
		int cnt = 0;
		try {
			cnt = activityMapper.updateByPrimaryKeySelective(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	/**
	 * 删除活动   先查后删
	 */
	@Override
	public int deleteActivity(String activityId) {
		int cnt = 0;
		try {
			//查询活动相册映射行，如果有记录，得到相册编号，删除活动相册映射行
			ActivityPhotoAlbum activityAlbum = activityAlbumMapper.selectByActivityId(activityId);
			if(activityAlbum!=null) {
				activityAlbumMapper.deleteByPrimaryKey(activityAlbum);
				//查询活动相册里的活动对应的照片，如果有记录，则删除活动相册里的活动对应的照片
				List<PhotoLibrary> photos = photoLibraryMapper.selectPhotoByAlbumId(activityAlbum.getPhotoAlbumId());
				if(photos!=null) {
					photoLibraryMapper.deleteByAlbumId(activityAlbum.getPhotoAlbumId());
				}
				//根据相册编号删除相册
				albumMapper.deleteByPrimaryKey(activityAlbum.getPhotoAlbumId());
			}
			//删除活动
			cnt = activityMapper.deleteByPrimaryKey(activityId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ActivityType> getActivityTypes() {
		List<ActivityType> activityTypes = null;
		try {
			activityTypes = activityTypeMapper.selectActivityTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activityTypes;
	}

	@Override
	public List<Activity> getHotActivitys() {
		List<Activity> activities = null;
		try {
			activities = activityMapper.selectHotActivitys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activities;
	}

	@Override
	public List<Activity> getLatestActivitys() {
		List<Activity> activities = null;
		try {
			activities = activityMapper.selectLatestActivitys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activities;
	}

	@Override
	public List<Activity> getSameCityActivitys(String location) {
		List<Activity> activities = null;
		try {
			activities = activityMapper.selectSameCityActivitys(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activities;
	}

	@Override
	public int enrollActivity() {
		
		return 0;
	}

	@Override
	public List<Activity> getMoreHotActivitys() {
		List<Activity> activities = null;
		try {
			activities = activityMapper.selectMoreHotActivitys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activities;
	}

	@Override
	public List<Activity> getMoreLatestActivitys() {
		List<Activity> activities = null;
		try {
			activities = activityMapper.selectMoreLatestActivitys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activities;
	}

	@Override
	public List<Activity> getMoreSameCityActivitys(String cityName) {
		List<Activity> activities = null;
		try {
			activities = activityMapper.selectMoreSameCityActivitys(cityName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activities;
	}

	@Override
	public List<Activity> getActListByUserId(String userId) {
		List<Activity> activitys = activityMapper.selectActivityByUserId(userId);
		return activitys;
	}

}
