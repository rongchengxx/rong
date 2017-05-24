package com.rcb.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcb.entity.OneMenu;
import com.rcb.entity.SinglePage;
import com.rcb.entity.TwoMenu;
import com.rcb.service.one_menu.OneMenuService;
import com.rcb.service.single_page.SinglePageService;
import com.rcb.service.two_menu.TwoMenuService;
import com.rcb.utils.JsonResult;

@Controller
public class SinglePageAController {
	//分页相关
	@Value("#{paging}")
	private Properties pagingProp;
	
	@Resource
	private SinglePageService singlePageServive;
	
	@Resource
	private OneMenuService oneMenuService;
	@Resource
	private TwoMenuService twoMenuService;
	
	@RequestMapping("/list.do")
	public String list(){
		return "list";
	}
	
	@RequestMapping("/add.do")
	public String add(){
		return "add";
	}
	
	@RequestMapping("/amend.do")
	public String amend(){
		return "amend";
	}
	//查询指定页码的SinglePage内容
	@RequestMapping("/findsinglepagebypage.do")
	@ResponseBody
	public JsonResult findSinglePageByPage(String page) {
		return loadSinglePages(page);
	}
	//删除指定id的SinglePage
	@RequestMapping("/delsinglepage.do")
	@ResponseBody
	public JsonResult delSinglePage(String id, String now_page) {
		int n = singlePageServive.delSinglePageById(id);
		return loadSinglePages(now_page);
	}
	
	//删除多条id的SinglePage
	@RequestMapping("/delssinglepage.do")
	@ResponseBody
	public JsonResult delsSinglePage(String[] id, String now_page) {
		int n = singlePageServive.delsSinglePageById(id);
		System.out.println(n);
		return loadSinglePages(now_page);
	}
	
	/**
	 * 查询指定页码的SinglePage内容
	 * 
	 * @param page 要查询的页
	 * @return
	 */
	public JsonResult loadSinglePages(String page) {
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
		int max_page = (int) Math.ceil(new Double(singlePageServive.findSinglePageCount())/rows);
		if(max_page == 0){
			return new JsonResult();
		}
		if(new Integer(page)>max_page){
			page = max_page+"";
		}
		List<SinglePage> list = singlePageServive.findSinglePageByPage(new Integer(page)*rows-rows,rows);
		JsonResult jr = new JsonResult(list);
		jr.setMessage(max_page+"");
		return jr;
	}
	
	
	/**
	 * 查询所有一级菜单
	 * 
	 * @return
	 */
	@RequestMapping("/loadonemenu.do")
	@ResponseBody
	public JsonResult loadOneMenu() {
		List<OneMenu> oneMenu = oneMenuService.findOneMenuAll();
		System.out.println(oneMenu.toString());
		JsonResult jr = new JsonResult(oneMenu);
		return jr;
	}
	
	/**
	 * 查询所有二级菜单
	 * 
	 * @return
	 */
	@RequestMapping("/loadtwomenu.do")
	@ResponseBody
	public JsonResult loadTwoMenu() {
		List<TwoMenu> twoMenu = twoMenuService.findTwoMenuAll();
		System.out.println(twoMenu.toString());
		JsonResult jr = new JsonResult(twoMenu);
		return jr;
	}
	/**
	 * 查询指定一级菜单下的所有二级菜单或其所有内容
	 * 
	 * @return
	 */
	@RequestMapping("/loadtwomenuorcontent.do")
	@ResponseBody
	public JsonResult loadTwoMenuOrContent(String onemenu) {
		List<TwoMenu> twoMenu = twoMenuService.findTwoMenuByOneMenuId(onemenu);
		//没有二级菜单，就去查询一级菜单下的内容
		if (twoMenu.isEmpty()) {
			System.out.println("kong");
			List<SinglePage> sp = singlePageServive.findSinglePageByOneMenuId(onemenu);
			JsonResult jr = new JsonResult(sp);
			jr.setState(1);
			System.out.println(jr);
			return jr;
		}
		System.out.println(twoMenu.toString());
		JsonResult jr = new JsonResult(twoMenu);
		return jr;
	}
	/**
	 * 根据一级菜单和二级菜单的id查询
	 * @param onemenuid
	 * @param twomenuid
	 * @return
	 */
	@RequestMapping("/findsinglepagebyonetwoid.do")
	@ResponseBody
	public JsonResult findSinglePageByOneTwoId(String onemenuid,String twomenuid) {
		List<SinglePage> singlePage = singlePageServive.findSinglePageByOneTwoId(onemenuid,twomenuid);
		System.out.println(singlePage.toString());
		JsonResult jr = new JsonResult(singlePage);
		return jr;
	}
	/**
	 * 关键字模糊查询
	 * 
	 * @return
	 */
	@RequestMapping("/findsinglepagebykeyword.do")
	@ResponseBody
	public JsonResult findSinglePageByKeyWord(String keyWord) {
		System.out.println(keyWord);
		List<SinglePage> singlePage = singlePageServive.findSinglePageByKeyWord(keyWord);
		System.out.println(singlePage.toString());
		JsonResult jr = new JsonResult(singlePage);
		return jr;
	}
}
