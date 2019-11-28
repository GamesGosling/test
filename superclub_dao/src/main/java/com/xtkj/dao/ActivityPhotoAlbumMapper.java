package com.xtkj.dao;

import com.xtkj.pojo.ActivityPhotoAlbum;
import com.xtkj.pojo.ActivityPhotoAlbumKey;

public interface ActivityPhotoAlbumMapper {
    int deleteByPrimaryKey(ActivityPhotoAlbumKey key)throws Exception;

    int insert(ActivityPhotoAlbum record)throws Exception;

    int insertSelective(ActivityPhotoAlbum record)throws Exception;

    ActivityPhotoAlbum selectByPrimaryKey(ActivityPhotoAlbumKey key)throws Exception;

    int updateByPrimaryKeySelective(ActivityPhotoAlbum record)throws Exception;

    int updateByPrimaryKey(ActivityPhotoAlbum record)throws Exception;
    
    ActivityPhotoAlbum selectByActivityId(String activityId)throws Exception;
}