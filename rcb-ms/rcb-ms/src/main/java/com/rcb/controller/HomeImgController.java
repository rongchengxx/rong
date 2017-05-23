package com.rcb.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.HomeImg;
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
		
		@RequestMapping("/advpop.do")
		public String advpop() {
			return "advpop";
		}
		@ResponseBody
		@RequestMapping("/adv/add.do")
		public Object add(String title,String url,String link,String content,int seq){
//			HomeImg hig= new HomeImg("", url, title, seq, 1, content, link,1 , 1);
			HomeImg hig= new HomeImg();
			hig.setTitle(title);
			hig.setUrl(url);
			hig.setLink(link);
			hig.setContent(content);
			hig.setSeq(seq);
			HomeImg h1=service.addHomeImg(hig);
			return new JsonResult(h1);	
		}
		@ResponseBody
		@RequestMapping("/advpop/modify.do")
		public Object modify(String id,String title, String url,String  link,String content,int seq){
			int row=service.modifyHomeImg(id,title, url, link, content, seq);
			return new JsonResult(row);	
		}
		
		@ResponseBody
		@RequestMapping("/adv/delAdv.do")
		public Object del(String id){
				HomeImg h3=service.delHomeImgById(id);
				return new JsonResult(h3);	
		}
		
		@ResponseBody
		@RequestMapping("/adv/loadAdv.do")
		public Object findall(){
			List<HomeImg> list=	service.findHomeImgAll();
				return new JsonResult(list);	
		}
		/*
		
		@ResponseBody
		@RequestMapping("/adv1.do")
		public Object findbyid(String id){
			HomeImg hig =service.findHomeImgById(id);
				return new JsonResult(hig);	
		}
		
*/}
	
	

	