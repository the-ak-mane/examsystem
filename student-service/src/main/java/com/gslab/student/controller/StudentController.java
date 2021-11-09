package com.gslab.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.student.VO.Question;
import com.gslab.student.VO.ResponseTemplateVO;
import com.gslab.student.VO.Set;
import com.gslab.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/login")
	public String login() {
		return "logged in successfully";
	}
	
	@GetMapping("/exam")
	public List<Question> getExam(int setId) {
		return studentService.getExam(setId);
		
	}
	
	
}
