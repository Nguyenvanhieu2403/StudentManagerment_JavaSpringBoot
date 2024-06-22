package com.example.ManagementTeacher.impl;

import java.util.List;

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
	


	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return teachersRepository.findAll();
	}


	@Override
	public Teacher saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teachersRepository.save(teacher);
	}


	@Override
	public Teacher getTeacherById(Long id) {
		// TODO Auto-generated method stub
		return teachersRepository.findById(id).get();
	}


	@Override
	public Teacher updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teachersRepository.save(teacher);
	}


	@Override
	public void deleteTeacherById(Long id) {
		// TODO Auto-generated method stub
		teachersRepository.deleteById(id);
	}
	
	@Override
    public Teacher register(Teacher teacher) {
        if (!teachersRepository.existsByEmail(teacher.getEmail())) {
            return teachersRepository.save(teacher);
        }
        return null;
    }

}
