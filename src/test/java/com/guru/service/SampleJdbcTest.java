package com.guru.service;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guru.Employee;

@SpringBootTest
class SampleJdbcTest {
	@Autowired
	EmployeeService service;
	@Test
	void testGetmessage() {
		service.save(new Employee(11, "jdbc test", new Date(), new Date(), "JUNIT"), Type.SAVE);
		
	}
	
	@Test
	void testDeleteMsg() throws Exception {
		service.delete(11L);
	}

}
