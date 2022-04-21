 package com.mvc.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.impl.dao.AlienDao;
import com.mvc.impl.model.Alien;

@Controller
public class HomeController {

	@Autowired
	AlienDao alienDao;
	
	@ModelAttribute // wiil call first and Aliens available for all method
	public void modelData(Model m) {
		m.addAttribute("name", "Aliens");
	}

	
	@RequestMapping("/")
	public String show() {
		return "index";
	}

	@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int a, @RequestParam("num2") int b) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("data");
		int j = a + b;
		mv.addObject("j", j);

		return mv;
	}

	/*
	 * @RequestMapping("addAlien") public String addAlien(Alien a,Model
	 * m @RequestParam("aid") int a, @RequestParam("aname") String b,Model m ) {
	 * 
	 * m.addAttribute("alien", a); return "data"; }
	 */
	
	
	/*
	 * @GetMapping("addAlien") public String addAlien(Alien a,Model
	 * m @RequestParam("aid") int a, @RequestParam("aname") String b,Model m ) {
	 * 
	 * m.addAttribute("alien", a); return "data"; }
	 */
	
	@RequestMapping(value="addAlien", method = { RequestMethod.GET, RequestMethod.POST })
	public String addAlien( @ModelAttribute("attr") Alien a) {
		alienDao.saveData(a);
		return "result";
	} 
	
	@GetMapping("data1")
	public String  data1(Model m) {
		m.addAttribute("attr",alienDao.getAlien());
		return "result";
	}
	
	@GetMapping("fetchData")
	public String  fetchData(@RequestParam int aid, Model m) {
		m.addAttribute("attr",alienDao.fetchData(aid));
		return "result";
	}
}
