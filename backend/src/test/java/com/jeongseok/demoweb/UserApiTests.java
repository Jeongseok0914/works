package com.jeongseok.demoweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import com.jeongseok.demoweb.controller.user.UserParam;
import com.jeongseok.demoweb.service.user.UserService;


@WebMvcTest(UserApiTests.class)
public class UserApiTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void doLoginTest() throws Exception {
		
		UserParam param = new UserParam();
		
		
	}
}
