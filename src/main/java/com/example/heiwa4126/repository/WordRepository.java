package com.example.heiwa4126.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.heiwa4126.domain.model.Word;

public interface WordRepository extends JpaRepository<Word, String> {
}
