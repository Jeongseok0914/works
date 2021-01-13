package com.jeongseok.demoweb.service.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeongseok.demoweb.controller.login.LoginParam;
import com.jeongseok.demoweb.dao.menu.MenuDao;
import com.jeongseok.demoweb.dao.menu.MenuRoleRelDao;
import com.jeongseok.demoweb.dao.user.UserDao;
import com.jeongseok.demoweb.dao.user.UserRoleRelDao;
import com.jeongseok.demoweb.vo.ResponseBaseVo;
import com.jeongseok.demoweb.vo.SessionVo;
import com.jeongseok.demoweb.vo.menu.MenuRoleRelVo;
import com.jeongseok.demoweb.vo.menu.MenuVo;
import com.jeongseok.demoweb.vo.user.UserRoleRelVo;
import com.jeongseok.demoweb.vo.user.UserVo;

@Service
@Transactional
public class LoginService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MenuDao menuDao;

	@Autowired
	private UserRoleRelDao userRoleRelDao;

	@Autowired
	private MenuRoleRelDao menuRoleRelDao;

	public ResponseBaseVo login(LoginParam param, HttpServletRequest request) throws Exception {
		ResponseBaseVo responseBaseVo = new ResponseBaseVo();

		UserVo userVo = userDao.selectOne(param);
		UserRoleRelVo userRoleRelVo = userRoleRelDao.selectOne(param);
		System.out.println(userRoleRelVo.getRoleId());
		if( userVo == null || userRoleRelVo == null ) {
			responseBaseVo.setResultCd(210);
			responseBaseVo.setResultMsg("inconsistency");
			return responseBaseVo;
		}
		else {
			Map<String, Object> menuRoleRelParamMap = new HashMap<>();
			menuRoleRelParamMap.put("roleId", userRoleRelVo.getRoleId());
			
			List<MenuRoleRelVo> menuRoleRelList = menuRoleRelDao.selectList(menuRoleRelParamMap);
			
			if (0 >= menuRoleRelList.size()) {
				responseBaseVo.setResultCd(210);
				responseBaseVo.setResultMsg("inconsistency");
				return responseBaseVo;	
			}
			
			for(MenuRoleRelVo vo: menuRoleRelList) {
				System.out.println(vo.getMenuId());
				
			}
			Map<String, Object> menuParamMap = new HashMap<>();
			menuParamMap.put("menuList", menuRoleRelList);
			
			List<MenuVo> menuList = menuDao.selectListIn(menuParamMap);
			if (0 >= menuList.size()) {
				responseBaseVo.setResultCd(210);
				responseBaseVo.setResultMsg("inconsistency");
				return responseBaseVo;	
			}

			HttpSession session = request.getSession(true);
			session.invalidate();
			session = request.getSession();

			SessionVo sessionVo = new SessionVo();
			sessionVo.setUserId(userVo.getUserId());
			sessionVo.setRoleId(userRoleRelVo.getRoleId());
			sessionVo.setUserName(userVo.getUserName());
			sessionVo.setMenuList(menuList);

			session.setAttribute("sessionVo", sessionVo);

			responseBaseVo.setResultCd(200);
			responseBaseVo.setResultMsg("Success");
			responseBaseVo.setData(session.getId());

		}

		return responseBaseVo;
	}

	public ResponseBaseVo checkLogin(HttpServletRequest request) throws Exception {
		ResponseBaseVo responseBaseVo = new ResponseBaseVo();

		HttpSession session = request.getSession(false);
		if (session == null) {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("Session Expiry");
		}
		
		SessionVo sessionVo = (SessionVo) session.getAttribute("sessionVo");
		responseBaseVo.setResultMsg("Success");
		responseBaseVo.setData(sessionVo);

		return responseBaseVo;
	}
}

