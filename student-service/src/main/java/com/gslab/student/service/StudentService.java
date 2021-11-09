package com.gslab.student.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gslab.student.VO.Question;
import com.gslab.student.VO.ResponseTemplateVO;
import com.gslab.student.VO.Set;
import com.gslab.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StudentRepository studentRepository;

	public List<Question> getExam(int setId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		List<Question> questions = null;
		try {

			URI url = new URI("http://localhost:5000/exam/");
			ResponseEntity<List<Question>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Question>>() {
					});
			 questions = response.getBody();
			//return questions;
			//vo.setQuestions(questions);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;

	}

}
