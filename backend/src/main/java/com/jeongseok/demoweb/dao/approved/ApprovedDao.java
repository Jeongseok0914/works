package com.jeongseok.demoweb.dao.approved;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jeongseok.demoweb.controller.approved.ApprovedParam;

@Repository
@Mapper
public interface ApprovedDao {
	int insertApprovedInfo(ApprovedParam param);
}
