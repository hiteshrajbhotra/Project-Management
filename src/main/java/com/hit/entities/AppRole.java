package com.hit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "app_role")
public class AppRole {
    
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "app_role__role_id_seq")
	@SequenceGenerator(initialValue = 1,allocationSize = 1,name = "app_role__role_id_seq")
	@Id
	private long roleId;
	
	@Column(name = "role_name")
	private String roleName;
}
