package com.xtkj.service.tourteam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.PhotoAlbumMapper;
import com.xtkj.dao.TourTeamMapper;
import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.TourTeam;
import com.xtkj.pojo.User;

@Service
public class TourTeamServiceImpl implements ITourTeamService {

	@Autowired
	private TourTeamMapper tourTeamMapper;
	@Autowired
	private PhotoAlbumMapper photoAlbumMapper;

	/**
	 * 获取当前用户参加的驴友队列表
	 */
	@Override
	public List<TourTeam> listTourTeam(User user) {
		return tourTeamMapper.listTourTeam(user);
	}

	/**
	 * 创建驴友队
	 */
	@Override
	public Integer createTourTeam(TourTeam tourTeam, PhotoAlbum photoAlbum) throws Exception {

		// 创建默认相册
		int i = photoAlbumMapper.insertSelective(photoAlbum);
		// 与驴友队创建连接
		int n = tourTeamMapper.createTourTeamAlbum(tourTeam, photoAlbum);

		int m = tourTeamMapper.insertSelective(tourTeam);
		return i + n + m;
	}

	/**
	 * 参加驴友队
	 * 
	 * @param tourTeam
	 * @param user
	 * @return
	 */
	@Override
	public int addTourTeam(TourTeam tourTeam, User user) {
		int i = 0;
		User userIsExist = tourTeamMapper.checkExistUserinTeam(user, tourTeam);
		if (userIsExist != null) {
			i = 2;
			System.out.println("驴友队已经存在该用户");
			return i;

		} else {
			i = tourTeamMapper.addTourTeam(user, tourTeam);
		}
		return i;
	}
	
	/**
	 * 退出驴友队
	 */
	@Override
	public int outTourTam(TourTeam tourTeam, User user) {
		return tourTeamMapper.outTourTeam(user, tourTeam);
	}

	/**
	 * 任命副队长
	 */
	@Override
	public int appointViceLeader(TourTeam tourTeam, User user) {
		int i = 0;
		User usr = tourTeamMapper.viceLeaderIsExist(tourTeam);// 判断是否有副队长
		if (usr == null) {
			i = tourTeamMapper.appointViceLeader(user, tourTeam);// 任命副队长
		} else {
			i = 2;// 已经存在
		}
		return i;

	}

	/**
	 * 取消副队长
	 */
	@Override
	public int cancelViceLeader(TourTeam tourTeam, User user) {
		return tourTeamMapper.cancelViceLeader(user, tourTeam);
	}

	/**
	 * 任命管理员
	 */
	@Override
	public int appointMger(User user, TourTeam tourTeam) {
		return tourTeamMapper.appointMger(user, tourTeam);
	}

	/**
	 * 查看该驴友队管理员的人数
	 */
	@Override
	public List<User> checkMgrCnt(TourTeam tourTeam) {
		return tourTeamMapper.chekMgrCnt(tourTeam);

	}

	/**
	 * 转让驴友队
	 */
	@Override
	public int assignLeader(User leader, TourTeam tourTeam) {
		return tourTeamMapper.assignTourTeam(tourTeam, leader);
	}

	/**
	 * 查看驴友队队长数量
	 */
	@Override
	public List<User> checkLeaderCnt(TourTeam tourTeam) {
		return tourTeamMapper.checkLeaderCnt(tourTeam);
	}

}
