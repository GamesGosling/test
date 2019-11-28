package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.PhotoAlbum;

public interface PhotoAlbumMapper {
	
    int deleteByPrimaryKey(@Param("id") String id)throws Exception;

    int insert(PhotoAlbum record)throws Exception;

    int insertSelective(PhotoAlbum record)throws Exception;

    PhotoAlbum selectByPrimaryKey(String id)throws Exception;

    int updateByPrimaryKeySelective(PhotoAlbum record)throws Exception;

    int updateByPrimaryKey(PhotoAlbum record)throws Exception;
    //查询用户活动相册列表
    @Select("select t.*,p.ACTIVITY_ID from TB_ACTIVITY a,TB_PHOTO_ALBUM t,TB_ACTIVITY_PHOTO_ALBUM p where t.ID=p.PHOTO_ALBUM_ID and a.ID=p.ACTIVITY_ID and a.USER_ID=#{userId} order by t.CREATE_TIME DESC")
    @ResultMap("AlbumResultHasActIdMap")
    List<PhotoAlbum> selectActivityAlbums(@Param("userId") String userId)throws Exception;
    
    //查询用户活动相册列表(包括游记相册(只有一个游记相册))
    @Select("select a.* from TB_PHOTO_ALBUM a,TB_PERSONAL_PHOTO_ALBUM P where a.ID=p.PHOTO_ALBUM_ID and p.USER_ID=#{userId} order by a.CREATE_TIME DESC")
    @ResultMap("BaseResultMap")
    List<PhotoAlbum> selectPersonAlbums(@Param("userId") String userId)throws Exception;
}