package com.niit.org.controller;

import java.util.List;

import org.niit.com.bean.Info;
import org.niit.com.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Info")  //spring映射
public class InfoController {
	private DbService ds;
	
	@Autowired
	public void setDs(DbService ds) {
		this.ds = ds;
	}


    //spring映射是/info/a/b匹配，返回值对应到jsp页面
	@RequestMapping
	public String showInfos(ModelMap model){
		
		List<Info> infoList = ds.getInfo(0);
		model.addAttribute("infoList",infoList);
		
		return "showInfo";
	}
	
	@RequestMapping("/login")
	public String login(ModelMap model,@RequestParam("name") String name,@RequestParam("intro") String intro){
		
		Info infoList = ds.getInfo(name,intro);
//		if (infoList!=null) {
//			return "showInfo";
//		}	
		System.out.println(infoList);
		System.out.println(name);
		return "error";
	}
	

	@RequestMapping("/insert")
	public String insertInfo(){
		return "insertInfo";
	}
	
	@RequestMapping("/insertData")
	public String insertInfo(@RequestParam("name") String name,@RequestParam("intro") String intro,ModelMap model){
		//校验
		if("".equals(name) || null == name){
			model.addAttribute("msg","姓名不能为空!");
			return "insertInfo";
		}
		
		//数据保存
		Info info = new Info();
		info.setName(name);
		info.setIntro(intro);
		int result = ds.insert(info);
		
		return "redirect:/Info";
	}
	
	@RequestMapping("/update")
	public String updateInfo(int id,ModelMap model){
		List<Info>  infoList = ds.getInfo(id);
		if(infoList != null && infoList.size() > 0){
			model.addAttribute("info",infoList.get(0));
		}
		
		return "updateInfo";
	}
	
	@RequestMapping("/updateData")
	public String updateInfo(Info info,ModelMap model){
		//校验
		if("".equals(info.getName()) || null == info.getName()){
			model.addAttribute("msg","姓名不能为空!");
			return "updateInfo";
		}
		
		//数据保存
		int result = ds.update(info);
		
		return "redirect:/Info";
	}
	
	@RequestMapping("/delete")
	public String deleteInfo(int id,ModelMap model){
		int result = ds.delete(id);		
		return "redirect:/Info";
	}	
}
