package com.jeongseok.demoweb.dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jeongseok.demoweb.controller.login.LoginParam;
import com.jeongseok.demoweb.vo.user.UserVo;

@Repository
@Mapper
public interface UserDao {
	
	UserVo selectOne(LoginParam param);
	
}
