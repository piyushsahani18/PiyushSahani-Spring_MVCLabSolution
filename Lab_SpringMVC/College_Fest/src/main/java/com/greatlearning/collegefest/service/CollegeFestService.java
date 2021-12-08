package com.greatlearning.collegefest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.collegefest.model.Student;

@Service
public interface CollegeFestService {
	
    List<Student> allStudent();
    void deleteById(int student_id);
    Student findById(int theId);
    void insert(Student theStudent);

	
  
}
