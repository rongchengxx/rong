package com.rcb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.OneMenu;
import com.rcb.service.one_menu.OneMenuService;
import com.rcb.utils.JsonResult;



@Controller
public class OneMenuController extends ExceptionController{
	@Resource
	private OneMenuService oneMenuService;
	//跳转页面
	@RequestMapping("/column.do")
	public String colume() {
		return "column";
	}
	
	//加载OneMenu
	@RequestMapping("/column/loadColumn.do")
	@ResponseBody
	public JsonResult loadColume(){
		List<OneMenu> result
				=oneMenuService.findOneMenuAll();
		return new JsonResult(result);
	}
	
	/*@RequestMapping("/column/add.do")
	@ResponseBody
	public JsonResult addColume(){
		
		return null;
	}*/
	
	@RequestMapping("/pub.do")
	public String pub() {
		return "pub";
	}
}
