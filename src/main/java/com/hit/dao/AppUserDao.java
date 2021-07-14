package com.hit.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hit.entities.AppUser;

public interface AppUserDao extends CrudRepository<AppUser, Long> {
	
	@Override
	List<AppUser> findAll();

}
