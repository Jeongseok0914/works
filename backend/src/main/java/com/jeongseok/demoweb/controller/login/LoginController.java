package com.jeongseok.demoweb.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeongseok.demoweb.service.login.LoginService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api")
public class LoginController {
	
	
	@Autowired
	LoginService loginService;

	@ApiOperation(value = "Login", notes = "사용자 로그인")
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<?> login(@RequestBody LoginParam param, HttpServletRequest request) throws Exception {
		return ResponseEntity.ok(loginService.login(param, request));
		
	}
	
	
	@ApiOperation(value = "Check Login", notes = "로그인 체크")
	@PostMapping(value = "/check-login")
	@ResponseBody
	public ResponseEntity<?> checkLogin() throws  Exception {
		return ResponseEntity.ok(loginService.checkLogin());
	}
}
