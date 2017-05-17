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
	
/*

	@RequestMapping("/modify.do")
	public String modify(){
		return "pass";
	}

	@RequestMapping("/adv1.do")
	public String adv(){
		return "adv";
	}
	@RequestMapping("/add1.do")
	public String add(){
		return "add";
	}
	@RequestMapping("/book1.do")
	public String book(){
		return "book";
	}
	@RequestMapping("/cate1.do")
	public String cate(){
		return "cate";
	}
	@RequestMapping("/cateedit1.do")
	public String cateedit(){
		return "cateedit";
	}
	@RequestMapping("/column1.do")
	public String column(){
		return "column";
	}
	@RequestMapping("/error1.do")
	public String error(){
		return "error";
	}
	@RequestMapping("/info1.do")
	public String info(){
		return "info";
	}
	@RequestMapping("/list1.do")
	public String list(){
		return "list";
	}
	@RequestMapping("/pic1.do")
	public String pic(){
		return "pic";
	}
	@RequestMapping("/tips1.do")
	public String tips(){
		return "tips";
	}
	
	
		*/
	
/*	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult alter(String account,String password){
		User user=userService.alter(account, password);
		return new JsonResult(user);
	}*/
	
	

	
}
