package com.hit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "app_user_role")
@Data
public class AppUserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "app_user_role__app_user_role_id_seq")
	@SequenceGenerator(allocationSize = 1,initialValue = 1,name = "app_user_role__app_user_role_id_seq")
	private Integer appUserRoleId;
	private Integer userId;
	private Integer roleId;

}
