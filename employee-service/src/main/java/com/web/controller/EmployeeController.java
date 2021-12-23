package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Employee;
import com.web.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public boolean deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
	@GetMapping("/getEmployeeByName/{employeeName}")
	public Employee getEmployeeByName(@PathVariable("employeeName")  String employeeName) {
		return employeeService.getEmployeeByName(employeeName);
	}
	
	@GetMapping("/getEmployeeByEmail/{employeeEmail}")
	public Employee getEmployeeByEmail(@PathVariable("employeeEmail") String employeeEmail) {
		return employeeService.getEmployeeByEmail(employeeEmail);
	}
	
	@GetMapping("/getEmployeesByDepartment/{department}")
	public List<Employee> getEmployeesByDepartment(@PathVariable("department") String department){
		return employeeService.getEmployeesByDepartment(department);
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/updateEmployee/{employeeId}")
	public Employee updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employeeId, employee);
	}
	
	@GetMapping("getEmployeeById/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
}
