package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.xtkj.pojo.Activity;
import com.xtkj.sql.ActivitySqlProvider;

public interface ActivityMapper {
	
    int deleteByPrimaryKey(String id)throws Exception;

    int insert(Activity record)throws Exception;
    //添加活动
    int insertSelective(Activity record)throws Exception;
    /**
     * 根据主键查询活动详情
     * @param id
     * @return
     * @throws Exception
     */
    Activity selectByPrimaryKey(String id)throws Exception;
    
    int updateByPrimaryKeySelective(Activity activity)throws Exception;

    int updateByPrimaryKey(Activity activity)throws Exception;
    
    //活动列表
    @SelectProvider(type =ActivitySqlProvider.class,method ="selectActivitys")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectActivitys()throws Exception;
    //热门活动列表前四行
    @SelectProvider(type =ActivitySqlProvider.class,method ="selectHotActivitys")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectHotActivitys()throws Exception;
    //查找更多活动更多行
    @SelectProvider(type =ActivitySqlProvider.class,method ="selectMoreHotActivitys")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectMoreHotActivitys()throws Exception;
    
    //同城活动列表前四行
    @SelectProvider(type =ActivitySqlProvider.class,method ="selectSameCityActivitys")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectSameCityActivitys(String location)throws Exception;
    
    //同城活动列表更多行
    @SelectProvider(type =ActivitySqlProvider.class,method ="selectMoreSameCityActivitys")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectMoreSameCityActivitys(String cityName)throws Exception;
    
    //最新活动列表前四行
    @SelectProvider(type =ActivitySqlProvider.class,method ="selectLatestActivitys")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectLatestActivitys()throws Exception;
    
    //最新活动列表更多行
    @SelectProvider(type =ActivitySqlProvider.class,method ="selectMoreLatestActivitys")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectMoreLatestActivitys()throws Exception;
    
    @Select("select * from TB_ACTIVITY WHERE OK=0")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectByIsOK();
    
    //根据用户id查询活动列表
    @SelectProvider(type =ActivitySqlProvider.class,method ="selectActivityByUserId")
    @ResultMap("ActivityHasActTypeAndUser")
    List<Activity> selectActivityByUserId(String userId);
}