package com.riddhi.employeemanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.riddhi.employeemanage.model.Employee;
import com.riddhi.employeemanage.service.EmployeeService;
@RestController
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList=employeeService.getAllEmployees();
		return employeeList;
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getById(@PathVariable(value="id") Long id){
		return employeeService.getById(id);
	}
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long id, @RequestBody Employee newEmployee){
		return employeeService.updateEmployee(id, newEmployee);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long id){
		return employeeService.deleteEmployee(id);
	}
}