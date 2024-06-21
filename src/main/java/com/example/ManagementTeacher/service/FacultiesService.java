package com.example.ManagementTeacher.service;

import java.util.List;

import com.example.ManagementTeacher.entity.faculties;


public interface FacultiesService {
	List<faculties> getAllfacultiess();
	faculties savefaculties(faculties faculties);
	faculties getfacultiesById(Long id);
	faculties updatefaculties(faculties faculties);
	void deleteFacultiesById(Long id);
}
