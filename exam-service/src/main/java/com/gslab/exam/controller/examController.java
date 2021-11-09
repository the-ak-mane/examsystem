package com.gslab.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.exam.entity.Question;
import com.gslab.exam.service.ExamService;

@RestController
@RequestMapping("/exam")
public class examController {
	
	
	@Autowired
	ExamService examService;
	
	@GetMapping("/")
	public List<Question> getExam(int setId){
		
		
		List<Question> list = new ArrayList<>();
		Question que = null ;
		que.setQuestionDesc("this is first question");
		que.setOption1("answer1");
		que.setOption2("answer2");
		que.setOption3("answer3");
		que.setOption4("answer4");
		que.setAnswer(1);
		
		list.add(que);
		return list;
		
	}
	

}
