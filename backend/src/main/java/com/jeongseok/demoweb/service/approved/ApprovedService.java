package com.jeongseok.demoweb.service.approved;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeongseok.demoweb.comm.Constants;
import com.jeongseok.demoweb.controller.approved.ApprovedParam;
import com.jeongseok.demoweb.dao.approved.ApprovedDao;
import com.jeongseok.demoweb.vo.ResponseBaseVo;
import com.jeongseok.demoweb.vo.SessionVo;
import com.jeongseok.demoweb.vo.approved.ApprovedVo;

@Service
@Transactional
public class ApprovedService {

	@Autowired
	ApprovedDao approvedDao;
	
	public ResponseBaseVo selectListApproved(ApprovedParam param, HttpServletRequest request) throws Exception {
		ResponseBaseVo responseBaseVo = new ResponseBaseVo();
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("Session Expiry");
			return responseBaseVo;
		}
		
		SessionVo sessionVo = (SessionVo) session.getAttribute("sessionVo");
		if (sessionVo.getRoleId().equals(Constants.ROLE_USER_APPROVER)) {
			param.setApprovedUserId(sessionVo.getUserId());
			
			
		} else if (sessionVo.getRoleId().equals(Constants.ROLE_USER_REQUESTER)) {
			param.setSysCretUserId(sessionVo.getUserId());
			
		} else {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("Session Expiry");
			return responseBaseVo;
		}
		
		List<ApprovedVo> approvedList = approvedDao.selectList(param);
		responseBaseVo.setData(approvedList);
		
		return responseBaseVo;
	}
	

	public ResponseBaseVo insertApproved(ApprovedParam param, HttpServletRequest request) throws  Exception {
		ResponseBaseVo responseBaseVo = new ResponseBaseVo();
		HttpSession session = request.getSession(false);
		if (session == null) {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("Session Expiry");
			return responseBaseVo;
		}

		SessionVo sessionVo = (SessionVo) session.getAttribute("sessionVo");
		param.setSysCretUserId(sessionVo.getUserId());
		param.setStatus(Constants.APPROVED_STATUS_WAIT);
		
		int insertResult =  approvedDao.insertApprovedInfo(param);
		
		if (insertResult == 0) {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("false");
			return responseBaseVo;
		}

		return responseBaseVo;
	}
	
	public ResponseBaseVo updateApproved(ApprovedParam param, HttpServletRequest request) throws Exception {
		ResponseBaseVo responseBaseVo = new ResponseBaseVo();
		HttpSession session = request.getSession(false);
		if (session == null) {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("Session Expiry");
			return responseBaseVo;
		}
		
		SessionVo sessionVo = (SessionVo) session.getAttribute("sessionVo");
		if (sessionVo.getRoleId().equals(Constants.ROLE_USER_APPROVER)) {
			param.setSysUpdtUserId(sessionVo.getUserId());
			
			
		} else if (sessionVo.getRoleId().equals(Constants.ROLE_USER_REQUESTER)) {
			param.setSysCretUserId(sessionVo.getUserId());
			
		} else {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("Session Expiry");
			return responseBaseVo;
		}
		
		int updateResult = approvedDao.updateApprovedInfo(param);
		if (updateResult == 0) {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("false");
			return responseBaseVo;
		}
		
		return responseBaseVo;
	}
	
	public ResponseBaseVo deleteApproved(ApprovedParam param, HttpServletRequest request) throws Exception {
		ResponseBaseVo responseBaseVo = new ResponseBaseVo();
		HttpSession session = request.getSession(false);
		if (session == null) {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("Session Expiry");
			return responseBaseVo;
		}
		
		int deleteResult = approvedDao.deleteApprovedInfo(param);
		if (deleteResult == 0) {
			responseBaseVo.setResultCd(999);
			responseBaseVo.setResultMsg("false");
			return responseBaseVo;
		}

		return responseBaseVo;
	}

}
