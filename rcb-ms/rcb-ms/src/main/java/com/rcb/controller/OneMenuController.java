package com.rcb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.OneMenu;
import com.rcb.exception.ForeignKeysException;
import com.rcb.service.one_menu.OneMenuService;
import com.rcb.service.one_menu.OneMenuServiceImpl;
import com.rcb.utils.JsonResult;



@Controller
public class OneMenuController extends ExceptionController{
	@Resource
	private OneMenuService oneMenuService;

	@ExceptionHandler(ForeignKeysException.class)
	@ResponseBody
	public JsonResult fkexp(ForeignKeysException e){
		e.printStackTrace();
		return new JsonResult(4,e);
	}

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
	//增加oneMenu
	@RequestMapping("/column/addColumn.do")
	@ResponseBody
	public JsonResult addColume(String title,String thumb,String content,int seq,int isshow,String intro){
		OneMenu result = oneMenuService.addOneMenu(title, thumb, content, seq, isshow, intro);
		return new JsonResult(result);
	}
	
	//删除oneMenu
	@RequestMapping("/column/delColume.do")
	@ResponseBody
	public JsonResult delColume(String id){
		int row = oneMenuService.delOneMenuById(id);
		return new JsonResult(row);
	}
	
	
	//修改页面跳转
	@RequestMapping("/pub.do")
	public String pub() {
		return "pub";
	}

	//修改页面load
	@RequestMapping("/pub/loadPub.do")
	@ResponseBody
	public JsonResult loadPub(String id){
		OneMenu oneMenu = oneMenuService.findOneMenuById(id);
		return new JsonResult(oneMenu);
	}
	
	//修改页面modify
	@RequestMapping("/pub/modyfiPub.do")
	@ResponseBody
	public JsonResult modifyPub(String id,String title,String thumb,String content,int seq,int isshow,String intro){
		int row = oneMenuService.modifyOneMenu(id, title, thumb, content, seq, isshow, intro);
		return new JsonResult(row);
		
	}
}
