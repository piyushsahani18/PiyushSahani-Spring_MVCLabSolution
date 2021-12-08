package com.greatlearning.collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.collegefest.model.Student;
import com.greatlearning.collegefest.service.CollegeFestService;

@Controller
@RequestMapping("/Students")
public class CollegeFestController{
	
	
	@Autowired
	private CollegeFestService collegeFestService;
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> Students = collegeFestService.allStudent();
		
		model.addAttribute("Students", Students);
		
		return "StudentList";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd( Model theModel) {

		// get the Student from the service
        Student student = new Student();
		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", student);

		// send over to our form
		return "FestForm";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("student_id") int theId, Model theModel) {

		// get the Student from the service
		Student theStudent = collegeFestService.findById(theId);

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "FestForm";
	}

	@PostMapping("/insert")
	public String saveStudent(@RequestParam("Student_id") int student_id, @RequestParam("StudentName") String studentName,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(student_id);
		Student theStudent;
		if (student_id != 0) {
			theStudent = collegeFestService.findById(student_id);
			theStudent.setStudentName(studentName);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(studentName, department, country);
		// save the Student
		collegeFestService.insert(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/Students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("student_id") int theId) {

		// delete the Student
		collegeFestService.deleteById(theId);

		// redirect to /Students/list
		return "redirect:/Students/list";

	}

	}
	
