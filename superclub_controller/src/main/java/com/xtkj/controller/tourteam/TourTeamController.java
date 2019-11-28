package com.xtkj.controller.tourteam;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtkj.pojo.PhotoAlbum;
import com.xtkj.pojo.TourTeam;
import com.xtkj.pojo.User;
import com.xtkj.service.tourteam.ITourTeamService;
import com.xtkj.utils.IConstant;
import com.xtkj.utils.ObjectResult;

@RestController
@RequestMapping("/tourTeam")
public class TourTeamController {

	@Autowired
	private ITourTeamService tourTeamService;

	/**
	 * 获取驴友队列表
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ObjectResult getListTourTeam(HttpServletRequest request) {

		ObjectResult result = null;

		User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);

		List<TourTeam> tourTeams = tourTeamService.listTourTeam(user);

		result = new ObjectResult("200", "successful", tourTeams);

		try {

		} catch (Exception e) {
			e.printStackTrace();
			result = new ObjectResult("500", e.getMessage());
		}
		return result;

	}

	/**
	 * 
	 * 创建驴友队
	 * 
	 * @param request
	 * @param tourTeam
	 * @return
	 */
	@RequestMapping("/create")
	public ObjectResult createTourTeam(HttpServletRequest request, TourTeam tourTeam) {

		ObjectResult result = null;

		try {

			String tourTeamId = UUID.randomUUID().toString();
			tourTeam.setId(tourTeamId);
			tourTeam.setTeamId(tourTeamId);

			User user = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);

			tourTeam.setPrincipalName(user.getNickName());

			tourTeam.setLeaderId(user.getUserId());

			PhotoAlbum photoAlbum = new PhotoAlbum();
			String photoAlbumId = UUID.randomUUID().toString();
			photoAlbum.setId(photoAlbumId);
			photoAlbum.setAlbumName("游记相册" + tourTeam.getTeamName());

			tourTeam.setPhotoAlbumId(photoAlbumId);

			int i = tourTeamService.createTourTeam(tourTeam, photoAlbum);
			if (i > 3) {
				result = new ObjectResult("200", "successful", i);
			} else {
				result = new ObjectResult("500", "出错了");
			}

		} catch (Exception e) {

			e.printStackTrace();

			return new ObjectResult("500", e.getMessage());

		}
		return result;

	}

	/**
	 * 加入驴友队
	 * 
	 * @param request
	 * @param tourTeam
	 * @return
	 */
	@RequestMapping("/add")
	public ObjectResult addTourTeam(HttpServletRequest request, TourTeam tourTeam) {
		ObjectResult result = null;
		User currentUser = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);
		try {

			int i = tourTeamService.addTourTeam(tourTeam, currentUser);

			if (i == 0) {
				result = new ObjectResult("500", "系统错误");

			} else if (i == 2) {

				result = new ObjectResult("500", "用户已经存在");
			} else if (i == 1) {
				result = new ObjectResult("200", "successful", i);
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = new ObjectResult("500", e.getMessage());
		}

		return result;

	}

	/**
	 * 退出驴友队
	 * 
	 * @param request
	 * @param tourTeam
	 * @return
	 */
	@RequestMapping("outTourTam")
	public ObjectResult OutTourTeam(HttpServletRequest request, TourTeam tourTeam) {

		ObjectResult result = null;

		try {

			User currentUser = (User) request.getSession().getAttribute(IConstant.CURRENT_USER);
			int i = tourTeamService.outTourTam(tourTeam, currentUser);

			if (i > 0) {
				result = new ObjectResult("200", "successful", i);
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = new ObjectResult("500", e.getMessage());
		}
		return result;

	}

	/**
	 * 任命副队长
	 * 
	 * @param request
	 * @param tourTeam
	 * @return
	 */
	@RequestMapping("/appointViceLeader")
	public ObjectResult appointViceLeader(User user, TourTeam tourTeam) {
		ObjectResult result = null;
		try {
			int i = tourTeamService.appointViceLeader(tourTeam, user);
			if (i == 1) {
				result = new ObjectResult("200", "successful", i);
			} else if (i == 0) {
				result = new ObjectResult("500", "系统错误");
			} else if (i == 2) {
				result = new ObjectResult("500", "用户已经存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new ObjectResult("500", e.getMessage());
		}
		return result;
	}

	/**
	 * 取消副队长
	 * 
	 * @param uer
	 * @param tourTeam
	 * @return
	 */
	@RequestMapping("/cancelViceLeader")
	public ObjectResult cancelViceLeader(User user, TourTeam tourTeam) {
		ObjectResult result = null;
		try {

			int i = tourTeamService.cancelViceLeader(tourTeam, user);
			if (i > 0) {
				result = new ObjectResult("200", "successful", i);
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = new ObjectResult("500", e.getMessage());
		}
		return result;
	}

	/**
	 * 任命管理员
	 * 
	 * @param user
	 * @param tourTeam
	 * @return
	 */
	@RequestMapping("/appointMgr")
	public ObjectResult appointMger(User user, TourTeam tourTeam) {
		ObjectResult result = null;
		try {

			List<User> users = tourTeamService.checkMgrCnt(tourTeam);
			if (users.size() < 8) {
				int i = tourTeamService.appointMger(user, tourTeam);
				result = new ObjectResult("200", "success", i);
			}

			else {
				result = new ObjectResult("500", "管理员人数达上限");
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = new ObjectResult("500", e.getMessage());
		}
		return result;
	}

	/**
	 * 转让驴友队
	 * 
	 * @param user
	 * @param tourTeam
	 * @return
	 */
	@RequestMapping("/assignLeader")
	public ObjectResult assignLeader(User user, TourTeam tourTeam) {
		ObjectResult result = null;
		try {

			List<User> users = tourTeamService.checkLeaderCnt(tourTeam);
			if (users.size() < 2) {
				result = new ObjectResult("200", "successful", tourTeamService.assignLeader(user, tourTeam));
			} else {
				result = new ObjectResult("500", "队长数量超额");
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = new ObjectResult("500", e.getMessage());
		}

		return result;
	}

}
