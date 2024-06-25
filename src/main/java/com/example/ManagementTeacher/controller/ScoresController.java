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
import com.example.ManagementTeacher.entity.Scores;
import com.example.ManagementTeacher.entity.Student;
import com.example.ManagementTeacher.service.SubjectsService;
import com.example.ManagementTeacher.service.TeacherService;
import com.example.ManagementTeacher.service.ScoresService;
import com.example.ManagementTeacher.service.StudentService;

@Controller
public class ScoresController {

	private static final Logger logger = LoggerFactory.getLogger(ScoresController.class);
	private SubjectsService subjectsService;
	private TeacherService teacherService;
	private StudentService studentService;
	private ScoresService scoresService;
	
	
	public ScoresController(SubjectsService subjectsService, TeacherService teacherService, StudentService studentService, ScoresService scoresService) {
		super();
		this.subjectsService = subjectsService;
		this.teacherService = teacherService;
		this.studentService = studentService;
		this.scoresService = scoresService;
	}

	@GetMapping("/ManagementScores")
	public String GetFormManagementSubjects (Model model) {
		model.addAttribute("Subjects", subjectsService.getAllSubjects());
		model.addAttribute("Teachers", teacherService.getAllTeacher());
		model.addAttribute("Students", studentService.getAllStudent());
		model.addAttribute("Scores", scoresService.getAllScores());
		logger.info("Faclties ManagementScores: {}", model);
		return "ManagementScores";
	}
	
//	@PostMapping("/ManagementSubjects/Save")
//    public String save(@ModelAttribute("Subjects") Subjects subjects) {
//        subjectsService.saveSubjects(subjects);
//        return "redirect:/ManagementSubjects"; // Redirect to a page listing all Subjects
//    }
	
	@PostMapping("/ManagementScores/Save")
    public String saveSubjects(@ModelAttribute("Scores") Scores scores, @RequestParam("idteacher") Long idteacher, @RequestParam("idstudent") Long idstudent, @RequestParam("idsubject") Long idsubject) {
		scores.setIdteacher(idteacher);
		
		scoresService.saveScores(scores);
        return "redirect:/ManagementScores"; // Redirect to a page listing all Subjects
    }

	
	@GetMapping("/ManagementScores/{id}")
	public String deleteScores(@PathVariable Long id) {
		scoresService.deleteScoresById(id);
		return "redirect:/ManagementScores";
	}
	
	@PostMapping("/ManagementScores/edit/{id}")
	public String updateScores(@PathVariable Long id,
		@ModelAttribute("Scores") Scores scores,
		Model model) {
		// get student from database by id
		Scores existingScores = scoresService.getScoresById(id);
		existingScores.setAttendancescore(scores.getAttendancescore());
		existingScores.setMidtermscore(scores.getMidtermscore());
		existingScores.setFinalscore(scores.getFinalscore());
		float averageScore = (float) ((scores.getAttendancescore() * 0.1) +
                (scores.getMidtermscore() * 0.2) +
                (scores.getFinalscore() * 0.7));
		existingScores.setAveragescore(averageScore);
		existingScores.setTerm(scores.getTerm());
		// save updated student object
		scoresService.updateScores(scores);
		return "redirect:/ManagementScores";
	}
	
}
