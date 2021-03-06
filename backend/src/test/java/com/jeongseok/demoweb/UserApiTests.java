package com.jeongseok.demoweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeongseok.demoweb.controller.user.UserParam;


@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserApiTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void userLoginTest() throws Exception {
		
		UserParam param =  new UserParam();
		param.setUserId("test1");
		param.setUserPassword("asdf");
		
		String content =  objectMapper.writeValueAsString(param);
		
		mockMvc.perform(post("/api/login")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
		
	}
	
	@Test
	public void userCheckLogin() throws Exception {
		
		mockMvc.perform(post("/api/check-login")
				.content("{}")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void userSearch() throws Exception {
		
		UserParam param =  new UserParam();
		param.setUserId("test1");
		
		String content =  objectMapper.writeValueAsString(param);
		
		mockMvc.perform(post("/api/user-search")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	
}
