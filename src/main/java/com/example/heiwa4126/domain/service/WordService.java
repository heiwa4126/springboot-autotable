package com.example.heiwa4126.domain.service;

import java.util.List;
import com.example.heiwa4126.domain.model.Word;

public interface WordService {
	public List<Word> getWords();
	public List<Word> getWords(Word word);

}
