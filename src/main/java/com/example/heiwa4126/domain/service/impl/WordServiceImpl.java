package com.example.heiwa4126.domain.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import com.example.heiwa4126.domain.model.Word;
import com.example.heiwa4126.domain.service.WordService;
import com.example.heiwa4126.repository.WordRepository;

@Service
public class WordServiceImpl implements WordService{

	@Autowired
	private WordRepository repository;
	
	@Override
	public List<Word> getWords() {
		return repository.findAll(Sort.by("english").ascending());
	}

	@Override
	public List<Word> getWords(Word word) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase();
		return repository.findAll(Example.of(word, matcher));
	}
}
