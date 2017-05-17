package com.rcb.service.two_menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.OneMenuDao;
import com.rcb.entity.OneMenu;

@Service("oneMenuService")
public class TwoMenuServiceImpl implements TwoMenuService {

	@Resource
	private OneMenuDao oneMenuDao;
	
	public List<OneMenu> findOneMenuAll() {
		
		List<OneMenu> list = oneMenuDao.findOneMenuAll();
		return list;
	}

}
