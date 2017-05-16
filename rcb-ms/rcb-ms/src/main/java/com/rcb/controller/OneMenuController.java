package com.rcb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rcb.service.one_menu.OneMenuService;


@Controller
@RequestMapping("/oneMenu")
public class OneMenuController {
	
	@Resource
	private OneMenuService oneMenuService;
	
	@RequestMapping("/login1.do")
	public String index(){
		return "colu";
	}
	
	/*@RequestMapping("/load.do")
	@ResponseBody
	public JsonResult findOneMenuAll(){
		
		List<OneMenu> list = oneMenuService.findOneMenuAll();
		return new JsonResult(list);
	}*/
	
}
