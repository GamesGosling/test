package com.xtkj.dao;

import com.xtkj.pojo.PersonalPhotoAlbum;
import com.xtkj.pojo.PersonalPhotoAlbumKey;

public interface PersonalPhotoAlbumMapper {
    int deleteByPrimaryKey(PersonalPhotoAlbumKey key)throws Exception;

    int insert(PersonalPhotoAlbum record)throws Exception;

    int insertSelective(PersonalPhotoAlbum record)throws Exception;

    PersonalPhotoAlbum selectByPrimaryKey(PersonalPhotoAlbumKey key)throws Exception;

    int updateByPrimaryKeySelective(PersonalPhotoAlbum record)throws Exception;

    int updateByPrimaryKey(PersonalPhotoAlbum record)throws Exception;
}