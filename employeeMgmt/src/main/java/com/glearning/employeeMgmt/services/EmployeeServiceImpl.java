package com.glearning.employeeMgmt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.employeeMgmt.dao.EmployeeRepository;
import com.glearning.employeeMgmt.model.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

	@Autowired
	EmployeeRepository repository;

	@Override
	public List<EmployeeEntity> fetchEmployees() {
		return repository.findAll();
	}

	@Override
	public EmployeeEntity fetchEmployeeById(long id) {
		Optional<EmployeeEntity> empTemp = repository.findById(id);
		if (empTemp.isPresent()) {
			return empTemp.get();
		}
		return null;
	}

	@Override
	public void saveEmployee(EmployeeEntity employee) {
		repository.save(employee);
		repository.flush();
	}

	@Override
	public void deleteEmployee(long id) {
		repository.deleteById(id);
	}

}
