package com.example.ManagementTeacher.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ManagementTeacher.entity.Subjects;
import com.example.ManagementTeacher.entity.Teacher;

public interface SubjectsReponsitory extends JpaRepository<Subjects, Long> {
	
}
