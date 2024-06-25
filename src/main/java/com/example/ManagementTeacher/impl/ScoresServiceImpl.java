package com.example.ManagementTeacher.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ManagementTeacher.entity.Scores;
import com.example.ManagementTeacher.reposity.ScoresReponsitory;
import com.example.ManagementTeacher.service.ScoresService;

@Service
public class ScoresServiceImpl implements ScoresService {
	
	private ScoresReponsitory scoresReponsitory;

	@Override
	public List<Scores> getAllScores() {
		// TODO Auto-generated method stub
		return scoresReponsitory.findAll();
	}

	@Override
	public Scores saveScores(Scores scores) {
		// TODO Auto-generated method stub
		return scoresReponsitory.save(scores);
	}

	@Override
	public Scores getScoresById(Long id) {
		// TODO Auto-generated method stub
		return scoresReponsitory.findById(id).get();
	}

	@Override
	public Scores updateScores(Scores scores) {
		// TODO Auto-generated method stub
		return scoresReponsitory.save(scores);
	}

	@Override
	public void deleteScoresById(Long id) {
		// TODO Auto-generated method stub
		scoresReponsitory.deleteById(id);
	}

	public ScoresServiceImpl(ScoresReponsitory scoresReponsitory) {
		super();
		this.scoresReponsitory = scoresReponsitory;
	}
	
	

}
