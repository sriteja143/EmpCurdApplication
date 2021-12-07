package com.guru.repo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.guru.Employee;

//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
//@DirtiesContext(classMode =DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class EmpRepoTest {

	
	@Autowired
	EmpRepo repo;

	Employee emp = new Employee(10, "test", new Date(), new Date(), "junit");
	@Test
	@Rollback(false)
	@Order(1)
	void saveTest() {
	//	Employee resp = repo.save(new Employee(10, "test", new Date(), new Date(), "junit"));
		assertNotNull(repo.save(new Employee(10, "test", new Date(), new Date(), "junit")).getEmpid());
	}
	
	@Test
	@Order(2)
	void findTest() {
		System.out.println(repo.findById(10L).isPresent());
		System.out.println(repo.findById(10L).isEmpty());
		assertEquals(repo.findById(10L).get().getEmpid(), emp.getEmpid());
		
	}
	
	@Test
	@Order(3)
	@Rollback(false)
	void deleteTest() {
		System.out.println("--------------   calling delete ---------------");
		try {
			repo.deleteById(10L);
		} catch (Exception e) {
			fail("Exeception found");
		}
	}
	

}
