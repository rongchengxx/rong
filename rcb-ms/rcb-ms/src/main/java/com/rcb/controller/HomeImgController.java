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
import com.rcb.utils.JsonResult;


	@Controller
	public class HomeImgController 
				 extends ExceptionController{
		@Resource
		private HomeImgDao homeImgDao;
		@ResponseBody
		@RequestMapping("/adv")
		public Object findHomeImgAll(){
			List<HomeImg> list=	homeImgDao.findHomeImgAll();
				return new JsonResult(list);	
		}
		
		
}
