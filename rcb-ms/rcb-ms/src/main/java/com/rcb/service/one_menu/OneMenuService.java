package com.rcb.service.one_menu;

import java.util.List;

import com.rcb.entity.OneMenu;

public interface OneMenuService {
	
	//查找OneMenu所有对象
	public List<OneMenu> findOneMenuAll();
	
	//增加OneMenu
	public int addOneMenu(String title,String thumb,String content,int seq,int isshow);
	
	//修改OneMenu
	public int modifyOneMenu(String id,String title,String thumb,String content,int seq,int isshow);
	
	//删除OneMenu
	public int delOneMenuById(String id);
}
