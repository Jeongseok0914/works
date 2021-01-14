package com.jeongseok.demoweb.dao.approved;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jeongseok.demoweb.controller.approved.ApprovedParam;
import com.jeongseok.demoweb.vo.approved.ApprovedVo;

@Repository
@Mapper
public interface ApprovedDao {
	
	List<ApprovedVo> selectList(ApprovedParam param);
	
	int insertApprovedInfo(ApprovedParam param);
	
	int updateApprovedInfo(ApprovedParam param);
	
	int deleteApprovedInfo(ApprovedParam param);
	
}
