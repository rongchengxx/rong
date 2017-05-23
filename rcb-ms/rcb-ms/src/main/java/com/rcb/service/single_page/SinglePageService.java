package com.rcb.service.single_page;

import java.sql.Timestamp;
import java.util.List;

import com.rcb.entity.SinglePage;
import com.rcb.exception.TwoMenuNotFoundException;

public interface SinglePageService {
	 
	//查找SinglePage根据page
	//page:从第几条内容开始
	public List<SinglePage> findSinglePageByPage(int page);
		
	//增加SinglePage
	public SinglePage addSinglePage(String oneMenuId,String twoMenuId,String title,String picture,String narration,String content,String keyWord,String keyWordTitle,String keyWordDesc,Timestamp createTime,int seq,String author,int clicks,int isshow)throws TwoMenuNotFoundException;
	
	//修改SinglePage
	public int modifySinglePage(String id,String oneMenuId,String twoMenuId,String title,String picture,String narration,String content,String keyWord,String keyWordTitle,String keyWordDesc,Timestamp createTime,int seq,String author,int clicks,int isshow);
	
	//删除SinglePage
	public int delSinglePageById(String id);
	
}
