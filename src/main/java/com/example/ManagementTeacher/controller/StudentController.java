package com.example.ManagementTeacher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ManagementTeacher.entity.Teacher;
import com.example.ManagementTeacher.entity.Student;
import com.example.ManagementTeacher.entity.Classes;
import com.example.ManagementTeacher.service.TeacherService;
import com.example.ManagementTeacher.service.StudentService;
import com.example.ManagementTeacher.service.ClassService;


@Controller
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	private StudentService studentService;
	private TeacherService teacherService;
	private ClassService classService;
	
	
	public StudentController(StudentService studentService, TeacherService teacherService, ClassService classService) {
		super();
		this.studentService = studentService;
		this.teacherService = teacherService;
		this.classService = classService;
	}

	@GetMapping("/ManagementStudents")
	public String GetFormManagemenStudents (Model model) {
		model.addAttribute("Students", studentService.getAllStudent());
		model.addAttribute("Teachers", teacherService.getAllTeacher());
		model.addAttribute("Classes", classService.getAllClass());
		logger.info("Students model: {}", model.getAttribute("Students"));
		return "ManagermentStudents";
	}
	
//	@PostMapping("/ManagementSubjects/Save")
//    public String save(@ModelAttribute("Subjects") Subjects subjects) {
//        subjectsService.saveSubjects(subjects);
//        return "redirect:/ManagementSubjects"; // Redirect to a page listing all Subjects
//    }
	
	@PostMapping("/ManagementStudents/Save")
    public String saveSubjects(@ModelAttribute("Student") Student student, @RequestParam("idteacher") Long idteacher, @RequestParam("idclass") Long idclass) {
		student.setIdteacher(idteacher);
		student.setIdclass(idclass);
        studentService.saveStudent(student);
        return "redirect:/ManagermentStudents"; // Redirect to a page listing all Subjects
    }

	
	@GetMapping("/ManagementStudents/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/ManagementStudents";
	}
	
	@PostMapping("/ManagementStudents/edit/{id}")
	public String updateStudents(@PathVariable Long id,
		@ModelAttribute("Student") Student student,
		Model model) {
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setDob(student.getDob());
		existingStudent.setPhone(student.getPhone());
		existingStudent.setGender(student.getGender());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setIdclass(student.getIdclass());
		existingStudent.setIdteacher(student.getIdteacher());
		// save updated student object
		studentService.updateStudent(student);
		return "redirect:/ManagementStudents";
	}
	
}
