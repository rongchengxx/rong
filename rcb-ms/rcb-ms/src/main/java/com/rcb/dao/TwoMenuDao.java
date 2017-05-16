package com.rcb.dao;

import java.util.List;

import com.rcb.entity.TwoMenu;

public interface TwoMenuDao {
	//查找TwoMenu所有对象
	public List<TwoMenu> findTwoMenuAll();
	
	//增加TwoMenu
	public int addTwoMenu(TwoMenu twoMenu);
	
	//查找TwoMenu根据id
	public TwoMenu findTwoMenuById(String id);
	
	//修改TwoMenu
	public int modifyTwoMenu(TwoMenu twoMenu);
	
	//删除TwoMenu
	public int delTwoMenuById(String id);
}
