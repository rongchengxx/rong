package com.rcb.utils;

import java.util.UUID;

public class CreateUUID {
	//利用UUID生成主键
		public static String createId(){
			String id=UUID.randomUUID().toString();
			return id;	
		}
		public static void main(String[] args) {
			String id = createId();
			System.out.println(id);
		}
}
