package com.chh.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chh.springboot.entity.Employee;

@Controller
public class DemoController {
	
@RequestMapping("/")
public String helloword(Model model) {
	model.addAttribute("theTime",new java.util.Date());
	
	return "helloworld";
}

}
