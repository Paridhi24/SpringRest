package com.cg.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.api.entity.Student;
import com.cg.api.repository.StudentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {

	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentServiceImpl studentService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllToDo(){
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1,"John","AER01234"));
		studentList.add(new Student(2,"Pari","AER01244"));
		studentList.add(new Student(3,"Purnu","AER01534"));
		studentList.add(new Student(4,"Pavan","AER01634"));
		when(studentRepository.findAll()).thenReturn(studentList);
		
		List<Student> result = studentService.retrieveAllStudents();
		assertEquals(4, result.size());
	}
	
}
