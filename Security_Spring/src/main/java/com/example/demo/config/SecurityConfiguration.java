package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/others/**").hasRole("NORMAL")
		.antMatchers("/users/**","/others/***").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("EgERohit").password(this.passwordEncoder().encode("abcd")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("deepu").password(this.passwordEncoder().encode("efgh")).roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
	//	return NoOpPasswordEncoder.getInstance();    (this is for passing password as plain text)
		return new BCryptPasswordEncoder(10);      //(this is for decrypting the password.
	}
	
	

}
