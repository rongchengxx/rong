package com.rcb.controller;

import com.rcb.service.gbook.GbookService;
import com.rcb.utils.JsonResult;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GbookController {
	@Resource
	private GbookService service;
	@RequestMapping("/book.do")
	public String book() {
		return "book";
	}
	
	/*
	 * 删除路径/book/delBook.do
	 * 删除多条/book/delBooks.do
	 * 自动加载/book/loadBook.do
	 * 
	 * 涉及jsp为book。jsp文件，请在js文件夹下面创建js文件
	 * 请自行按照别的方法案例书写方法
	 * 如需传递参数请参考service
	 * 
	 * */
	
	
	
	
	
	
	
	
	
	
	
}
