package com.codingdojo.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class CounterController {
	public String index(HttpSession session) {
		session.setAttribute("count", 0);
		return "index.html";
	}
	
	// ...
	public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "showCount.jsp";
	}
	
	
	@GetMapping("/counter")
	public String showCount() {
		return "showCount.jsp";
	} 

	@GetMapping("/")
	public String setCount(HttpSession session) {
		if(session.getAttribute("count") == null ) {
		session.setAttribute("count", 0);
		}else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count+1);
		}
		return "setCount.jsp";
		
	} 
}
