package com.hit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hit.dao.EmployeeDoa;
import com.hit.dao.ProjectDao;
import com.hit.entities.Employee;
import com.hit.entities.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectDao dao;
	
	@Autowired
	EmployeeDoa empDao;

	@GetMapping("/new")
	public String createProject(Model model) {

		model.addAttribute("project", new Project());

		List<Employee> allEmployes = empDao.findAll();

		model.addAttribute("allEmployes", allEmployes);

		return "project/new_project";
	}

	@PostMapping("/save")
	public String saveProject(Project project) {
		dao.save(project);
		
		return "redirect:/project/projectList";
	}

	@GetMapping("/projectList")
	public String getProjectList(Model model) {

		List<Project> projectList = dao.findAll();

		model.addAttribute("projectList", projectList);

		return "project/project_list";

	}

}
