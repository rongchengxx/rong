package com.rcb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.TwoMenu;
import com.rcb.service.two_menu.TwoMenuService;
import com.rcb.utils.JsonResult;

@Controller
public class TwoMenuController {

	@Resource
	private TwoMenuService twoMenuService;
	@RequestMapping("/cate.do")
	public String cate(){
		return "cate";
	}
	
	@RequestMapping("/cate/loadCate.do")
	@ResponseBody
	public JsonResult loadCate(){
		List<TwoMenu> result = 
				twoMenuService.findTwoMenuAll();
		return new JsonResult(result);
	}
	
	@RequestMapping("/cateedit.do")
	public String cateedit(){
		return "cateedit";
	}
}
