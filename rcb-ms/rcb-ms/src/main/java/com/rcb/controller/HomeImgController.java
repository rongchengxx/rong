package com.rcb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.dao.HomeImgDao;
import com.rcb.dao.SettingsDao;
import com.rcb.entity.HomeImg;
import com.rcb.entity.Settings;
import com.rcb.service.home_img.HomeImgService;
import com.rcb.utils.JsonResult;


	@Controller
	public class HomeImgController{
		@Resource
		private HomeImgService service;
		
		@RequestMapping("/adv.do")
		public String adv() {
			return "adv";
		}
		/*
		@ResponseBody
		@RequestMapping("/adv1.do")
		public Object findall(){
			List<HomeImg> list=	service.findHomeImgAll();
				return new JsonResult(list);	
		}
		@ResponseBody
		@RequestMapping("/adv1.do")
		public Object add(HomeImg  hig){
			service.addHomeImg(hig);
				return new JsonResult();	
		}
		@ResponseBody
		@RequestMapping("/adv1.do")
		public Object del(String id){
			int n =	service.delHomeImgById(id);
				return new JsonResult(n);	
		}
		@ResponseBody
		@RequestMapping("/adv1.do")
		public Object modify(HomeImg  hig){
			int n=	service.modifyHomeImg(hig);
				return new JsonResult(n);	
		}
		@ResponseBody
		@RequestMapping("/adv1.do")
		public Object findbyid(String id){
			HomeImg hig =service.findHomeImgById(id);
				return new JsonResult(hig);	
		}
		
*/}
	
	

	