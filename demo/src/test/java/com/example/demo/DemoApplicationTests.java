package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Test
	void findByName() {
		List<Customer> list =  customerRepo.findByName("또치");
		System.out.println(list);
		assertEquals("또치", list.get(0).getName());
	}
	
	//@Test
	void findall() {
		Iterable<Customer> list = customerRepo.findAll();
		//list.forEach(cust -> System.out.println(cust.getName())  );
		Iterator<Customer> iter = list.iterator();
		while(iter.hasNext()) {
			Customer cust =  iter.next();
			System.out.println(cust.getName()); 
		}
	}
	
	//@Test
	void save() {
		Customer cust = new Customer();
		cust.setName("김유신");
		cust.setPhone("010-1111-2222");
		Customer result = customerRepo.save(cust);
		assertEquals(cust.getName(), result.getName());
	}

}
