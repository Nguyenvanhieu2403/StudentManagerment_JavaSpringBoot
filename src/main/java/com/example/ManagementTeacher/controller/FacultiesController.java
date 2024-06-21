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

import com.example.ManagementTeacher.entity.faculties;
import com.example.ManagementTeacher.service.FacultiesService;

@Controller
public class FacultiesController {
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	private FacultiesService facultiesService;

	public FacultiesController(FacultiesService facultiesService) {
		super();
		this.facultiesService = facultiesService;
	}
	
	@GetMapping("/ManagementFaculties")
	public String GetFormManagementFaculties (Model model) {
		model.addAttribute("Faculties", facultiesService.getAllfacultiess());
		logger.info("Faclties model: {}", model);
		return "ManagementFaculties";
	}
	
	@PostMapping("/ManagementFaculties/Save")
    public String save(@RequestParam("Name") String name, Model model) {
        faculties faculty = new faculties();
        faculty.setName(name);
        facultiesService.savefaculties(faculty);
        logger.info("Faculty saved: {}", name);
        return "redirect:/ManagementFaculties"; // Redirect to a page listing all faculties
    }
	
	@GetMapping("/ManagementFaculties/{id}")
	public String deleteFaculties(@PathVariable Long id) {
		facultiesService.deleteFacultiesById(id);
		return "redirect:/ManagementFaculties";
	}
	
	@PostMapping("/ManagementFaculties/edit/{id}")
	public String updateFaculties(@PathVariable Long id,
		@ModelAttribute("Faculty") faculties faculties,
		Model model) {
		// get student from database by id
		faculties existingStudent = facultiesService.getfacultiesById(id);
		existingStudent.setId(id);
		existingStudent.setName(faculties.getName());
		// save updated student object
		facultiesService.updatefaculties(faculties);
		return "redirect:/ManagementFaculties";
	}

}
