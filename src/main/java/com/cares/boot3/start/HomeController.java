package com.cares.boot3.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String start() {
		return "index";
	}
	
	@GetMapping("/getTest")
	public String getTest(String value, Model model) throws Exception {
		System.out.println("value : " + value);
		model.addAttribute("value", value);
		return "common/getResult";
	}
	
	@PostMapping("/arrayTest")
	public String arrayTest(String value, String[] numbers,Model model) throws Exception {
		for(String str : numbers) {
			System.out.println(str);
		}
		return "common/getResult";
	}

}