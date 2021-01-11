package com.jeongseok.demoweb.dao.login;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jeongseok.demoweb.vo.login.LoginReqVo;
import com.jeongseok.demoweb.vo.login.LoginSelectVo;

@Repository
@Mapper
public interface LoginDao {
	
	LoginSelectVo selectOne(LoginReqVo loginReqVo);
	
}
