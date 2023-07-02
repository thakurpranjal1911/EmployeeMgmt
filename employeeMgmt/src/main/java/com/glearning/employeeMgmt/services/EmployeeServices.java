package com.glearning.employeeMgmt.services;

import java.util.List;

import com.glearning.employeeMgmt.model.EmployeeEntity;

public interface EmployeeServices {

	List<EmployeeEntity> fetchEmployees();
	
	EmployeeEntity fetchEmployeeById(long id);

	void saveEmployee(EmployeeEntity employee);

	void deleteEmployee(long id);

}