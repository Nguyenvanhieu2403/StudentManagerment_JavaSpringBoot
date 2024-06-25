package com.example.ManagementTeacher.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ManagementTeacher.entity.Scores;

public interface ScoresReponsitory extends JpaRepository<Scores, Long> {
	
}
