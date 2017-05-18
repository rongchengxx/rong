package com.rcb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rcb.service.single_page.SinglePageService;

@Controller
public class SinglePageAController {

	@Resource
	private SinglePageService singlePageServive;
	
	@RequestMapping("/list.do")
	public String list(){
		return "list";
	}
	
	@RequestMapping("/add.do")
	public String add(){
		return "add";
	}
}
