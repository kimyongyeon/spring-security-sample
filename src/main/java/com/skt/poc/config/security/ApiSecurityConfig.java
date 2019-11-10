package com.skt.poc.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Web Security for REST API.
 * 
 * @author P151542
 *
 */
@Configuration
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * For Authentication with httpBasic,
	 * Set Global auth information.
	 * 
	 * TODO 향후 필요에 따라 변경 - 현재 ID/Pwd 하드 코딩.
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        
		auth
		.inMemoryAuthentication()
			.withUser("apiuser")
				.password(passwordEncoder().encode("apiuser"))
				.authorities("ROLE_USER")
				.and()
        	.withUser("apiadmin")
        		.password(passwordEncoder().encode("apiadmin"))
        		.authorities("ROLE_ADMIN")
		;
		
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Authorization with Roles
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		
    	log.debug("▶ ApiSecurityConfig configure.");
    	
    	//TODO 향후 상황에 맞게 권한 설정
    	
    	http
    	/** see http://docs.spring.io/spring-security/site/docs/4.1.0.RELEASE/reference/htmlsingle/#when-to-use-csrf-protection */
    	.csrf()
    		.disable()
    	.antMatcher("/api/**")
    	.authorizeRequests()
//    		.antMatchers("/api/code/**").permitAll()					//[Example] For Test.
    		.antMatchers("/api/auth/**").hasAuthority("ROLE_ADMIN")		//[Example] REST API Role 정의 필요
            .anyRequest().authenticated() 
            .and()
        .httpBasic();
        ;

    }

}