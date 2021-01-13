package com.jeongseok.demoweb.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeongseok.demoweb.service.user.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api")
public class UserController {


	@Autowired
	UserService userService;

	@ApiOperation(value = "Login", notes = "사용자 로그인")
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<?> userlogin(@RequestBody UserParam param, HttpServletRequest request) throws Exception {
		return ResponseEntity.ok(userService.login(param, request));

	}


	@ApiOperation(value = "Check Login", notes = "로그인 체크")
	@PostMapping(value = "/check-login")
	@ResponseBody
	public ResponseEntity<?> userCheckLogin(HttpServletRequest request) throws Exception {
		return ResponseEntity.ok(userService.checkLogin(request));
	}
	
	@ApiOperation(value = "User Search", notes = "사용자 검색")
	@PostMapping(value = "/user-search")
	@ResponseBody
	public ResponseEntity<?> userSearch(@RequestBody UserParam param) throws Exception {
		return ResponseEntity.ok(userService.userSearch(param));
	}
	
}
