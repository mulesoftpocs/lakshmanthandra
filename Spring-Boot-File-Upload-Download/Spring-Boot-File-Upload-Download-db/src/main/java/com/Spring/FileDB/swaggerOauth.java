package com.Spring.FileDB;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spring.web.plugins.Docket;


	@Configuration
	@EnableWebSecurity
	@ComponentScan
	public class swaggerOauth extends WebSecurityConfigurerAdapter {

	       private static final String[] AUTH_LIST = { 

	                        "/swagger-ui.html", 

	        };

	        @Override
	        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	                auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("lucky12")).roles("USER").and().withUser("admin")
	                                .password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");
	        }

	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	                http.authorizeRequests().antMatchers(AUTH_LIST).authenticated().and().httpBasic();
	        }

	        @Bean
	        public PasswordEncoder passwordEncoder() {
	                return new BCryptPasswordEncoder();
	        }
		
	}

