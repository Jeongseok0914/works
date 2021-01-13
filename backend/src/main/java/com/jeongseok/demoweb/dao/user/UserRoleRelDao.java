package com.jeongseok.demoweb.dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jeongseok.demoweb.controller.login.LoginParam;
import com.jeongseok.demoweb.vo.user.UserRoleRelVo;


@Repository
@Mapper
public interface UserRoleRelDao {
	
	UserRoleRelVo selectOne(LoginParam param);
	
}
