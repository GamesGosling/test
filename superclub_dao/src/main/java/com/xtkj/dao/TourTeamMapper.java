package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.TourTeam;
import com.xtkj.pojo.User;

public interface TourTeamMapper {
	int deleteByPrimaryKey(String id);

	int insert(TourTeam record);

	int insertSelective(TourTeam record);

	TourTeam selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(TourTeam record);

	int updateByPrimaryKey(TourTeam record);

	/**
	 * -用户参加的活动列表
	 * 
	 * @param userId
	 * @return
	 */
	@Select("select * from tb_tour_team where team_id in(select team_id from tb_user_team_map where user_id =#{userId})")
	@ResultMap("com.xtkj.dao.TourTeamMapper.BaseResultMap")
	List<TourTeam> listTourTeam(User user);

	/**
	 * 插入驴友队相册中间表
	 * 
	 * @param tourTeam
	 * @param photoAlbum
	 * @return
	 */
	@Insert("insert into tb_team_photo_album_map values(#{teamId},#{id},sysdate,sysdate)")
	int createTourTeamAlbum(@Param("teamId") TourTeam tourTeam, @Param("id") PhotoAlbum photoAlbum);

	/**
	 * 查看当前用户是否在驴友队中
	 * 
	 * @param map
	 * @return
	 */
	@Select("select * from tb_user where user_id =(select user_Id  from tb_user_role_map  where user_id =#{userId} and team_id=#{teamId})")
	User checkExistUserinTeam(User user, TourTeam tourTeam);

	/**
	 * 加入驴友队
	 * 
	 * @param user
	 * @param tourTeam
	 * @return
	 */
	@Insert("insert into tb_user_role_map values(#{userId},4,sysdate,sysdate,#{teamId})")
	int addTourTeam(@Param("userId") User user, @Param("teamId") TourTeam tourTeam);

	/**
	 * 退出驴友队
	 * 
	 * @param user
	 * @param tourTeam
	 * @return
	 */
	@Delete("delete from tb_user_role_map where user_id =#{userId} and team_id = #{teamId}")
	int outTourTeam(@Param("userId") User user, @Param("teamId") TourTeam tourTeam);

	/**
	 * 查看驴友队中是否存在副队长
	 * 
	 * @param tourTeam
	 * @return
	 */
	@Select("select * from tb_user where user_id =(select user_id  from tb_user_role_map where role_id =2 and team_id =#{teamId})")
	@ResultMap("com.xtkj.dao.UserMapper.BaseResultMap")
	User viceLeaderIsExist(TourTeam tourTeam);

	/**
	 * 任命副队长
	 * 
	 * @param user
	 * @param tourTeam
	 * @return
	 */
	@Update("update tb_user_role_map set role_id =2 where user_id = #{userId} and team_id = #{teamId}")
	int appointViceLeader(@Param("userId") User user, @Param("teamId") TourTeam tourTeam);

	/**
	 * 取消任命副队长
	 * 
	 * @param user
	 * @param tourTeam
	 * @return
	 */
	@Update("update tb_user_role_map set role_id =4 where user_id = #{userId} and team_id = #{teamId}")
	int cancelViceLeader(@Param("userId") User user, @Param("teamId") TourTeam tourTeam);

	/**
	 * 任命管理员
	 * 
	 * @param user
	 * @param tourTeam
	 * @return
	 */
	@Update("update tb_user_role_map set role_id =3 where user_id = #{userId} and team_id = #{teamId}")
	int appointMger(User user, TourTeam tourTeam);

	/**
	 * 查看驴友队管理员的人数
	 * 
	 * @param tourTeam
	 * @return
	 */
	@Select("select * from tb_user  where user_id in (select user_id from tb_user_role_map where team_id =#{teamId} and role_id =3)")
	@ResultMap("com.xtkj.dao.UserMapper.BaseResultMap")
	List<User> chekMgrCnt(TourTeam tourTeam);
	
	
	/**
	 * 查看驴友队的队长人数
	 * @param tourTeam
	 * @return
	 */
	@Select("select * from tb_user  where user_id in (select user_id from tb_user_role_map where team_id =#{teamId} and role_id =1)")
	@ResultMap("com.xtkj.dao.UserMapper.BaseResultMap")
	List<User> checkLeaderCnt(TourTeam tourTeam);
	
	

	/**
	 * 转让驴友队
	 * @param tourTeam
	 * @param leader
	 * @return
	 */
	@Update("update tb_user_role_map set role_id =1 where user_id = #{userId} and team_id = #{teamId}")
	int assignTourTeam(TourTeam tourTeam,User leader);

}