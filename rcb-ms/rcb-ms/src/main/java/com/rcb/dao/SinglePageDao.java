package com.rcb.dao;

import java.util.List;

import com.rcb.entity.SinglePage;

public interface SinglePageDao {

	//查找SinglePage所有对象
	public List<SinglePage> findSinglePageAll();
	
	//增加SinglePage
	public int addSinglePage(SinglePage singlePage);
	
	//查找SinglePage根据id
	public SinglePage findSinglePageById(String id);
	
	//修改SinglePage
	public int modifySinglePage(SinglePage singlePage);
	
	//删除SinglePage
	public int delSinglePageById(String id);
	 
	//查找SinglePage根据page
	//page:从第几条内容开始
	public List<SinglePage> findSinglePageByPage(int page);
}
