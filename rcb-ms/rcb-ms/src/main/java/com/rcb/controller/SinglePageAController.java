package com.rcb.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.SinglePage;
import com.rcb.exception.TwoMenuNotFoundException;
import com.rcb.service.single_page.SinglePageService;
import com.rcb.utils.JsonResult;

@Controller
public class SinglePageAController {

	@Resource
	private SinglePageService singlePageServive;

	@RequestMapping("/add.do")
	public String add(){
		return "add";
	}
	
	@RequestMapping("/add/addAdd.do")
	@ResponseBody
	public JsonResult addAdd(String oneMenuId,String twoMenuId,String title,String picture,String narration,String content,String keyWord,String keyWordTitle,String keyWordDesc,Timestamp createTime,int seq,String author,int clicks,int isshow){
		SinglePage singlePage = singlePageServive.addSinglePage(oneMenuId, twoMenuId, title, picture, narration, content, keyWord, keyWordTitle, keyWordDesc, createTime,seq, author, clicks, isshow);
		System.out.println(singlePage);
		return new JsonResult(singlePage);
	}
	/*@ExceptionHandler(TwoMenuNotFoundException.class)
	@ResponseBody
	public JsonResult nameexp(TwoMenuNotFoundException e){
		e.printStackTrace();
		return new JsonResult(5,e);
	}*/
	
	@RequestMapping("/list.do")
	public String list(){
		return "list";
	}
	
	@RequestMapping("/amend.do")
	public String amend(){
		return "amend";
	}
}
