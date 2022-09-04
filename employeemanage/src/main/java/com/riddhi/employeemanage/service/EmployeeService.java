package com.riddhi.employeemanage.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.riddhi.employeemanage.model.Employee;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployees();
	ResponseEntity<Employee> getById(@PathVariable(value = "id") Long id);
	Employee createEmployee(@RequestBody Employee employee);
	ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee newEmployee);
	ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long id);
}
