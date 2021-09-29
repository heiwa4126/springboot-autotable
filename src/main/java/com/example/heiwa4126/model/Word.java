package com.example.heiwa4126.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "words")
public class Word {
	@Id
	private String english;
	private String japanese;
}