package com.employee_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management.pojo.Employee;
import com.employee_management.services.EmployeeServices;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServices empservices;
	
	@PostMapping("/enterEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return empservices.saveEmployee(employee);
	}
	
	@GetMapping("/employeesalary")
	public List<Employee> getsalary(){
		
		List<Employee> list=empservices.getAll();
		return list;
	}
	@PutMapping("employee/update")
	public Employee update(@RequestBody Employee pojo) {
		return empservices.update(pojo);
	}
	
	
	
	/*@GetMapping("/Employee/{id}")
	public Optional<Employee>empoptional(Employee pojo)
	{
		Optional<Employee>emppop=empservices.repo(pojo);
		return emppop;
	}*/
}
