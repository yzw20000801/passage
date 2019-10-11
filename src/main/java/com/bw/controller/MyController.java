package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.First;
import com.bw.bean.Last;
import com.bw.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MyController {
	@Resource
	private StudentService service;
	
	@RequestMapping("list.do")
	public String list(Model model,
			@RequestParam(defaultValue="")String bname,
			@RequestParam(defaultValue="1")int cpage) {
		PageHelper.startPage(cpage, 3);
		Map<String, Object> map=new HashMap<>();
		map.put("bname", bname);
		map.put("cpage", cpage);
		List<Map<String,Object>> list = service.findlist(map);
		PageInfo<Map<String, Object>> pageInfo=new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		return "list";
	}
	
	@RequestMapping("delete.do")
	@ResponseBody
	public Object delete(String bids) {
		int i=0;
		String[] split = bids.split(",");
		for (String string : split) {
			int x=service.deleteFirst(Integer.parseInt(string));
			int y=service.deleteMiddle(Integer.parseInt(string));
			i++;
		}
		return i;
	}
	
	@RequestMapping("toadd.do")
	public String toadd(Model model) {
		List<Last> list =service.findtype();
		model.addAttribute("list", list);
		return "add";
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public Object toadd(String bname,int age,int[] cids) {
		int i=service.addFirst(bname,age);
		int bid=service.findbid();
		int j=service.addMiddle(bid,cids);
		return i;
	}
	
	@RequestMapping("toupdate.do")
	public String toupdate(Model model,int bid) {
		First first=service.getFirst(bid);
		List<Last> list =service.findtype();
		List<Integer> list2=service.getcids(bid);
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("f", first);
		return "show";
	}
	
	@RequestMapping("update.do")
	@ResponseBody
	public Object update(int bid,String bname,int age,int[] cids) {
		int i=service.deleteMiddle(bid);
		int j=service.update(bid,bname,age);
		int p=service.addMiddle(bid, cids);
		return p;
	}
}
