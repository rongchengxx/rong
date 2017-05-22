package com.rcb.controller;

import com.rcb.entity.Gbook;
import com.rcb.entity.OneMenu;
import com.rcb.service.gbook.GbookService;
import com.rcb.utils.JsonResult;
import com.rcb.dao.GbookDao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GbookController {
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
		System.out.println("id"+id);
		int n = service.delGbookById(id);
		System.out.println("条数"+n);
		return loadBooks(now_page);
	}
	//删除多条留言
	@RequestMapping("/book/delBooks.do")
	@ResponseBody
	public JsonResult delBooks(String[] id) {
		System.out.println("id"+id[0]+id[1]);
		int n = service.delGbooksById(id);
		System.out.println("条数"+n);
		return loadBooks("1");
	}
	//根据页码检索留言
	@RequestMapping("/book/loadBook.do")
	@ResponseBody
	public JsonResult loadBook(String page) {
		return loadBooks(page);
	}
	
	//根据页码检索留言
	public JsonResult loadBooks(String page) {
		String max_page = service.findGbookMaxPage();
		if(new Integer(page)>new Integer(max_page)){
			page = max_page;
		}
		System.out.println("page"+page);
		List<Gbook> gbooks = service.findGbookByPage(new Integer(page)*2-2);
		Iterator<Gbook> it = gbooks.iterator();
		/*while (it.hasNext()) {
			Gbook gb = (Gbook) it.next();
			System.out.println("条数"+gb.toString());
		}*/
		JsonResult jr = new JsonResult(gbooks);
		jr.setMessage(Math.ceil(new Double(max_page)/2)+"");
		System.out.println(jr);
		return jr;
	}
	
	
	
	
	
	
	
	
	
}
