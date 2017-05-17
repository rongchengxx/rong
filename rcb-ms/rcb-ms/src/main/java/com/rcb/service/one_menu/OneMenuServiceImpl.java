package com.rcb.service.one_menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.OneMenuDao;
import com.rcb.entity.OneMenu;
import com.rcb.utils.CreateUUID;

@Service("oneMenuService")
public class OneMenuServiceImpl implements OneMenuService {

	@Resource
	private OneMenuDao oneMenuDao;
	
	//查找OneMenu所有对象
	public List<OneMenu> findOneMenuAll() {
		
		List<OneMenu> list = oneMenuDao.findOneMenuAll();
		return list;
	}
	
	//增加OneMenu,返回行数
	public int addOneMenu(String title, String thumb, String content, int seq, int isshow) {
		String id = CreateUUID.createId();
		OneMenu oneMenu = new OneMenu(id, title, thumb, content, seq, isshow, "");
		int row = oneMenuDao.addOneMenu(oneMenu);
		return row;
	}
	//修改OneMenu,返回行数
	public int modifyOneMenu(String id, String title, String thumb, String content, int seq, int isshow) {
		OneMenu oneMenu = oneMenuDao.findOneMenuById(id);
		oneMenu.setTitle(title);
		oneMenu.setThumb(thumb);
		oneMenu.setContent(content);
		oneMenu.setSeq(seq);
		oneMenu.setIsshow(isshow);
		int row = oneMenuDao.modifyOneMenu(oneMenu);
		return row;
	}

	//删除OneMenu,返回行数
	public int delOneMenuById(String id) {
		int row = oneMenuDao.delOneMenuById(id);
		return row;
	}

	

}
