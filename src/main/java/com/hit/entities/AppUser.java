package com.hit.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "app_user")
public class AppUser {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user__user_id_seq")
	@SequenceGenerator(allocationSize = 1,initialValue = 1, name =  "app_user__user_id_seq")
	@Id 
	private Integer userId;
	 
	 private String userName;
	 
	 private String password;
	 
	 
	 private String email;
	 
	 private String mobileNumber;
	 
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	 private String dateOfBirth;
}
