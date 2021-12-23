package com.web.service;

import java.util.List;

import com.web.model.Employee;

/**
 * 
 * @author s.yadav
 *
 */
public interface EmployeeService {
	
	boolean deleteEmployee(Integer employeeId);
	
	Employee addEmployee(Employee employee);;
	
	Employee updateEmployee(Integer employeeId, Employee employee);
	
	Employee getEmployeeById(Integer employeeId);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeByName(String employeeName);
	
	List<Employee> getEmployeesByDepartment(String department);
	
	Employee getEmployeeByEmail(String email);

}
