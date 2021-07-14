package com.hit.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hit.entities.AppRole;

public interface AppRoleDao extends CrudRepository<AppRole,Long>{
	
	@Override
	List<AppRole> findAll();

}
