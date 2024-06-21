package com.example.ManagementTeacher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ManagementTeacher.entity.Teacher;
import com.example.ManagementTeacher.service.TeacherService;


@Controller
public class TeacherController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	private TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	
	@GetMapping("/")
	public String GetFormLogin () {
		return "Login";
	}
	
	@PostMapping("/login")
    public String login(@RequestParam("email") String email, 
                        @RequestParam("passwordhas") String passwordhas, 
                        Model model) {
        logger.info("Attempting to log in with email: {}", email);
        Teacher result = teacherService.login(email, passwordhas);
        if (result != null) {
            logger.info("Login successful: {}", result.getName());
            return "ManagermentStudents";
        } else {
            logger.info("Login failed for email: {}", email);
            model.addAttribute("error", "Invalid email or password");
            return "Login";
        }
    }

}
