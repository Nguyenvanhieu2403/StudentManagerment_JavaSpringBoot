package com.example.ManagementTeacher.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ManagementTeacher.entity.Subjects;
import com.example.ManagementTeacher.reposity.SubjectsReponsitory;
import com.example.ManagementTeacher.service.SubjectsService;

@Service
public class SubjectsServiceImpl implements SubjectsService {
	
	private SubjectsReponsitory subjectsReponsitory;

	@Override
	public List<Subjects> getAllSubjects() {
		// TODO Auto-generated method stub
		return subjectsReponsitory.findAll();
	}

	@Override
	public Subjects saveSubjects(Subjects Subjects) {
		// TODO Auto-generated method stub
		return subjectsReponsitory.save(Subjects);
	}

	@Override
	public Subjects getSubjectsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subjects updateSubjects(Subjects Subjects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSubjectsById(Long id) {
		// TODO Auto-generated method stub
		subjectsReponsitory.deleteById(id);
	}

	public SubjectsServiceImpl(SubjectsReponsitory subjectsReponsitory) {
		super();
		this.subjectsReponsitory = subjectsReponsitory;
	}
	
//	@Override
//    public Subjects getSubjectsByName(String name) {
//        return subjectsReponsitory.findByName(name);
//    }

}
