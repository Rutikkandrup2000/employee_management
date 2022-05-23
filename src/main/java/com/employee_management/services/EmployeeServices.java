package com.employee_management.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee_management.Dao.EmployeeRepository;
import com.employee_management.pojo.Employee;


@Component
public class EmployeeServices {

	@Autowired
	public EmployeeRepository emp;
	
	public Employee saveEmployee(Employee employee)
	{
		return emp.save(employee);
	}
	
	public List<Employee> getAll(){
		
		List<Employee> list=(List<Employee>)this.emp.findAll();
		Collections.sort(list, (d1,d2) -> Double.compare(d2.getSalary(),d1.getSalary()));
		
		return list;
		
	}
	public Employee update(Employee employee) {
		Employee old=null;
		Optional<Employee>optionaldoctor=emp.findById((int)employee.getEmp_id()); 
		
		old=optionaldoctor.get();
		old.setSalary(employee.getSalary());
		emp.save(old);
		
		return old;
		
	}
	
	
	/*public Optional<Employee> repo(Employee emppojo){
		Optional<Employee> empprg= emp.findById(emppojo.getEmp_id());
		try {
			if(empprg.isPresent()) {}
				
		}
		catch(Exception E) {
		E.printStackTrace();
		}
		return empprg;
	}*/
}
