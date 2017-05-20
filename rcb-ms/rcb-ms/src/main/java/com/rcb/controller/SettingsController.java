package com.rcb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.Settings;
import com.rcb.service.settings.SettingsService;
import com.rcb.utils.JsonResult;

@Controller
	public class SettingsController{
		@Resource
		private SettingsService service;

		@RequestMapping("/info.do")
		public String infox() {
			return "info";
		}
<<<<<<< HEAD
		@ResponseBody
		@RequestMapping("/info/addsettings.do")
=======

	/*	@ResponseBody
		@RequestMapping("/info/modify.do")
>>>>>>> 292a367fef6fc1e8cde90a9b3acf922e9b1fd47e
		public Object addSettings(String title, String logo, String uri, String key_word, String contacts, int tel, int phone,
				int fax, int qq, String email, String site, String content){
			
			Settings s2=service.addSettings(title, logo, uri, key_word, contacts, tel, phone, fax, qq, email, site, content);
				return new JsonResult(s2);	
<<<<<<< HEAD
		}
=======
		}*/
>>>>>>> 292a367fef6fc1e8cde90a9b3acf922e9b1fd47e
		
		/* 用到的jsp是info.jsp
		 * 请在js文件夹下面创建js文件，在其中书写相应的内容
		 * 本方法请自行传递相应参数，参数请参考Service层的参数
		 * 返回json对象用以判断是否成功
		 * */

		@ResponseBody
		@RequestMapping("/info/modify.do")
		public Object modifySettings(String title, String logo, String uri, String key_word, String contacts, int tel, int phone,
				int fax, int qq, String email, String site, String content){
			
			Settings s2=service.modifySettings(title, logo, uri, key_word, contacts, tel, phone, fax, qq, email, site, content);
			return new JsonResult(s2);	
		
<<<<<<< HEAD
=======
		}
>>>>>>> 292a367fef6fc1e8cde90a9b3acf922e9b1fd47e
}

		
