package com.xtkj.sql;

import org.apache.ibatis.annotations.Param;

public class ActivitySqlProvider {
	
	public String selectActivitys() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select a.*,t.ACTIVITY_TYPE_NAME,u.NICK_NAME from TB_ACTIVITY a,TB_ACTIVITY_TYPE t,TB_USER u where t.ACTIVITY_TYPE_ID=a.ACTIVITY_TYPE_ID and a.USER_ID=u.USER_ID");
		System.out.println(sbf.toString());
		return sbf.toString();
	}
	
	public String selectHotActivitys() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select (b.cnt*0.5+a.IS_CHARGE*0.3+a.ACTIVITY_VIEW_COUNT*0.2)rank,t.ACTIVITY_TYPE_NAME,u.NICK_NAME,a.*");
		sbf.append(" from TB_ACTIVITY a,(select ACTIVITY_ID,count(*) cnt from TB_ACTIVITY_USER group by ACTIVITY_ID)b,TB_ACTIVITY_TYPE t,TB_USER u");
		sbf.append(" where a.ID=b.ACTIVITY_ID and t.ACTIVITY_TYPE_ID=a.ACTIVITY_TYPE_ID and a.USER_ID=u.USER_ID and a.activity_expired_time>sysDate");
		sbf.append(" AND rownum <=4");
		sbf.append(" order by rank desc");
		System.out.println(sbf.toString());
		return sbf.toString();
	}
	
	public String selectMoreHotActivitys() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select (b.cnt*0.5+a.IS_CHARGE*0.3+a.ACTIVITY_VIEW_COUNT*0.2)rank,t.ACTIVITY_TYPE_NAME,u.NICK_NAME,a.*");
		sbf.append(" from TB_ACTIVITY a,(select ACTIVITY_ID,count(*) cnt from TB_ACTIVITY_USER group by ACTIVITY_ID)b,TB_ACTIVITY_TYPE t,TB_USER u");
		sbf.append(" where a.ID=b.ACTIVITY_ID and t.ACTIVITY_TYPE_ID=a.ACTIVITY_TYPE_ID and a.USER_ID=u.USER_ID and a.activity_expired_time>sysDate");
		sbf.append(" order by rank desc");
		System.out.println(sbf.toString());
		return sbf.toString();
	}
	
	public String selectSameCityActivitys(@Param("location") final String location) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select a.*,t.ACTIVITY_TYPE_NAME,u.NICK_NAME from TB_ACTIVITY a,TB_ACTIVITY_TYPE t,TB_USER u where t.ACTIVITY_TYPE_ID=a.ACTIVITY_TYPE_ID and a.USER_ID=u.USER_ID");
		if(location!=null && !"".equals(location)) {
			sbf.append(" and a.ACTIVITY_LOCATION like '%"+location+"%'");
		}
		sbf.append(" AND rownum <=4");
		System.out.println(sbf.toString());
		return sbf.toString();
	}
	
	public String selectMoreSameCityActivitys(@Param("cityName") final String cityName) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select a.*,t.ACTIVITY_TYPE_NAME,u.NICK_NAME from TB_ACTIVITY a,TB_ACTIVITY_TYPE t,TB_USER u where t.ACTIVITY_TYPE_ID=a.ACTIVITY_TYPE_ID and a.USER_ID=u.USER_ID");
		if(cityName!=null && !"".equals(cityName)) {
			sbf.append(" and a.ACTIVITY_LOCATION like '%"+cityName+"%'");
		}
		System.out.println(sbf.toString());
		return sbf.toString();
	}
	
	public String selectLatestActivitys() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select a.*,t.ACTIVITY_TYPE_NAME,u.NICK_NAME from TB_ACTIVITY a,TB_ACTIVITY_TYPE t,TB_USER u where t.ACTIVITY_TYPE_ID=a.ACTIVITY_TYPE_ID and a.USER_ID=u.USER_ID");
		sbf.append(" and a.UPDATE_TIME > ADD_MONTHS(sysdate, -2)");
		sbf.append(" AND rownum <=4");
		sbf.append(" order by a.CREATE_TIME desc");
		System.out.println(sbf.toString());
		return sbf.toString();
	}
	
	public String selectMoreLatestActivitys() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select a.*,t.ACTIVITY_TYPE_NAME,u.NICK_NAME from TB_ACTIVITY a,TB_ACTIVITY_TYPE t,TB_USER u where t.ACTIVITY_TYPE_ID=a.ACTIVITY_TYPE_ID and a.USER_ID=u.USER_ID");
		sbf.append(" and a.UPDATE_TIME > ADD_MONTHS(sysdate, -2)");
		sbf.append(" order by a.CREATE_TIME desc");
		System.out.println(sbf.toString());
		return sbf.toString();
	}
	
	public String selectActivityByUserId(@Param("userId") final String userId) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select a.*,t.ACTIVITY_TYPE_NAME,u.NICK_NAME from TB_ACTIVITY a,TB_ACTIVITY_TYPE t,TB_USER u where t.ACTIVITY_TYPE_ID=a.ACTIVITY_TYPE_ID and a.USER_ID=u.USER_ID");
		if(userId!=null && "".equals(userId)) {
			sbf.append(" and a.USER_ID=#{userId}");
		}
		sbf.append(" order by a.CREATE_TIME desc");
		return sbf.toString();
	}
}
