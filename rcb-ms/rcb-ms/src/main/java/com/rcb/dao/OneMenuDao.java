package com.rcb.dao;

import java.util.List;

import com.rcb.entity.OneMenu;

public interface OneMenuDao {
	//查找OneMenu所有对象
	public List<OneMenu> findOneMenuAll();
	
	//增加OneMenu
	public int addOneMenu(OneMenu oneMenu);
	
	//查找OneMenu根据id
	public OneMenu findOneMenuById(String id);
	
	//修改OneMenu
	public int modifyOneMenu(OneMenu oneMenu);
	
	//删除OneMenu
	public int delOneMenuById(String id);
}
