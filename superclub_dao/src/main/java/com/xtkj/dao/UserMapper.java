package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.User;

public interface UserMapper {
	
	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/*
	 * 通过用户电话号码查找用户
	 */
	@Select("SELECT * FROM TB_USER WHERE TELEPHONE =#{telephone}")
	@ResultMap("com.xtkj.dao.UserMapper.BaseResultMap")
	User checkLogin(String userTel);

	/*
	 * 所有用户
	 */
	@Select("SELECT * FROM TB_USER")
	@ResultMap("com.xtkj.dao.UserMapper.BaseResultMap")
	List<User> listUser();
	
	/*
	 *  -分类查询
	 */
	@Select("select extract(YEAR from CREATEDTM) as dates,city ADDRESS, count(*) sum from HXX.TB_USER GROUP BY (extract(YEAR from CREATEDTM)),city ORDER BY extract(YEAR from CREATEDTM)")
	List<User> listUserOnYear();
	
	@Select("select to_char(CREATEDTM,'yyyy-Q') dates,DECODE(extract(MONTH from TO_DATE(to_char(CREATEDTM,'yyyy-Q'), 'yyyy-mm')),1,'春',2,'夏',3,'秋','冬') QUARTER,city ADDRESS,count(*) sum \r\n" + 
			"from HXX.TB_USER group by to_char(CREATEDTM,'yyyy-Q'),city order by to_char(CREATEDTM,'yyyy-Q')")
	List<User> listUserOnQuarter();
	
	@Select("select to_char(CREATEDTM,'yyyy-mm') dates,city ADDRESS,count(*) sum \r\n" + 
			"from HXX.TB_USER group by to_char(CREATEDTM,'yyyy-mm'),city order by to_char(CREATEDTM,'yyyy-mm')")
	List<User> listUserOnMonth();
	
	@Select("select to_char(CREATEDTM,'yyyy-MM-dd') dates,city ADDRESS,count(*) sum \r\n" + 
			"from HXX.TB_USER group by to_char(CREATEDTM,'yyyy-MM-dd'),city order by to_char(CREATEDTM,'yyyy-MM-dd')")
	List<User> listUserOnDay();
	
	
}