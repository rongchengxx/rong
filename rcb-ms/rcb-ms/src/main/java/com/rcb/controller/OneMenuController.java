package com.rcb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rcb.service.one_menu.OneMenuService;

@Controller
public class OneMenuController {
	@Resource
	private OneMenuService oneMenuService;
	@RequestMapping("/column.do")
	public String colume() {
		return "column";
	}
	
	@RequestMapping("/pub.do")
	public String pub() {
		return "pub";
	}
}
