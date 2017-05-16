package com.rcb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.dao.SettingsDao;
import com.rcb.entity.Settings;
import com.rcb.utils.JsonResult;


	@Controller
	public class SettingsController 
				 extends ExceptionController{
		@Resource
		private SettingsDao settingsDao;
		@ResponseBody
		@RequestMapping("/info.do")
		public Object addSettings(String name,
				String password){
			Settings sett = new Settings("张", "","","", "", "", 1365,4646,4646, 7854, "","","");
			int n=settingsDao.addSettings(sett);
				return new JsonResult(sett);	
		}
		
		
}
