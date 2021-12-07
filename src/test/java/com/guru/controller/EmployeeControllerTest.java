package com.guru.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guru.Employee;
import com.guru.service.EmployeeService;

//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeControllerTest  {

	private static Employee emp;

	public MockMvc mvc;
	
	public static String defaulturi = "/";
	 
	@Autowired
    WebApplicationContext webApplicationContext;

	@Mock
	EmployeeService service;

	@InjectMocks
	EmployeeController controller = new EmployeeController();
	
	

	   public String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   public <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	   

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
			emp = new Employee(1, "GURU", new Date(), new Date(), "JAVA PRACTICE");
			when(service.get(anyLong())).thenReturn(emp);
	}

	@Test
	void testEcho() {
		controller.echo();
	}

	@Test
	public void testGetemp() throws Exception {
		when(service.get(anyLong())).thenReturn(emp);
		System.out.println("service.get(anyLong()) " +service.get(1L));
		String uri = defaulturi+"id?id=1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri))
				.andReturn();
		System.out.println("-----------------> " +mapToJson(mvcResult.getResponse()));
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		//String content = mvcResult.getResponse().getContentAsString();
		//Employee actresp = mapFromJson(content, Employee.class);
		//assertEquals(emp.getEmpid(), actresp.getEmpid());
	}

//	@Test
	void testSave() throws Exception {
		System.out.println(defaulturi);
	    String inputJson = mapToJson(emp);
	    System.out.println("input :: "+ inputJson);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(defaulturi).accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		//System.out.println("req " + mvcResult.getRequest().getContentAsString());
		System.out.println("response " + mvcResult.getResponse().getContentAsString());
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}


//	@Test
	void testDelete() throws Exception {
		String uri = defaulturi+"?id=1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}


}
