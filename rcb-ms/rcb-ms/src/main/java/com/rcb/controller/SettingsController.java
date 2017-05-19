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
		@ResponseBody
		@RequestMapping("/info/addsettings.do")
		public Object addSettings(String title, String logo, String uri, String key_word, String contacts, int tel, int phone,
				int fax, int qq, String email, String site, String content){
			
			Settings s2=service.addSettings(title, logo, uri, key_word, contacts, tel, phone, fax, qq, email, site, content);
				return new JsonResult(s2);	
		}
}

		
