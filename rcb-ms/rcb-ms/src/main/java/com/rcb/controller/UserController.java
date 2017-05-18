package com.rcb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.User;
import com.rcb.exception.NameException;
import com.rcb.exception.PasswordException;
import com.rcb.service.user.UserService;
import com.rcb.utils.JsonResult;

@Controller
public class UserController 
			 extends ExceptionController{
	@Resource
	private UserService userService;
	
	@ExceptionHandler(NameException.class)
	@ResponseBody
	public JsonResult nameexp(NameException e){
		e.printStackTrace();
		return new JsonResult(2,e);
	}
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public JsonResult pwdexp(PasswordException e){
		e.printStackTrace();
		return new JsonResult(3,e);
	}
	
	@ResponseBody
	@RequestMapping("/login.do")
	public Object login(String account,String password){
		System.out.println(account+","+password);
		User user=userService.login(account, password);
		return new JsonResult(user);
	}
	
	@RequestMapping("/index.do")
	public String toIndex(){
		return "index";
	}

	
	@RequestMapping("/pass.do")
	public String pass(){
		return "pass";
	}
	

	
}
