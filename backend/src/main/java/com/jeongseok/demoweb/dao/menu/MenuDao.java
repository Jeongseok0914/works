package com.jeongseok.demoweb.dao.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jeongseok.demoweb.vo.menu.MenuVo;

@Repository
@Mapper
public interface MenuDao {

		List<MenuVo> selectListIn(Map<String, Object> map);
	
}
