package com.rcb.service.one_menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.OneMenuDao;
import com.rcb.entity.OneMenu;

@Service("oneMenuService")
public class OneMenuServiceImpl implements OneMenuService {

	@Resource
	private OneMenuDao oneMenuDao;
	
	public List<OneMenu> findOneMenuAll() {
		
		List<OneMenu> list = oneMenuDao.findOneMenuAll();
		return list;
	}

	public int addOneMenu(OneMenu oneMenu) {
		// TODO Auto-generated method stub
		return 0;
	}

	public OneMenu findOneMenuById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int modifyOneMenu(OneMenu oneMenu) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delOneMenuById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
