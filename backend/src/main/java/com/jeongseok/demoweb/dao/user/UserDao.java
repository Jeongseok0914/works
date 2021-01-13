package com.jeongseok.demoweb.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jeongseok.demoweb.controller.user.UserParam;
import com.jeongseok.demoweb.vo.user.UserVo;

@Repository
@Mapper
public interface UserDao {
	
	UserVo selectOne(UserParam param);
	
	List<UserVo> selectList(UserParam param);
	
}
