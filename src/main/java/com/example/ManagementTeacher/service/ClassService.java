package com.example.ManagementTeacher.service;

import java.util.List;

import com.example.ManagementTeacher.entity.Classes;


public interface ClassService {
	List<Classes> getAllClass();
	Classes saveClass(Classes Class);
	Classes getClassById(Long id);
	Classes updateClass(Classes Class);
	void deleteClassById(Long id);
}
