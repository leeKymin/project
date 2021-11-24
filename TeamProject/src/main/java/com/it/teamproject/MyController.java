package com.it.teamproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root()
	{
		return "index";
	}
	
	@RequestMapping("/admin/welcome")
	public String welcome3() {
		return "admin/welcome3";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "security/loginForm";
	}
	
	@RequestMapping("/loginError")
	public String loginError() {
		return "security/loginError";
	}
}
