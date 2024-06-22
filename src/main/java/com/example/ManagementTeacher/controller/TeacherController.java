	package com.example.ManagementTeacher.controller;
	
	import java.sql.Date;
	import java.util.HashMap;
	import java.util.Map;
	
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
	
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
		
		@GetMapping("/logout")
		public String LogOut() {
			return "Login";
		}
		
	//	@PostMapping("/ManagermentStudents")
	//    public String login(@RequestParam("email") String email, 
	//                        @RequestParam("passwordhas") String passwordhas, 
	//                        Model model) {
	//        logger.info("Attempting to log in with email: {}", email);
	//        Teacher result = teacherService.login(email, passwordhas);
	//        if (result != null) {
	//            logger.info("Login successful: {}", result.getName());
	//            return "ManagermentStudents";
	//        } else {
	//            logger.info("Login failed for email: {}", email);
	//            model.addAttribute("error", "Invalid email or password");
	//            return "Login";
	//        }
	//    }
		
		@PostMapping("/ManagermentStudents/Login")
		@ResponseBody
		public ResponseEntity<?> login(@RequestParam("email") String email, 
		                               @RequestParam("passwordhas") String password, 
		                               Model model) {
		    logger.info("Attempting to log in with email: {}", email);
		    Teacher result = teacherService.login(email, password);
		    if (result != null) {
		        logger.info("Login successful: {}", result.getName());
		        Map<String, String> response = new HashMap<>();
		        response.put("name", result.getName());
		        response.put("email", result.getEmail());
		        return ResponseEntity.ok(response);
		    } else {
		        logger.info("Login failed for email: {}", email);
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		    }
		}
		
		@GetMapping("/ManagermentStudents")
		public String GetFormManagermentStudents () {
			return "ManagermentStudents";
		}
		
		
		@GetMapping("/ManageTeachers")
		public String GetFormManageTeachers (Model model) {
			model.addAttribute("Teachers", teacherService.getAllTeacher());
			logger.info("Teachers model: {}", model);
			return "ManageTeachers";
		}
		
		@PostMapping("/ManageTeachers/Save")
	    public String save(@ModelAttribute("Teachers") Teacher teacher) {
	        teacherService.saveTeacher(teacher);
	        logger.info("Faculty saved: {}", teacher.getName());
	        return "redirect:/ManageTeachers"; // Redirect to a page listing all faculties
	    }
		
		@GetMapping("/ManageTeachers/{id}")
		public String deleteTeacher(@PathVariable Long id) {
			teacherService.deleteTeacherById(id);
			return "redirect:/ManageTeachers";
		}
		
		@PostMapping("/ManageTeachers/edit/{id}")
		public String updateTeacher(@PathVariable Long id,
			@ModelAttribute("teacher") Teacher teacher,
			Model model) {
			// get student from database by id
			Teacher existingStudent = teacherService.getTeacherById(id);
			existingStudent.setId(id);
			existingStudent.setName(teacher.getName());
			// save updated student object
			teacherService.updateTeacher(teacher);
			return "redirect:/ManageTeachers";
		}
		
		@GetMapping("/register")
		public String GetFormRegister () {
			return "Register";
		}
		
		@PostMapping("/register")
		@ResponseBody
		public ResponseEntity<?> register(@RequestParam("name") String name, 
		                       @RequestParam("email") String email, 
		                       @RequestParam("phone") String phone, 
		                       @RequestParam("password") String password, 
		                       @RequestParam("passwordhas") String passwordHas, 
		                       Model model) {

		    if (!password.equals(passwordHas)) {
		    	Map<String, String> response = new HashMap<>();
		        response.put("error", "Authentication passwords do not match. Please try again.");
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		    }

		    Teacher newTeacher = new Teacher();
		    newTeacher.setName(name);
		    newTeacher.setEmail(email);
		    newTeacher.setPhone(phone);
		    newTeacher.setPasswordhas(password);
		    newTeacher.setOnboard(new Date(System.currentTimeMillis()));
		    newTeacher.setRole(1);

		    Teacher registeredTeacher = teacherService.register(newTeacher);

		    if (registeredTeacher != null) {
		        logger.info("Registration successful: {}", registeredTeacher.getName());
		        Map<String, String> response = new HashMap<>();
		        response.put("message", "Sign Up Success!");
		        response.put("redirect", "/login");
		        return ResponseEntity.ok(response);
		    } else {
		        logger.info("Registration failed for email: {}", email);
		        Map<String, String> response = new HashMap<>();
		        response.put("error", "Email is already in use. Please try again.");
		        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		        
		    }
		}
		
	}
