package com.jeongseok.demoweb.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeongseok.demoweb.service.login.LoginService;
import com.jeongseok.demoweb.vo.login.LoginReqVo;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@ApiOperation(value = "Login", notes = "사용자 로그인")
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<?> login(LoginReqVo loginReqVo) throws Exception {
		return ResponseEntity.ok(loginService.login(loginReqVo));
		
	}
}
