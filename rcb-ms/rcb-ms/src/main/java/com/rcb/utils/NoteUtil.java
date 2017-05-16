package com.rcb.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	public static String md5(String src){
		try {
			//获取MD5对象
			MessageDigest md= MessageDigest.getInstance("MD5");
			//加密处理
			byte[] output
				=md.digest(src.getBytes());
			//return new String(output);
			//利用Base64转换成字符串结果
			String ret
				=Base64.encodeBase64String(output);
			return ret;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}
	//利用UUID生成主键�??
	public static String createId(){
		String id=UUID.randomUUID().toString();
		return id;	
	}
	public static void main(String[] args){
		System.out.println(createId());
	}
}







