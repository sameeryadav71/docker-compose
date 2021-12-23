package com.web.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Employee;

/**
 * 
 * @author s.yadav
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String employeeEmail);
	
	Employee findByName(String employeeName);
	
	List<Employee> findByDepartment(String department);
}
