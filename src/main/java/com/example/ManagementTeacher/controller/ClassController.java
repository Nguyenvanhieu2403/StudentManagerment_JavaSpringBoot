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

import com.example.ManagementTeacher.entity.Classes;
import com.example.ManagementTeacher.entity.Teacher;
import com.example.ManagementTeacher.entity.faculties;
import com.example.ManagementTeacher.service.ClassService;
import com.example.ManagementTeacher.service.TeacherService;
import com.example.ManagementTeacher.service.FacultiesService;

@Controller
public class ClassController {

	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);
	private ClassService classService;
	private TeacherService teacherService;
	private FacultiesService facultiesService;
	

	public ClassController(ClassService classService, TeacherService teacherService,
			FacultiesService facultiesService) {
		super();
		this.classService = classService;
		this.teacherService = teacherService;
		this.facultiesService = facultiesService;
	}

	@GetMapping("/ManagementClass")
	public String GetFormManagementClass (Model model) {
		model.addAttribute("Classes", classService.getAllClass());
		model.addAttribute("Teachers", teacherService.getAllTeacher());
		model.addAttribute("Faculties", facultiesService.getAllfacultiess());
		logger.info("Faclties model: {}", model);
		return "ManagementClass";
	}
	
//	@PostMapping("/ManagementSubjects/Save")
//    public String save(@ModelAttribute("Subjects") Subjects subjects) {
//        subjectsService.saveSubjects(subjects);
//        return "redirect:/ManagementSubjects"; // Redirect to a page listing all Subjects
//    }
	
	@PostMapping("/ManagementClass/Save")
    public String saveSubjects(@ModelAttribute("Class") Classes Class, @RequestParam("idteacher") Long idteacher, @RequestParam("idfaculty") Long idfaculty) {
        Class.setIdteacher(idteacher);
        Class.setIdfaculty(idfaculty);
        classService.saveClass(Class);
        return "redirect:/ManagementClass"; // Redirect to a page listing all Subjects
    }

	
	@GetMapping("/ManagementClass/{id}")
	public String deleteClass(@PathVariable Long id) {
		classService.deleteClassById(id);
		return "redirect:/ManagementClass";
	}
	
	@PostMapping("/ManagementClass/edit/{id}")
	public String updateClass(@PathVariable Long id,
		@ModelAttribute("Class") Classes Class,
		Model model) {
		// get student from database by id
		Classes existingClass = classService.getClassById(id);
		existingClass.setId(id);
		existingClass.setName(Class.getName());
		existingClass.setIdfaculty(Class.getIdfaculty());
		existingClass.setIdteacher(Class.getIdteacher());
		// save updated student object
		classService.updateClass(Class);
		return "redirect:/ManagementClass";
	}
	
}
