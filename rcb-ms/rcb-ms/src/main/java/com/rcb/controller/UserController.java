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
		User user=userService.login(account, password);
/*		System.out.println("id:"+user.getId());
*/		return new JsonResult(user);
	}
	
	@RequestMapping("/index.do")
	public String toIndex(){
		return "index";
	}
	@RequestMapping("/admin.do")
	public String Admin(){
		return "admin";
	}
	@RequestMapping("/pass.do")
	public String pass(){
		return "pass";
	}

	//修改密码controller的修改动态操作
	@RequestMapping("/pass/modify.do")
	@ResponseBody
	public Object passModify(String userId, String password,String newPassword){
		User user=userService.modifyUser(userId, password, newPassword);
		return new JsonResult(user);
	}
	
}
