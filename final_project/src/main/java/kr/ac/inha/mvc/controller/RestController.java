package kr.ac.inha.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.inha.mvc.service.JspService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	JspService jspService;
	
	@RequestMapping("/gugu")
	public String gugu(int num) {
		String result ="구구단 : ";
		for (int i = 1; i <= 9; i++) {
			result = result + num + "*"+ i + "=" + (num * i) + " ";
		}
		
		return result;
		
	}
	@RequestMapping("/count")
	public String count() {
		return jspService.count();
	}

}
