package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Student;
import com.springboot.repository.StudentRepository;

@Service
public class ApplicationService {

	@Autowired
	StudentRepository studentDao;

	public Student getStudentDetailsById(Long id) {
		Student studentDtls = studentDao.getById(id);
		return studentDtls;
	}

	public Student addStudentDtls(Student studentDtls) {
		return studentDao.save(studentDtls);
	}

}
