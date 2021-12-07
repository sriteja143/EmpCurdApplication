package com.guru.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guru.Employee;
import com.guru.exceptionhandling.EmployeeNotFoundException;
import com.guru.exceptionhandling.ErrortypeLocal;
import com.guru.service.EmployeeService;
import com.guru.service.Type;

@RestController("/")
public class EmployeeController {

	@Autowired
	EmployeeService empservice;
	
	@GetMapping
	public String echo() {
		return "Welcome Buddy !!!";
	}
	@GetMapping("/sample")
	public Employee getemp() {
		return empservice.loademptodb();
	}
	
	@PostMapping
	public Employee save(@RequestBody Employee emp) {
		return empservice.save(emp, Type.SAVE);
	}
	
	@PutMapping
	public Employee update(@RequestBody Employee emp) {
		return empservice.save(emp, Type.UPDATE);
	}
	
	@DeleteMapping
	public String delete(@RequestParam Long id) throws Exception {
		System.out.println("delete method calling");
		return empservice.delete(id);
	}
	
	
	@GetMapping("/id")
	public Employee get(@RequestParam Long id) {
		System.out.println("@GetMapping(\"/id\")");
		Employee resp = empservice.get(id);
		System.out.println("resp get id  "+ resp);
		return empservice.get(id);
	}
	 
	
	@GetMapping("/all")
	public List<Employee>  get() {
		return empservice.all();
	}
	
	@PostMapping("/myerror")
	public void  get(@RequestBody ErrortypeLocal error) throws Exception {
		if(error.equals(ErrortypeLocal.EMPLOYEENOTFOUND)){
			throw new EmployeeNotFoundException("emp not found with provided id");
		}
		throw new Exception("Created error");
	}
	
}
