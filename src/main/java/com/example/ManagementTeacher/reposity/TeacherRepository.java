package com.example.ManagementTeacher.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ManagementTeacher.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@Query("SELECT t FROM Teacher t WHERE t.email = ?1 AND t.passwordhas = ?2")
    Teacher findByEmailAndPasswordhas(String email,String passwordhas);

	boolean existsByEmail(String email);
}
