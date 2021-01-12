package com.jeongseok.demoweb.dao.user;

import java.util.Map;

import com.jeongseok.demoweb.vo.user.UserRoleRelVo;

public interface UserRoleRelDao {
	
	UserRoleRelVo selectOne(Map<String, Object> map);
	
}
