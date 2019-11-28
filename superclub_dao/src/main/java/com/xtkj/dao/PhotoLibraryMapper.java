package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.PhotoLibrary;

public interface PhotoLibraryMapper {
    int deleteByPrimaryKey(String id)throws Exception;

    int insert(PhotoLibrary record)throws Exception;

    int insertSelective(PhotoLibrary record)throws Exception;

    PhotoLibrary selectByPrimaryKey(String id)throws Exception;

    int updateByPrimaryKeySelective(PhotoLibrary record)throws Exception;

    int updateByPrimaryKey(PhotoLibrary record)throws Exception;
    //根据相册编号删除相片
	int deleteByAlbumId(String albumId)throws Exception;
	//根据相册编号查询
	List<PhotoLibrary> selectPhotoByAlbumId(String albumId)throws Exception;
	//根据相册编号查询照片数
	int selectAlbumPhotoCnt(String albumId)throws Exception;
	
	//查询相册里图片创建日期列表
	List<String> selectTimeByAlbumId(String albumId);
	
	@Select("select * from TB_PHOTO_LIBRARY where ALBUM_ID='${albumId}' and TO_CHAR(CREATE_TIME,'yyyy-MM-dd') = '${dateString}'")
	@ResultMap("BaseResultMap")
	List<PhotoLibrary> selectPhotosByTime(@Param("albumId") String albumId, @Param("dateString") String dateString);
}