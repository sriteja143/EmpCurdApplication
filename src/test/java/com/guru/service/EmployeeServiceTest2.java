package com.guru.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.guru.Employee;
import com.guru.repo.EmpRepo;

//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
class EmployeeServiceTest2 {

	  EmployeeService employeeService;
	  Employee emp;
	
	
	  //@MockBean
	  //  @InjectMocks
	  
	  @Mock
	  private  EmpRepo repo;

	  @InjectMocks
	  private EmployeeService reqService = new EmployeeService(); 
	  
	  private  List<Employee> list = new ArrayList<>();
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public  void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		 emp = new Employee(1, "GURU", new Date(), new Date(), "JAVA PRACTICE");
		
		 list.add(emp);
		 System.out.println(repo);
		 employeeService = new EmployeeService(repo);
		 when(repo.findById(anyLong())).thenReturn(Optional.of(emp));
		 when(repo.findAll()).thenReturn(list);
		 when(repo.save(emp)).thenReturn(emp);
	}

	@Test
	void testGetWithRecordPositive() {
	//    emp = new Employee(1, "GURU", new Date(), new Date(), "JAVA PRACTICE");
	//	employeeService = new EmployeeService(repo);
	//	Optional<Employee> opemp  = Optional.of(emp);
	//	when(repo.findById(anyLong())).thenReturn(opemp);
	//	when(employeeService.get(anyLong())).thenReturn(emp);
		
		assertEquals(employeeService.get(1L).getEmpid(), new Employee(1, "GURU", new Date(), new Date(), "JAVA PRACTICE").getEmpid());
	}
	
	@Test
	void testGetWithNull() {
		/** 
		 * is it not possiable ? when changing in this method total testcases are effecting
		 */
		//when(repo.findById(null)).thenReturn(Optional.of(null));
		assertEquals(employeeService.get(null), null);
	}
	
	
	@Test
	void testAll() {
		System.out.println(list.size());
		assertEquals(employeeService.all(), list);
	}
	
	
	@Test
	void testDeletePostive() throws Exception {
		assertEquals(employeeService.delete(1L), "Sucess");
	}
	
	@Test
	void testDeleteWithNull() throws Exception {
		Assertions.assertThrows(Exception.class, ()->{employeeService.delete(null);});
	}
	
	@Test
	void testSave() throws Exception {
		Assertions.assertEquals(employeeService.save(emp, Type.SAVE), emp);
	}
	
	@Test
	void testloademptodb() throws Exception {
		Assertions.assertEquals(employeeService.loademptodb(), emp);
	}
	

}
