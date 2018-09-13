package com.cg.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.api.entity.Student;
import com.cg.api.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> retrieveAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Optional<Student> retrieveStudent(long id) {
		return studentRepository.findById(id);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	

}
