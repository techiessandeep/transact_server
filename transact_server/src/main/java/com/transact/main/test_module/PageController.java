package com.transact.main.test_module;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping("/")
	public ModelAndView loginPage() {
		return new ModelAndView("com/transact/main/login");
	}

	@RequestMapping("/welcome.html")
	public ModelAndView welcomePage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping("/com/transact/main/test_module")
	public ModelAndView helloWorld() {
		String message = "HELLO SPRING MVC HOW R U";
		return new ModelAndView("hellopage", "message", message);
	}

}