package com.guru.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.Employee;
import com.guru.repo.EmpRepo;

@Service
public class EmployeeService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public EmployeeService(EmpRepo repo) {
		super();
		this.repo = repo;
	}
	
	


	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}




	public void setRepo(EmpRepo repo) {
		this.repo = repo;
	}




	@Autowired
	EmpRepo repo;
	
	public  static Employee loademp() {
		Employee emp = new Employee(1, "GURU", new Date(), new Date(), "JAVA PRACTICE");
		return emp;
	}
	
	
	public Employee loademptodb() {
		List<Employee> emplist = repo.findAll();
		Employee emp = null;
		if(emplist.isEmpty())
			emp = repo.save(loademp());
		else
			emp = emplist.get(0);
		return emp;
		
	}
	
	public Employee save(Employee inputEmp,Type type) {
		logger.debug("input emp for :{}, :{}",type.toString(),inputEmp);
		return repo.save(inputEmp);
		
	}


	public String delete(Long id) throws Exception {
		logger.debug("input emp id for delete :{}",id);
		if(repo.findById(id).isPresent()) {
		 logger.debug(" delete record avaiable with :{}",id);
		 repo.deleteById(id);
		 return "Sucess";
		}else {
			throw new Exception(String.format("Record not aviable with provided id :"+ id));
			//return String.format("Record not aviable with provided id :"+ id);
		}
	}
	
	public Employee get(Long id) {
		logger.debug("input emp id for fetch :{}",id);
		if(id == null) {return null;}
		Optional<Employee> emp = repo.findById(id);
		if(emp.isPresent()) {
		 return emp.get();
		}else {
			return null;
		}
	}


	public List<Employee> all() {
		 return repo.findAll();
	}
	
}
