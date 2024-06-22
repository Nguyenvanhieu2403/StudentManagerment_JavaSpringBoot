package com.example.ManagementTeacher.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ManagementTeacher.entity.Student;

public interface StudentReponsitory extends JpaRepository<Student, Long> {
	
}
