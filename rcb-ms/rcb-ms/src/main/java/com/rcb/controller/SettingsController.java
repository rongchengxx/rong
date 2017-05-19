package com.rcb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.dao.SettingsDao;
import com.rcb.entity.Settings;
import com.rcb.service.settings.SettingsService;
import com.rcb.utils.JsonResult;


	@Controller
	public class SettingsController{
		@Resource
		private SettingsService service;

		@RequestMapping("/info.do")
		public String info() {
			return "info";
		}
		
		/* 用到的jsp是info.jsp
		 * 请在js文件夹下面创建js文件，在其中书写相应的内容
		 * 本方法请自行传递相应参数，参数请参考Service层的参数
		 * 返回json对象用以判断是否成功
		 * */
		@ResponseBody
		@RequestMapping("/info/modify.do")
		public Object addSettings(){
				//未完成 修改设置
				return null;
		}
		
		
}

		
