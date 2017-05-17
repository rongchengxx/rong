package com.rcb.service.single_page;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.SinglePageDao;
import com.rcb.entity.SinglePage;
import com.rcb.utils.CreateUUID;

@Service("singlePageService")
public class SinglePageServiceImpl implements SinglePageService {

	@Resource
	private SinglePageDao singlePageDao;
	
	//查找SinglePage根据page
	//page:从第几条内容开始
	public List<SinglePage> findSinglePageByPage(int page) {
		
		List<SinglePage> list = singlePageDao.findSinglePageByPage(page);
		return list;
	}

	//增加SinglePage,返回行数
	public int addSinglePage(String oneMenuId,String twoMenuId,String title,String picture,String sortTitle,String narration,String content,String keyWord,String keyWordTitle,String keyWordDesc,int seq,String author,int clicks,int isshow) {
		String id = CreateUUID.createId();
		Timestamp createTime = new Timestamp(System.currentTimeMillis()); 
		SinglePage singlePage = new SinglePage(id, oneMenuId, twoMenuId, title, picture, sortTitle, narration, content, keyWord, keyWordTitle, keyWordDesc, seq, createTime, null, author, clicks, isshow);
		int row = singlePageDao.addSinglePage(singlePage);
		return row;
	}

	//修改SinglePage,返回行数
	public int modifySinglePage(String id,String oneMenuId,String twoMenuId,String title,String picture,String sortTitle,String narration,String content,String keyWord,String keyWordTitle,String keyWordDesc,int seq,String author,int clicks,int isshow) {
		
		Timestamp changeTime = new Timestamp(System.currentTimeMillis()); 

		SinglePage singlePage = singlePageDao.findSinglePageById(id);
		singlePage.setOneMenuId(oneMenuId);
		singlePage.setTwoMenuId(twoMenuId);
		singlePage.setTitle(title);
		singlePage.setPicture(picture);
		singlePage.setSortTitle(sortTitle);
		singlePage.setNarration(narration);
		singlePage.setContent(content);
		singlePage.setKeyWord(keyWord);
		singlePage.setKeyWordTitle(keyWordTitle);
		singlePage.setKeyWordDesc(keyWordDesc);
		singlePage.setSeq(seq);
		singlePage.setChangeTime(changeTime);
		singlePage.setAuthor(author);
		singlePage.setclicks(clicks);
		singlePage.setIsshow(isshow);
		
		int row = singlePageDao.modifySinglePage(singlePage);
		return row;
	}

	//删除SinglePage,返回行数
	public int delSinglePageById(String id) {
		int row = singlePageDao.delSinglePageById(id);
		return row;
	}

}
