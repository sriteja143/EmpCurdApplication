package com.guru.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guru.Employee;
import com.guru.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest3 {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private EmployeeService service;

  @Test
  void getTest() throws Exception {
	  Employee input =  new Employee(1, "GURU", new Date(), new Date(), "JAVA PRACTICE");
	  when(service.get(anyLong())).thenReturn(input);
	  MvcResult mvcResult = mockMvc.perform(get("/id?id=1")).andReturn();
	  System.out.println("mvcResult.getResponse().getStatus() --->"+mvcResult.getResponse().getStatus());
	  System.out.println("result -->"+ mvcResult.getResponse().getContentAsString());
	  String expted = mvcResult.getResponse().getContentAsString();
	  
	  Employee resp = mapFromJson(expted, Employee.class);
	  assertEquals(resp.getEmpname(), input.getEmpname());
  }
  
  
  
  @Test
  void deleteTest() throws Exception {
	  when(service.delete(anyLong())).thenReturn("SUCCESS");
	  MvcResult mvcResult = mockMvc.perform(delete("/id?id=1")).andReturn();
	  System.out.println("mvcResult.getResponse().getStatus() --->"+mvcResult.getResponse().getStatus());
	  System.out.println("result -->"+ mvcResult.getResponse().getContentAsString());
	  
	  assertEquals(HttpStatus.OK, mvcResult.getResponse().getStatus());
  }

  public <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
}