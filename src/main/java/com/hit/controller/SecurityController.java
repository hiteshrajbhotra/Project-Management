package com.hit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hit.dao.AppRoleDao;
import com.hit.dao.AppUserDao;
import com.hit.dao.AppUserRoleDao;
import com.hit.entities.AppRole;
import com.hit.entities.AppUser;
import com.hit.entities.AppUserRole;

@Controller
@RequestMapping("/role")
public class SecurityController {
	
	@Autowired
	AppRoleDao dao;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	AppUserDao appUserDao;
	
	@Autowired
	AppUserRoleDao appUserRoleDao;
	
	@GetMapping("/newRole")
	public String getAppRolePage(Model model) {
		
		AppRole appRole = new AppRole();
		
		model.addAttribute("appRole", appRole);
		
		return "security/appRole";
	}
	
	@PostMapping("/save")
	public String saveAppRole(AppRole appRole) {
		
		System.out.println("SecurityController.saveAppRole()");
		
		dao.save(appRole);
		
		return "redirect:/role/newRole";
	}
	
	@GetMapping("/newUser")
	public String getAppUserDetails(Model model)
	{
		AppUser appUser = new AppUser();
		
		model.addAttribute("appUser", appUser);
		
		return "security/appUser";
	}
	
	@PostMapping("/saveUser")
	public String saveAppUser(AppUser appUser) {
		
		appUser.setPassword(encoder.encode(appUser.getPassword()));
		
		appUserDao.save(appUser);
		
		return "redirect:/role/newUser";
	}
	
	@GetMapping("/userRole")
	public String getAppUserRoleDetails(Model model) {
		
		List<AppRole> roleList = dao.findAll();
		
		List<AppUser> userList = appUserDao.findAll();
		
		model.addAttribute("roleList", roleList);
		
		model.addAttribute("userList", userList);
		
		AppUserRole userRole = new AppUserRole();
		
		model.addAttribute("userRole", userRole);
		
		return "/security/userRole";
		
	}
	
	@PostMapping("/saveUserRole")
	public String saveAppUserRole(AppUserRole userRole) {
		
		appUserRoleDao.save(userRole);
		
		return "redirect:/role/userRole";
	}

}
