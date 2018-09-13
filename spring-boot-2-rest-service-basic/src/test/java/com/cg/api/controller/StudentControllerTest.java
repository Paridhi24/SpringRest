package com.cg.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.api.SpringBoot2RestServiceBasicApplication;
import com.cg.api.entity.Student;
import com.cg.api.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBoot2RestServiceBasicApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentControllerTest {

	@Mock
	private StudentService service;

	private MockMvc mockMvc;

	@Spy
	@InjectMocks
	private StudentController controller = new StudentController();

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testGetAllStudents() throws Exception {
		/*List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1,"John","AER01234"));
		studentList.add(new Student(2,"Pari","AER01244"));
		studentList.add(new Student(3,"Purnu","AER01534"));
		studentList.add(new Student(4,"Pavan","AER01634"));
		when(service.retrieveAllStudents()).thenReturn(studentList);

		mockMvc.perform(get("/students")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].passportNumber").value("AER01234"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
				.andExpect( MockMvcResultMatchers.jsonPath("$[1].name").value("Pari"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].passportNumber").value("AER01244"));
*/
//		verify(service, times(1)).retrieveAllStudents();
//		verifyNoMoreInteractions(service);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/students").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(0))).andDo(print());
	}

	@Test
	public void testGetStudentById() throws Exception {
		Optional<Student> student;
		student = Optional.of(new Student());
		student.get().setId(1l);
		student.get().setName("John");
		student.get().setPassportNumber("AER01234");
		Mockito.when(service.retrieveStudent(Mockito.anyLong())).thenReturn(student);
		mockMvc.perform(MockMvcRequestBuilders.get("/student/1")).andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}
}
