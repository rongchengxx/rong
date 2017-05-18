package com.rcb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rcb.service.two_menu.TwoMenuService;

@Controller
public class TwoMenuController {

	@Resource
	private TwoMenuService twoMenuService;
	@RequestMapping("/cate.do")
	public String cate(){
		return "cate";
	}
	
}
