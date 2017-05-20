package com.rcb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.OneMenu;
import com.rcb.entity.TwoMenu;
import com.rcb.service.one_menu.OneMenuService;
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
	//加载cate
	public JsonResult loadCate(){
		List<TwoMenu> result = 
				twoMenuService.findTwoMenuAll();
		return new JsonResult(result);
	}
	//增加twoMenu
	@RequestMapping("/cate/addCate.do")
	@ResponseBody
	public JsonResult addColume(String oneMenuId,String title,String thumb,String content,int seq,int isshow,String intro){
		TwoMenu result = twoMenuService.addTwoMenu(oneMenuId, title, thumb, content, seq, isshow, intro);
		return new JsonResult(result);
	}
	//删除twoMenu
	@RequestMapping("/cate/delCate.do")
	@ResponseBody
	public JsonResult delCate(String id){
		int row = twoMenuService.delTwoMenuById(id);
		return new JsonResult(row);
	}
	
	//跳转修改页面
	@RequestMapping("/cateedit.do")
	public String cateedit(){
		return "cateedit";
	}
	//修改页面load
	@RequestMapping("/cateedit/loadCateedit.do")
	@ResponseBody
	public JsonResult loadCateedit(String id){
		TwoMenu twoMenu = twoMenuService.findTwoMenuById(id);
		return new JsonResult(twoMenu);
	}
	//修改页面modify
	@RequestMapping("/cateedit/modyfiCateedit.do")
	@ResponseBody
	public JsonResult modifyCateedit(String id,String oneMenuId,String title,String thumb,String content,int seq,int isshow,String intro){
		int row = twoMenuService.modifyTwoMenu(id, oneMenuId, title, thumb, content, seq, isshow, intro);
		return new JsonResult(row);
	}
	
}
