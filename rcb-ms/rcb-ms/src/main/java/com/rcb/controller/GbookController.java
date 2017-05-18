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
	/*	@ResponseBody
	@RequestMapping("/book1.do")
	public Object del(String id) {
		int n=service.delGbookById(id);
		return new JsonResult(n);
	}
	@RequestMapping("/cate1.do")
	public String cate() {
		return "cate";
	}

	@RequestMapping("/cateedit1.do")
	public String cateedit() {
		return "cateedit";
	}

	@RequestMapping("/column1.do")
	public String column() {
		return "column";
	}

	@RequestMapping("/error1.do")
	public String error() {
		return "error";
	}


	@RequestMapping("/list1.do")
	public String list() {
		return "list";
	}

	@RequestMapping("/pic1.do")
	public String pic() {
		return "pic";
	}

	@RequestMapping("/tips1.do")
	public String tips() {
		return "tips";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
*/}
