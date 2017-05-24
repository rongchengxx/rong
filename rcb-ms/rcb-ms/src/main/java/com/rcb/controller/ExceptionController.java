package com.rcb.controller;



import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.utils.JsonResult;



public  abstract class ExceptionController {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult exp(Exception e){
		e.printStackTrace();
		return new JsonResult(e);
	}
}




