package com.example.heiwa4126.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class IndexController {
	@RequestMapping("/")
	public String index() {
		log.info("/");
		return "Greetings from Spring Boot!!\n";
	}
}
