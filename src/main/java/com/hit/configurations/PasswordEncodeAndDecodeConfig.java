package com.hit.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncodeAndDecodeConfig {
	
	@Bean
	public BCryptPasswordEncoder getPassordEncoder() {
		BCryptPasswordEncoder pass=new BCryptPasswordEncoder();
		
		return pass;
	}

}
