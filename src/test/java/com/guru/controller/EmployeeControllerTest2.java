package com.guru.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.guru.Employee;
import com.guru.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class EmployeeControllerTest2  {

	public static Employee emp;

	@Autowired
	public  MockMvc mvc;
	
	 
	@Autowired
    WebApplicationContext webApplicationContext;

	@Mock
	EmployeeService service;

	@InjectMocks
	EmployeeController controller = new EmployeeController();


	@SuppressWarnings("deprecation")
	@BeforeEach
	public  void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	    MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 emp = new Employee(1, "GURU", new Date(), new Date(), "JAVA PRACTICE");
		
		 when(service.get(anyLong())).thenReturn(emp);
	}
	@Test
	public void testGetemp() throws Exception {
		System.out.println("service.get(anyLong()) " +service.get(1L));
		String uri ="/id?id=1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		//System.out.println("-----------------> " +mapToJson(mvcResult.getResponse()));
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("resp content---> "+ content);
	//	Employee actresp = mapFromJson(content, Employee.class);
		//assertEquals(emp.getEmpid(), actresp.getEmpid());
	}




}
