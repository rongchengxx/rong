package com.rcb.utils;

import java.io.Serializable;

public class JsonResult implements Serializable{
	private static final long serialVersionUID = 812376774103405857L;
	public static final int SUCCESS=0;
	public static final int ERROR=1;
	/**
	 * 返回是否成功的状�??
	 * 0:表示成功
	 * 1或其他�?�代表失�??
	 */
	private int state;
	/**
	 * 成功�??,返回的JSON数据
	 */
	private Object data;
	/**
	 * 存储提示信息
	 */
	private String message;
	public JsonResult() {
	
	}
	public JsonResult(int state, Object data, String message) {
		this.state = state;
		this.data = data;
		this.message = message;
	}
	public JsonResult(Throwable e) {
		state=ERROR;
		data="";
		message=e.getMessage();
	}
	public JsonResult(Object data){
		state=SUCCESS;
		this.data=data;
		message="";
	}
	public JsonResult(
			int state,Throwable e){
		this.state=state;
		data=null;
		message=e.getMessage();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + "]";
	}
}












