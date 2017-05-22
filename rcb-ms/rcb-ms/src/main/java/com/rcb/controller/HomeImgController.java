package com.rcb.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.HomeImg;
import com.rcb.service.home_img.HomeImgService;
import com.rcb.utils.CreateUUID;
import com.rcb.utils.JsonResult;


	@Controller
	public class HomeImgController{
		@Resource
		private HomeImgService service;
		//跳转adv页面
		@RequestMapping("/adv.do")
		public String adv() {
			return "adv";
		}
		//adv页面添加内容
		@ResponseBody
		@RequestMapping("/adv/addAdv.do")
		public Object add(String id,String title,String url,String link,String content,Integer seq){
//			HomeImg hig= new HomeImg(id, url, title, seq, type, content, link, source, isshow);
			/*HomeImg hig= new HomeImg();
			hig.setTitle(title);
			hig.setUrl(url);
			hig.setLink(link);
			hig.setContent(content);
			hig.setSeq(seq);*/
			id=CreateUUID.createId();
			int row=service.addHomeImg(id,title, url, link, content, seq);
			return new JsonResult(row);	
		}
		//adv页面删除内容
		@ResponseBody
		@RequestMapping("/adv/delAdv.do")
		public Object del(String id){
				HomeImg h3=service.delHomeImgById(id);
				return new JsonResult(h3);	
		}
		//adv页面加载内容
		@ResponseBody
		@RequestMapping("/adv/loadAdv.do")
		public Object findall(){
			List<HomeImg> list=	service.findHomeImgAll();
				return new JsonResult(list);	
		}
		
		//跳转advpop页面
		@RequestMapping("/advpop.do")
		public String advpop() {
			return "advpop";
		}
		
		@ResponseBody
		@RequestMapping("/advpop/loadAdvpop.do")
		public Object findById(String id){
			HomeImg hig =service.findHomeImgById(id);
				return new JsonResult(hig);	
		}
		
		@ResponseBody
		@RequestMapping("/advpop/modifyAdvpop.do")
		public Object modify(String id,String title, String url,String  link,String content,Integer seq){
			int row=service.modifyHomeImg(id, title, url, link, content, seq);
			return new JsonResult(row);	
		}
		
}
	
	

	