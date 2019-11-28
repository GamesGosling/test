package com.xtkj.dao;

import com.xtkj.pojo.TravelPhotoAlbum;
import com.xtkj.pojo.TravelPhotoAlbumKey;

public interface TravelPhotoAlbumMapper {
    int deleteByPrimaryKey(TravelPhotoAlbumKey key);

    int insert(TravelPhotoAlbum record);

    int insertSelective(TravelPhotoAlbum record);

    TravelPhotoAlbum selectByPrimaryKey(TravelPhotoAlbumKey key);

    int updateByPrimaryKeySelective(TravelPhotoAlbum record);

    int updateByPrimaryKey(TravelPhotoAlbum record);
}