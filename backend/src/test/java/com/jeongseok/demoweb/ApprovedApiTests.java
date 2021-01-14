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
import com.jeongseok.demoweb.comm.Constants;
import com.jeongseok.demoweb.controller.approved.ApprovedParam;



@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ApprovedApiTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void selectApprovedTest() throws Exception {
		
		ApprovedParam param = new ApprovedParam();
		param.setSysCretUserId("test1");
		
		
		String content =  objectMapper.writeValueAsString(param);
		
		mockMvc.perform(post("/api/select-approved")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
		
	}
	
	@Test
	public void insertApprovedTest() throws Exception {
		
		ApprovedParam param = new ApprovedParam();
		param.setTitle("Test Title");
		param.setContent("Test Content");
		param.setSysCretUserId("test1");
		param.setStatus(Constants.APPROVED_STATUS_WAIT);
		
		
		String content =  objectMapper.writeValueAsString(param);
		
		mockMvc.perform(post("/api/insert-approved")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
		
	}
	
	@Test
	public void updateApprovedTest() throws Exception {
		
		ApprovedParam param = new ApprovedParam();
		param.setTitle("Test Title");
		param.setContent("Test Content");
		param.setSysCretUserId("test1");
		param.setIdx(3);
		
		
		String content =  objectMapper.writeValueAsString(param);
		
		mockMvc.perform(post("/api/update-approved")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
		
	}
	
	@Test
	public void deleteApprovedTest() throws Exception {
		
		ApprovedParam param = new ApprovedParam();
		param.setIdx(3);
		
		
		String content =  objectMapper.writeValueAsString(param);
		
		mockMvc.perform(post("/api/delete-approved")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
		
	}
	
}
