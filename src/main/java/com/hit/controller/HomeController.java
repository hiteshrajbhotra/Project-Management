package com.hit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hit.dao.EmployeeDoa;
import com.hit.dao.ProjectDao;
import com.hit.dto.EmployeeProject;
import com.hit.entities.Employee;
import com.hit.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeDoa edao;
	
	@Autowired
	ProjectDao pdao;

	
	@GetMapping("/")
	public String getHomePage(Employee emp,Model model) {
		
		List<net.sf.json.JSONObject> empProjectListForChart = 
				new ArrayList<net.sf.json.JSONObject>();
		
		List<Employee> empList = edao.findAll();
		
		List<Project> prgList = pdao.findAll();
		
		List<EmployeeProject> empProjList = edao.getEmployeeProjectDtls();
		
		
		model.addAttribute("employeeList",empList);
		
		model.addAttribute("projList", prgList);
		
		model.addAttribute("empProjList", empProjList);
		
		
		for(int i=0;i<empProjList.size();i++) {
			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
			
			json.put("label", empProjList.get(i).getEmpName());
			
			json.put("value", empProjList.get(i).getProjCount());
			
			empProjectListForChart.add(json);
			
		}
		
		System.out.println("hhhhhhh "+empProjectListForChart);
		
		model.addAttribute("empProjectListForChart", empProjectListForChart);
		
		return "commons/home";
	}
	
	
	
}
