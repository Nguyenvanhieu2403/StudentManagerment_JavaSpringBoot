package com.example.ManagementTeacher.service;

import java.util.List;

import com.example.ManagementTeacher.entity.Subjects;


public interface SubjectsService {
	List<Subjects> getAllSubjects();
	Subjects saveSubjects(Subjects Subjects);
	Subjects getSubjectsById(Long id);
	Subjects updateSubjects(Subjects Subjects);
	void deleteSubjectsById(Long id);
}
