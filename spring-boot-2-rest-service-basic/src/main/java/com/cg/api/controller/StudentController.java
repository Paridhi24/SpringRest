package com.cg.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.api.entity.Student;
import com.cg.api.exception.StudentException;
import com.cg.api.model.Response;
import com.cg.api.service.StudentService;
import com.cg.api.util.PayloadValidator;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents() {
		logger.info("Returning all the students");
		return new ResponseEntity<List<Student>>(studentService.retrieveAllStudents(), HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id") long id) throws StudentException {
		logger.info("ToDo id to return " + id);
		Optional<Student> student = studentService.retrieveStudent(id);
		if (student == null || student.get().getId()<=0) {
			throw new StudentException("Student doesn´t exist");
		}
		return new ResponseEntity<Optional<Student>>(studentService.retrieveStudent(id),HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeToDoById(@PathVariable("id") long id) throws StudentException {
		logger.info("Student id to remove " + id);
		Optional<Student> student = studentService.retrieveStudent(id);
		if (student == null || student.get().getId() <= 0) {
			throw new StudentException("Student to delete doesn´t exist");
		}
		studentService.deleteStudent(id);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "ToDo has been deleted"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) throws StudentException {
		logger.info("Payload to save " + student);
		if (!PayloadValidator.validateCreatePayload(student)) {
			throw new StudentException("Payload malformed, id must not be defined");
		}
		return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.PATCH)
	public ResponseEntity<Student> updateToDo(@RequestBody Student payload) throws StudentException {
		logger.info("Payload to update " + payload);
		Optional<Student> student = studentService.retrieveStudent(payload.getId());
		if (student == null || student.get().getId() <= 0) {
			throw new StudentException("ToDo to update doesn´t exist");
		}
		return new ResponseEntity<Student>(studentService.createStudent(payload), HttpStatus.OK);
	}

}
