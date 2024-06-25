package com.example.ManagementTeacher.service;

import java.util.List;

import com.example.ManagementTeacher.entity.Scores;


public interface ScoresService {
	List<Scores> getAllScores();
	Scores saveScores(Scores score);
	Scores getScoresById(Long id);
	Scores updateScores(Scores score);
	void deleteScoresById(Long id);
}
