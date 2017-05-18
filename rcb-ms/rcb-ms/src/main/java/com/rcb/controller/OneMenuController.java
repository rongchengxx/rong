package com.rcb.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rcb.entity.OneMenu;
import com.rcb.service.one_menu.OneMenuService;
import com.rcb.utils.JsonResult;



@Controller
public class OneMenuController extends ExceptionController{
	@Resource
	private OneMenuService oneMenuService;
	//跳转页面
	@RequestMapping("/column.do")
	public String colume() {
		
		return "column";
	}
	
	//加载OneMenu
	@RequestMapping("/column/loadColumn.do")
	@ResponseBody
	public JsonResult loadColume(){
		List<OneMenu> result
				=oneMenuService.findOneMenuAll();
		return new JsonResult(result);
	}
	
	/*@RequestMapping("/column/add.do")
	@ResponseBody
	public JsonResult addColume(){
		
		return null;
	}*/
	
	@RequestMapping("/pub.do")
	public String pub() {
		return "pub";
	}
/*	@RequestMapping("/sub.do")
	public void sub(HttpServletRequest request) {
		System.out.println("11");
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		Iterator<String> names = req.getFileNames();
		
		while (names.hasNext()) {
			String name = (String) names.next();// 获取文件域的name属性名=file.getName());
			MultipartFile file = req.getFile(name);// 获取文件
			String fileName = file.getOriginalFilename();// 文件名
			System.out.println(fileName);
			if (StringUtils.isNotBlank(fileName))// 确保提交来的表单中有file
			{
				try {
					fileSaveSrc(file, name, projectPath);// 将文件保存
					out.println(fileName+"图片保存成功");
				} catch (IOException e) {
					e.printStackTrace();
					out.println("图片保存失败！！！"+e);
					out.close();
				}
			}else{
				out.println("请添加背景图片");
				out.close();
				return;
			}
		}
	}*/
}
