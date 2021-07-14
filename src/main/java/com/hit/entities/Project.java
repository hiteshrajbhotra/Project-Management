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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
	@SequenceGenerator(name = "project_seq", sequenceName = "project_seq",
    allocationSize = 1,initialValue=1)
	private long projectId;
	
	private String name;
	
	private String stage;
	
	private String description;
	
	/*
	 * @OneToMany(mappedBy = "project") private List<Employee> employees;
	 */
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
	,fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
	joinColumns = @JoinColumn(name="project_id"),
	inverseJoinColumns = @JoinColumn(name="employee_id"))
	private List<Employee> employeeList;

}
