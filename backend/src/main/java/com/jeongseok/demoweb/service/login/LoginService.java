package com.jeongseok.demoweb.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeongseok.demoweb.dao.login.LoginDao;
import com.jeongseok.demoweb.vo.ResponseBaseVo;
import com.jeongseok.demoweb.vo.login.LoginReqVo;
import com.jeongseok.demoweb.vo.login.LoginSelectVo;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	public ResponseBaseVo login(LoginReqVo loginReqVo) throws Exception {
		ResponseBaseVo responseBaseVo = new ResponseBaseVo();

		LoginSelectVo selectVo = loginDao.selectOne(loginReqVo);
		responseBaseVo.setResultMsg("Success");
		responseBaseVo.setData(selectVo);
			
		return responseBaseVo;	
	}

}
