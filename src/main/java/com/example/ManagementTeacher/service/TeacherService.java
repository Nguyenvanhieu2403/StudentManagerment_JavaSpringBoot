package com.example.ManagementTeacher.service;

import java.util.List;

import com.example.ManagementTeacher.entity.Teacher;

public interface TeacherService {
	Teacher login(String email, String passwordhas);
	
	List<Teacher> getAllTeacher();
	Teacher saveTeacher(Teacher teacher);
	Teacher getTeacherById(Long id);
	Teacher updateTeacher(Teacher teacher);
	void deleteTeacherById(Long id);
}
