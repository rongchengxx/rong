package com.rcb.service.two_menu;

import java.util.List;

import com.rcb.entity.TwoMenu;


public interface TwoMenuService {
	
	//查找TwoMenu所有对象
	public List<TwoMenu> findTwoMenuAll();
	
	//增加TwoMenu
	public TwoMenu addTwoMenu(String oneMenuId,String title,String thumb,String content,int seq,int isshow,String intro);
	
	//修改TwoMenu
	public int modifyTwoMenu(String id,String oneMenuId,String title,String thumb,String content,int seq,int isshow,String intro);
	
	//删除TwoMenu
	public int delTwoMenuById(String id);
	
	//查找TwoMenu根据id
	public TwoMenu findTwoMenuById(String id);
	
	//查找TwoMenu根据oneMenuId
	public List<TwoMenu> findTwoMenuByOneMenuId(String oneMenuID);
}
