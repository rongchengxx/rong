package com.rcb.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.utils.RandomValidateCode;

	@Controller
	public class ImageGenController {
	    //登录获取验证码
	    @RequestMapping("/getSysManageLoginCode.do")
	    @ResponseBody
	    public String getSysManageLoginCode(HttpServletResponse response,
	            HttpServletRequest request) {
	        response.setContentType("image/jpg");// 设置相应类型,告诉浏览器输出的内容为图片
	        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
	        response.setHeader("Cache-Control", "no-cache");
	        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
	        response.setDateHeader("Expire", 0);
	        RandomValidateCode randomValidateCode = new RandomValidateCode();
	        try {
	            randomValidateCode.getRandcode(request, response,"imagecode");// 输出图片方法
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return "";
	    }

	    //验证码验证
	    @RequestMapping("/checkimagecode.do")
	    @ResponseBody
	    public String checkTcode(HttpServletRequest request,HttpServletResponse response){
	        String validateCode = request.getParameter("validateCode");
	        String str1=validateCode.toLowerCase();
	        String code = null;
	        //1:获取cookie里面的验证码信息
	        Cookie[] cookies = request.getCookies();
	        for (Cookie cookie : cookies) {
	            if ("imagecode".equals(cookie.getName())) {
	                code = cookie.getValue();
	                break;
	            }
	        }
	        String str2= code.toLowerCase();
	      /* if(str1==null||str1.trim().isEmpty()){
	    	   throw new ImgCodeException("验证码为空");
	       }else  if(!str1.equals(str2)){
	    	   throw new ImgCodeException("验证码错误");
	       }*/
	   
	        //1:获取session验证码的信息
	        //String code1 = (String) request.getSession().getAttribute("");
	        //2:判断验证码是否正确
	        if(!StringUtils.isEmpty(validateCode) && str1.equals(str2)){
	            return "ok";    
	        }else if(StringUtils.isEmpty(validateCode)){
	        	return "empty";
	        }else{
	        	return "error";
	        }
	        //这里我没有进行字母大小模糊的验证处理，感兴趣的你可以去试一下！
	    }

	}

