package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.LoginHistory;

public interface LoginHistoryMapper {
	
	@Insert("insert into tb_logiin_history values(#{id},#{userId},#{loginType},null,#{ip},#{loginAddress},null,sysdate)")
    int addLoginHistory(LoginHistory record);
	
	@Select("select extract(YEAR from LOGIN_TIME) as dates,ADDRESS, count(*) sum from HXX.TB_LOGIIN_HISTORY GROUP BY (extract(YEAR from LOGIN_TIME)),LOGIN_ADDRESS ORDER BY extract(YEAR from LOGIN_TIME)")
	List<LoginHistory> selectYear();
	
	@Select("select to_char(LOGIN_TIME,'yyyy-mm') dates,LOGIN_ADDRESS ADDRESS,count(*) sum \r\n" + 
			"from HXX.TB_LOGIIN_HISTORY group by to_char(LOGIN_TIME,'yyyy-mm'),LOGIN_ADDRESS order by to_char(LOGIN_TIME,'yyyy-mm')")
	List<LoginHistory> selectMonth();
	
	@Select("select to_char(LOGIN_TIME,'yyyy-Q') dates,DECODE(extract(MONTH from TO_DATE(to_char(LOGIN_TIME,'yyyy-Q'), 'yyyy-mm')),1,'春',2,'夏',3,'秋','冬') QUARTER,LOGIN_ADDRESS ADDRESS,count(*) sum \r\n" + 
			"from HXX.TB_LOGIIN_HISTORY group by to_char(LOGIN_TIME,'yyyy-Q'),LOGIN_ADDRESS order by to_char(LOGIN_TIME,'yyyy-Q')")
	List<LoginHistory> selectQuarter();
	
	@Select("select to_char(LOGIN_TIME,'yyyy-MM-dd') dates,LOGIN_ADDRESS ADDRESS,count(*) sum \r\n" + 
			"from HXX.TB_LOGIIN_HISTORY group by to_char(LOGIN_TIME,'yyyy-MM-dd'),LOGIN_ADDRESS order by to_char(LOGIN_TIME,'yyyy-MM-dd')")
	List<LoginHistory> selectDay();
	
}