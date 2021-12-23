package com.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Employee;
import com.web.model.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean deleteEmployee(Integer employeeId) {
		try {
			employeeRepository.deleteById(employeeId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		try {
			return employeeRepository.save(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Integer employeeId, Employee employee) {
		
		Optional<Employee> findById = employeeRepository.findById(employeeId);
		if(findById.isPresent()) {
			employee.setId(employeeId);
			return employeeRepository.save(employee);
		}
		else
		return null;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isPresent())
			return employee.get();
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByName(String employeeName) {
		return employeeRepository.findByName(employeeName);
	}

	@Override
	public List<Employee> getEmployeesByDepartment(String department) {
		return employeeRepository.findByDepartment(department);
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

}
