package com.example.heiwa4126.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import com.example.heiwa4126.domain.model.Word;
import com.example.heiwa4126.domain.service.WordService;

@Slf4j
@RestController
public class IndexController {

	@Autowired
	WordService wordService;

	@RequestMapping("/")
	public String index() {
		log.info("/");
		return "Greetings from Spring Boot!\n";
	}

	@RequestMapping("/list")
	public List<Word> list() {
		log.info("/list");
		return wordService.getWords();
	}

}
