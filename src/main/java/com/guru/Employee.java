package com.guru;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micrometer.core.instrument.util.StringUtils;


@Entity
//@EntityListeners({ Employee.class })
public class Employee {

	private static final Logger log = LoggerFactory.getLogger(Employee.class);
	
	@Id
	private long empid;
	private String empname;
	private Date createdDate = new Date();
	private Date updatedDate ;
	private String dept;
//	private String remarks;
	
	
	public long getEmpid() {
		return empid;
	}


	public void setEmpid(long empid) {
		this.empid = empid;
	}


	public String getEmpname() {
		return empname;
	}


	public void setEmpname(String empname) {
		this.empname = empname;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}

	
	
	public Employee(long empid, String empname, Date createdDate, Date updatedDate, String dept) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.dept = dept;
	}
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@PrePersist
	@PreUpdate
    public void prePersistFunction() {

        log.info("PrePersist method called");

        if(StringUtils.isEmpty(dept)){
        	dept = "STANDARD_CUSTOMER";
        }
        
//        if("NONIT".equalsIgnoreCase(dept)){
//        	throw new Exception("MENIONED DEPT IS NOT ABLE TO SAVE");
//        }
    }
	
	@PostUpdate
	@PostPersist
	@PostLoad
	@Transactional
	public void postLoadAttributes() {
		 log.debug("caling  ------------------ postLoadAttributes---------------");
	  if (dept != null && "STANDARD_CUSTOMER".equals(dept)) {
	    log.debug("SYTEM GENERATED DEPT ::::::::::::::::");
	  }
	}
	
}
