package com.rcb.controller;

import com.rcb.entity.Gbook;
import com.rcb.entity.OneMenu;
import com.rcb.service.gbook.GbookService;
import com.rcb.utils.JsonResult;
import com.rcb.dao.GbookDao;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GbookController {
	//分页相关
	@Value("#{paging}")
	private Properties pagingProp;
	
	@Resource
	private GbookService service;
	
	@RequestMapping("/book.do")
	public String book() {
		return "book";
	}
	
	/*
	 * 删除路径/book/delBook.do
	 * 删除多条/book/delBooks.do
	 * 自动加载/book/loadBook.do
	 * 
	 * 涉及jsp为book。jsp文件，请在js文件夹下面创建js文件
	 * 请自行按照别的方法案例书写方法
	 * 如需传递参数请参考service
	 * 
	 * */
	
	//删除单条留言
	@RequestMapping("/book/delBook.do")
	@ResponseBody
	public JsonResult delBook(String id,String now_page) {
		int n = service.delGbookById(id);
		return loadBooks(now_page);
	}
	//删除多条留言
	@RequestMapping("/book/delBooks.do")
	@ResponseBody
	public JsonResult delBooks(String[] id,String now_page) {
		int n = service.delGbooksById(id);
		System.out.println(now_page);
		return loadBooks(now_page);
	}
	//根据页码检索留言
	@RequestMapping("/book/loadBook.do")
	@ResponseBody
	public JsonResult loadBook(String page) {
		return loadBooks(page);
	}
	
	//根据页码检索留言
	public JsonResult loadBooks(String page) {
		int rows =3;
		Enumeration<Object> keys = pagingProp.keys();
	    while (keys.hasMoreElements()) {
	    	String pagingKey = "rows";
	    	String key = null;
			try {
				key = new String(keys.nextElement().toString().getBytes("UTF-8"), "UTF-8");
				if(pagingKey.equals(key)){
					rows = new Integer(new String(pagingProp.getProperty(key).getBytes("UTF-8"), "UTF-8"));
				}
			} catch (Exception e) {
				rows = 5;
				e.printStackTrace();
			}
	    }
		
		int max_page = (int) Math.ceil(new Double(service.findGbookCount())/rows);
		if(max_page == 0){
			return new JsonResult();
		}
		if(new Integer(page)>max_page){
			page = max_page+"";
		}
		List<Gbook> gbooks = service.findGbookByPage(new Integer(page)*rows-rows,rows);
		//Iterator<Gbook> it = gbooks.iterator();
		/*while (it.hasNext()) {
			Gbook gb = (Gbook) it.next();
			System.out.println("条数"+gb.toString());
		}*/
		JsonResult jr = new JsonResult(gbooks);
		jr.setMessage(max_page+"");
		return jr;
	}
	
	
	
	
	
	
	
	
	
}
