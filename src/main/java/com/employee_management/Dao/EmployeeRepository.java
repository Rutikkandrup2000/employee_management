package com.employee_management.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_management.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
