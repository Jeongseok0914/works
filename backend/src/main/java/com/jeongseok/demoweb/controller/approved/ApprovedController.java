package com.jeongseok.demoweb.controller.approved;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeongseok.demoweb.service.approved.ApprovedService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api")
public class ApprovedController {

	@Autowired
	ApprovedService approvedService;

	@ApiOperation(value = "Approved Select", notes = "결재 리스트")
	@PostMapping(value = "/select-approved")
	@ResponseBody
	public ResponseEntity<?> selectApproved(@RequestBody ApprovedParam param, HttpServletRequest request) throws Exception {
		return ResponseEntity.ok(approvedService.selectListApproved(param, request));
	}
	
	@ApiOperation(value = "Approved Insert", notes = "결재등록")
	@PostMapping(value = "/insert-approved")
	@ResponseBody
	public ResponseEntity<?> insertApproved(@RequestBody ApprovedParam param,HttpServletRequest request) throws Exception {
		return ResponseEntity.ok(approvedService.insertApproved(param, request));
	}
	
	@ApiOperation(value = "Approved Update", notes = "결재수정")
	@PostMapping(value = "/update-approved")
	@ResponseBody
	public ResponseEntity<?> updateApproved(@RequestBody ApprovedParam param,HttpServletRequest request) throws Exception {
		return ResponseEntity.ok(approvedService.updateApproved(param, request));
	}
	
	@ApiOperation(value = "Approved Delete", notes = "결재삭제")
	@PostMapping(value = "/delete-approved")
	@ResponseBody
	public ResponseEntity<?> deleteApproved(@RequestBody ApprovedParam param,HttpServletRequest request) throws Exception {
		return ResponseEntity.ok(approvedService.deleteApproved(param, request));
	}
}
