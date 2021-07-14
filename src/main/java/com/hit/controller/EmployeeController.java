package com.hit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hit.dao.EmployeeDoa;
import com.hit.entities.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeDoa dao;

	@GetMapping("/new")
	public String getEmployeePage(Model model) {

		model.addAttribute("employee", new Employee());
		
		return "employee/new_employee";
	}

	@PostMapping("/save")
	public String saveEmployee(Employee emp) {

		dao.save(emp);

		return "redirect:/employee/employeeList";
	}

	@GetMapping("/employeeList")
	public String getEmployeeList(Model model) {

		List<Employee> empList = dao.findAll();

		model.addAttribute("empList", empList);

		return "employee/employee_list";

	}
}
