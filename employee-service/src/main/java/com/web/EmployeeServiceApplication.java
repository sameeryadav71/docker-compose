package com.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.model.Employee;
import com.web.model.repository.EmployeeRepository;


@SpringBootApplication
public class EmployeeServiceApplication {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
//	@GetMapping("/getAllEmployees")
//	public List<Employee> getAllEmployees(){
//		return employeeRepository.findAll();
//	}
//	
	@PostConstruct
	public void addEmployee() {
		
        int max = 100000;
        int min = 1;
        int range = max - min + 1;
        int randomNumber = (int)(Math.random() * range) + min;
        
		Employee user = new Employee();		
		user.setName("XYZ"+randomNumber);
		user.setEmail("XYZ@gmail.com"+randomNumber);
		user.setDepartment("XYZ"+randomNumber);
		
		employeeRepository.save(user);
	}

}
