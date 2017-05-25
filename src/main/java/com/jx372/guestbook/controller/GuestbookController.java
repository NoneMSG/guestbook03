package com.jx372.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jx372.guestbook.dao.GuestBookDao;
import com.jx372.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController {
	//자동으로 root application 컨테이너 영역의 객체와 링크시키기 위한 annotation
	@Autowired
	private GuestBookDao guestbookDao;
	
	//url을 프로젝트이름으로만 또는 list를 받았을때 처리하기 위한 매핑 어노테이션
	@RequestMapping({"/","/list"})
	public String list(Model model){ //Model객체를 사용해서 데이터를 전달한다.
		List<GuestBookVo> list = guestbookDao.getList();
		model.addAttribute("list",list);
		return "/WEB-INF/views/index.jsp";
	}
	@RequestMapping("/insert") //ModelAttribute 어노테이션으로 객체값을 받아올 수 있다.
	public String insert(@ModelAttribute GuestBookVo vo){
		guestbookDao.insert(vo);
		return "redirect:/list";
	}
		
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no")Long no, Model model ){
		model.addAttribute("no",no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo vo){
		guestbookDao.delete(vo);
		return "redirect:/list";
	}
}
