package com.example.ManagementStudent.reposity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManagementStudent.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
