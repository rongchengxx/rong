package com.rcb.service.two_menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.TwoMenuDao;
import com.rcb.entity.TwoMenu;
import com.rcb.utils.CreateUUID;

@Service("twoMenuService")
public class TwoMenuServiceImpl implements TwoMenuService {

	@Resource
	private TwoMenuDao twoMenuDao;
	
	//查找TwoMenu所有对象
	public List<TwoMenu> findTwoMenuAll() {
		
		List<TwoMenu> list = twoMenuDao.findTwoMenuAll();
		return list;
	}

	//增加TwoMenu,返回行数
	public TwoMenu addTwoMenu(String oneMenuId,String title, String thumb, String content, int seq, int isshow,String intro) {
		
		String id = CreateUUID.createId();
		TwoMenu twoMenu = new TwoMenu(id, oneMenuId, title, thumb, content, seq, isshow,intro);
		int row = twoMenuDao.addTwoMenu(twoMenu);
		return twoMenu;
	}

	//修改TwoMenu,返回行数
	public int modifyTwoMenu(String id, String oneMenuId,String title, String thumb, String content, int seq, int isshow,String intro) {
		TwoMenu twoMenu = twoMenuDao.findTwoMenuById(id);
		twoMenu.setOneMenuId(oneMenuId);
		twoMenu.setTitle(title);
		twoMenu.setThumb(thumb);
		twoMenu.setContent(content);
		twoMenu.setSeq(seq);
		twoMenu.setIsshow(isshow);
		twoMenu.setIntro(intro);
		int row = twoMenuDao.modifyTwoMenu(twoMenu);
		return row;
	}

	//删除TwoMenu,返回行数
	public int delTwoMenuById(String id) {
		int row = twoMenuDao.delTwoMenuById(id);
		return row;
	}

	public TwoMenu findTwoMenuById(String id) {
		TwoMenu towMenu = twoMenuDao.findTwoMenuById(id);
		return towMenu;
	}

	public List<TwoMenu> findTwoMenuByOneMenuId(String oneMenuID) {
		List<TwoMenu> list = twoMenuDao.findTwoMenuByOneMenuId(oneMenuID);
		return list;
	}

}
