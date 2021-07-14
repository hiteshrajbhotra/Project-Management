package com.hit.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	DataSource ds;

//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("hitesh").password(encoder.encode("admin")).roles("user").and().withUser("sysadmin")
//				.password("admin").roles("user");
//	}
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}


	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.usersByUsernameQuery("select user_name,password,enabled from app_user where user_name =  ?")
				.authoritiesByUsernameQuery("select au.user_name,ar.role_name from app_user au "
						+ "inner join app_user_role aur "
						+ "on(au.user_id = aur.user_id) "
						+ "inner join app_role ar on "
						+ "(ar.role_id = aur.role_id) "
						+ "where au.user_name = ?")
				.dataSource(ds)
				.passwordEncoder(encoder);
	}
	
	
	  @Override public void configure(HttpSecurity http) throws Exception {
	  
	  http.authorizeRequests() 
	  .antMatchers("/","/**").hasRole("Admin")
	  .antMatchers("/project/new").hasRole("Admin") 
	  .antMatchers("/employee/new").hasRole("Admin") 
	  .antMatchers("/role/newRole").hasRole("Admin") 
	  .antMatchers("/role/userRole").hasRole("Admin")
	  .and()
      .formLogin().permitAll();
	  }	
}
