/*
 * package com.guru.service;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import java.util.Date;
 * 
 * import org.junit.jupiter.api.BeforeAll; import org.junit.jupiter.api.Test;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.guru.Employee;
 * 
 * @SpringBootTest class EmployeeServiceTest {
 * 
 * @Autowired EmployeeService employeeService; private static Employee emp;
 * 
 * @BeforeAll static void setUpBeforeClass() throws Exception { emp = new
 * Employee(1, "GURU", new Date(), new Date(), "JAVA PRACTICE"); }
 * 
 * @Test void testGet() { assertEquals(employeeService.get(1L).getEmpid(),
 * emp.getEmpid()); }
 * 
 * @Test void testGetWithNull() { assertEquals(employeeService.get(null), null);
 * }
 * 
 * }
 */