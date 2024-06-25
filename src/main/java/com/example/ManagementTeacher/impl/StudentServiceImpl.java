package com.example.ManagementTeacher.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ManagementTeacher.entity.Student;
import com.example.ManagementTeacher.reposity.StudentReponsitory;
import com.example.ManagementTeacher.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentReponsitory studentReponsitory;

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentReponsitory.findAll();
	}	

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentReponsitory.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentReponsitory.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentReponsitory.save(student);
	}
	
	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentReponsitory.deleteById(id);
	}

	public StudentServiceImpl(StudentReponsitory subjectsReponsitory) {
		super();
		this.studentReponsitory = subjectsReponsitory;
	}
	
//	@Override
//    public Student getStudentByName(String name) {
//        return studentReponsitory.findByName(name);
//    }

}
