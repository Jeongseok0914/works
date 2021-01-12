package com.jeongseok.demoweb.service.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeongseok.demoweb.controller.login.LoginParam;
import com.jeongseok.demoweb.dao.user.UserDao;
import com.jeongseok.demoweb.vo.ResponseBaseVo;
import com.jeongseok.demoweb.vo.SessionVo;
import com.jeongseok.demoweb.vo.user.UserVo;

@Service
@Transactional
public class LoginService {

	@Autowired
	private UserDao loginDao;
	

	public ResponseBaseVo login(LoginParam param, HttpServletRequest request) throws Exception {
		ResponseBaseVo responseBaseVo = new ResponseBaseVo();
		
		UserVo selectVo = loginDao.selectOne(param);
		
		if( selectVo == null ) {
			responseBaseVo.setResultCd(210);
			responseBaseVo.setResultMsg("inconsistency");
		}
		else {
			HttpSession session = request.getSession(true);
			session.invalidate();
			session = request.getSession();
			
			SessionVo sessionVo = new SessionVo();
			sessionVo.setUserId(selectVo.getUserId());
			sessionVo.setUserName(selectVo.getUserName());
			
			session.setAttribute("sessionBo", sessionVo);
			
			responseBaseVo.setResultCd(200);
			responseBaseVo.setResultMsg("Success");

		}

		return responseBaseVo;	
	}

}
