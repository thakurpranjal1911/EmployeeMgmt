package com.glearning.employeeMgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glearning.employeeMgmt.model.EmployeeEntity;
import com.glearning.employeeMgmt.services.EmployeeServices;

@Controller
@RequestMapping("/employee/")
public class EmployeeController {

	@Autowired
	EmployeeServices service;

	@GetMapping()
	public String viewEmployees(Model model) {
		model.addAttribute("employee", service.fetchEmployees());
		return "employee";
	}
	
	@GetMapping("/new")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new EmployeeEntity());
		return "create_emp";
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("employee", new EmployeeEntity());
		return "edit_emp";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name="id") Long id) {
		service.deleteEmployee(id);
		return "redirect:/employee/";
	}
	
	@PostMapping("/save/{id}")
	public String saveEmployee(@PathVariable(name = "id") Long id, EmployeeEntity emp) {
		service.saveEmployee(emp);
		return"redirect:/employee/";
	}

}
