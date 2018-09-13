package com.cg.api.service;

import java.util.List;
import java.util.Optional;

import com.cg.api.entity.Student;

public interface StudentService {

	public List<Student> retrieveAllStudents();
	public Optional<Student> retrieveStudent(long id);
	public void deleteStudent(Long id);
	public Student createStudent(Student student);
}
