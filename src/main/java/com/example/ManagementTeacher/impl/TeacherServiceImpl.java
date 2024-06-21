package com.example.ManagementTeacher.impl;

import org.springframework.stereotype.Service;

import com.example.ManagementTeacher.entity.Teacher;
import com.example.ManagementTeacher.reposity.TeacherRepository;
import com.example.ManagementTeacher.service.TeacherService;


@Service
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherRepository teachersRepository;
	

	public TeacherServiceImpl(TeacherRepository teachersRepository) {
		super();
		this.teachersRepository = teachersRepository;
	}


	@Override
	public Teacher login(String email, String passwordhas) {
		// TODO Auto-generated method stub
		return teachersRepository.findByEmailAndPasswordhas(email, passwordhas);
	}

}
