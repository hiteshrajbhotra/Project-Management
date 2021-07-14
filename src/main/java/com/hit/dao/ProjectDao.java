package com.hit.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hit.entities.Project;

public interface ProjectDao extends CrudRepository<Project, Long> {
	
	@Override
	List<Project> findAll();

}
