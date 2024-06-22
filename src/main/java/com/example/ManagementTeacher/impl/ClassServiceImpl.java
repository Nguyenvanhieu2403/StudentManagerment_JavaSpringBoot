package com.example.ManagementTeacher.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ManagementTeacher.entity.Classes;
import com.example.ManagementTeacher.reposity.ClassReponsitory;
import com.example.ManagementTeacher.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	
	private ClassReponsitory classReponsitory;

	@Override
	public List<Classes> getAllClass() {
		// TODO Auto-generated method stub
		return classReponsitory.findAll();
	}

	@Override
	public Classes saveClass(Classes Class) {
		// TODO Auto-generated method stub
		return classReponsitory.save(Class);
	}

	@Override
	public Classes getClassById(Long id) {
		// TODO Auto-generated method stub
		return classReponsitory.findById(id).get();
	}

	@Override
	public Classes updateClass(Classes Class) {
		// TODO Auto-generated method stub
		return classReponsitory.save(Class);
	}

	@Override
	public void deleteClassById(Long id) {
		// TODO Auto-generated method stub
		classReponsitory.deleteById(id);
	}

	public ClassServiceImpl(ClassReponsitory classReponsitory) {
		super();
		this.classReponsitory = classReponsitory;
	}
	
	

}
