package com.chh.springboot.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootRestController {
	@Value("${coach.name}")
	private String coach;

	@Value("${team.name}")
	private String team;
	
	
	@GetMapping("/getteam")
	public String getTeam() {
		return "Coach =="+this.coach + "Team=="+ this.team;
	}

	
	@GetMapping("/")
	public String showHome() {
		return "Hi Spring boot" + LocalDateTime.now();
	}

	@GetMapping("/dailyworkout")
	public String getDailyWork() {
		return "Run daily 5K";
	}

}
