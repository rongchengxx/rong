package com.rcb.service.single_page;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.OneMenuDao;
import com.rcb.entity.OneMenu;

@Service("oneMenuService")
public class SinglePageServiceImpl implements SinglePageService {

	@Resource
	private OneMenuDao oneMenuDao;
	
	public List<OneMenu> findOneMenuAll() {
		
		List<OneMenu> list = oneMenuDao.findOneMenuAll();
		return list;
	}

}
