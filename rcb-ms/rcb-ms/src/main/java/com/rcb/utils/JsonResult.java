package com.rcb.utils;

import java.io.Serializable;

public class JsonResult implements Serializable{

	private static final long serialVersionUID = 812376774103405857L;
	/**
	 * 状态属性:0表示成功
	 * 1或其他值表示失败
	 */
	private int state;
	/**
	 * 服务器处理成功,返回JSON数据
	 */
	private Object data;
	/**
	 * 返回提示信息
	 */
	private String message;
	public static final int ERROR=1;
	public static final int SUCCESS=0;
	public JsonResult() {
	}
	public JsonResult(int state, Object data, String message) {
		this.state = state;
		this.data = data;
		this.message = message;
	}
	public JsonResult(Throwable e){
		state=ERROR;
		data=null;
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













