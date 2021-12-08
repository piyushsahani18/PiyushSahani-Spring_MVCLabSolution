package com.greatlearning.collegefest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int student_id;

	@Column(name = "studentName")
	private String studentName;

	@Column(name = "department")
	private String department;

	@Column(name = "country")
	private String country;

	// allArgs Constructor
	public Student(int student_id, String studentName, String department, String country) {
		this.student_id = student_id;
		this.studentName = studentName;
		this.department = department;
		this.country = country;
	}

	// Constructor to add Student
	public Student(String studentName, String department, String country) {
		this.studentName = studentName;
		this.department = department;
		this.country = country;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	

	// toString Method
	@Override
	public String toString() {
		return "Student [country=" + country + ", department=" + department + ", student_id=" + student_id
				+ ", studentName=" + studentName + "]";
	}

	// Getters and Setters
	public int getstudent_id() {
		return student_id;
	}

	public void setstudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
