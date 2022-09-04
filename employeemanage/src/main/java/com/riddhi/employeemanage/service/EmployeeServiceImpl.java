package com.riddhi.employeemanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.riddhi.employeemanage.model.Employee;
import com.riddhi.employeemanage.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList=new ArrayList<Employee>();
		Iterable<Employee> iterable=employeeRepository.findAll();
		iterable.forEach(employeeList::add);
		return employeeList;
	}
	@Override
	public ResponseEntity<Employee> getById(@PathVariable(value = "id") Long id) {
		Optional<Employee> em=employeeRepository.findById(id);
		return em.isPresent() ? new ResponseEntity<Employee>(em.get(), HttpStatus.OK)
			    : new ResponseEntity("No data found", HttpStatus.NOT_FOUND);
	}
	@Override
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee newEmployee) {
		Optional<Employee> em=employeeRepository.findById(id);
		if (em.isPresent()) {
			   Employee emp = em.get();
			   emp.setName(newEmployee.getName());
			   emp.setDepartment(newEmployee.getDepartment());
			   emp.setDOB(newEmployee.getDOB());
			   emp.setCreatedDateTime(newEmployee.getCreatedDateTime());
			   emp = employeeRepository.save(emp);
			   return ResponseEntity.ok().body(emp);
			  } else {
			   return ResponseEntity.notFound().build();
			  }
	}
	@Override
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long id) {
		Optional<Employee> em=employeeRepository.findById(id);
		if (em.isPresent()) {
			   employeeRepository.delete(em.get());
			   return new ResponseEntity("Employee has been deleted successfully.", HttpStatus.OK);
			  } else {
			   return ResponseEntity.notFound().build();
		}
		
	}
}
