package com.gslab.student.VO;

import java.util.List;

import com.gslab.student.entity.Student;

public class ResponseTemplateVO {
	// private Student student;
	private List<Question> questions;
	Set set;

	public ResponseTemplateVO(List<Question> questions, Set set) {
		// this.student = student;
		this.set = set;
		this.questions = questions;
	}

	public ResponseTemplateVO() {

	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

}
