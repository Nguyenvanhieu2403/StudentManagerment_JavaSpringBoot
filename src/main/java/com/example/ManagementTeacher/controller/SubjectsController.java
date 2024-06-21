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

import com.example.ManagementTeacher.entity.Subjects;
import com.example.ManagementTeacher.entity.Teacher;
import com.example.ManagementTeacher.service.SubjectsService;
import com.example.ManagementTeacher.service.TeacherService;

@Controller
public class SubjectsController {

	private static final Logger logger = LoggerFactory.getLogger(SubjectsController.class);
	private SubjectsService subjectsService;
	private TeacherService teacherService;
	
	
	
	public SubjectsController(SubjectsService subjectsService, TeacherService teacherService) {
		super();
		this.subjectsService = subjectsService;
		this.teacherService = teacherService;
	}

	@GetMapping("/ManagementSubjects")
	public String GetFormManagementSubjects (Model model) {
		model.addAttribute("Subjects", subjectsService.getAllSubjects());
		 model.addAttribute("Teachers", teacherService.getAllTeacher());
		logger.info("Faclties model: {}", model);
		return "ManagementSubjects";
	}
	
//	@PostMapping("/ManagementSubjects/Save")
//    public String save(@ModelAttribute("Subjects") Subjects subjects) {
//        subjectsService.saveSubjects(subjects);
//        return "redirect:/ManagementSubjects"; // Redirect to a page listing all Subjects
//    }
	
	@PostMapping("/ManagementSubjects/Save")
    public String saveSubjects(@ModelAttribute("Subjects") Subjects subjects, @RequestParam("idteacher") Long idteacher) {
        subjects.setIdteacher(idteacher);
        subjectsService.saveSubjects(subjects);
        return "redirect:/ManagementSubjects"; // Redirect to a page listing all Subjects
    }

	
	@GetMapping("/ManagementSubjects/{id}")
	public String deleteSubjects(@PathVariable Long id) {
		subjectsService.deleteSubjectsById(id);
		return "redirect:/ManagementSubjects";
	}
	
	@PostMapping("/ManagementSubjects/edit/{id}")
	public String updateSubjects(@PathVariable Long id,
		@ModelAttribute("Faculty") Subjects Subjects,
		Model model) {
		// get student from database by id
		Subjects existingStudent = subjectsService.getSubjectsById(id);
		existingStudent.setId(id);
		existingStudent.setName(Subjects.getName());
		// save updated student object
		subjectsService.updateSubjects(Subjects);
		return "redirect:/ManagementSubjects";
	}
	
}
