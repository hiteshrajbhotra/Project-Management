package com.hit.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq",
    allocationSize = 1,initialValue=1)
	private Long employeeId;
	private String empName;
	private String isEmployeed;
	private String email;
	
	/*
	 * @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
	 * CascadeType.PERSIST, CascadeType.REFRESH})
	 * 
	 * @JoinColumn(name="project_id") private Project project;
	 */
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
			                CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",
	           joinColumns = @JoinColumn(name="employee_id"),
	           inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projectList;
	

}
