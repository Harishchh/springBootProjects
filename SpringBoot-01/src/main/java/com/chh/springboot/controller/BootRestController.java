package com.chh.springboot.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootRestController {
	
	
	@GetMapping("/")
	public String showHome() {
	return "Hi Spring boot"+LocalDateTime.now();
	}

}
