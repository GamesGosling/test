package com.xtkj.service.tourteam;

import java.util.List;

import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.TourTeam;
import com.xtkj.pojo.User;

public interface ITourTeamService {

	List<TourTeam> listTourTeam(User user);

	Integer createTourTeam(TourTeam tourTeam, PhotoAlbum album) throws Exception;

	int addTourTeam(TourTeam tourTeam, User user);

	int outTourTam(TourTeam tourTeam, User user);

	int appointViceLeader(TourTeam tourTeam, User user);

	int cancelViceLeader(TourTeam tourTeam, User user);

	int appointMger(User user, TourTeam tourTeam);
	
	List<User> checkMgrCnt(TourTeam tourTeam);
	
	List<User> checkLeaderCnt(TourTeam tourTeam);
	
	int assignLeader(User leader,TourTeam tourTeam);
}
