package com.skt.poc.config.security;

import com.skt.poc.common.service.security.SsoUserService;
import com.skt.poc.common.utils.security.SsoAuthenticationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;

/**
 * Web Security for Web Browser.
 * 
 * @author P151542
 *
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SsoUserService userService;
    
    @Autowired
    private Environment environment;
    
    /**
     * Authentication using SSO
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
    	
    	AuthenticationProvider authenticationProvider = getAuthenticationProvider(userService);
    	auth.authenticationProvider(authenticationProvider);
    	
    }
    
    @Bean
    public SsoAuthenticationProvider getAuthenticationProvider(SsoUserService userService) {
    	
    	SsoAuthenticationProvider authenticationProvider = new SsoAuthenticationProvider();
    	authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
        
    }

    /**
     * Authorization with Roles
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		
    	log.info("▶ BrowserSecurityConfig configure");
    	
    	disableSecurityForLocalH2Console(http);
    	
    	http
    	.antMatcher("/**")
    	.authorizeRequests()
    		.antMatchers("/").permitAll()
    		.antMatchers("/login").permitAll()
    		.antMatchers("/admin/**").hasAuthority("ADMIN")
            .anyRequest().authenticated() 
            .and()
        .formLogin()
        	.loginPage("/login").permitAll()
        	.defaultSuccessUrl("/home", true)
        	.failureUrl("/login?error=true")
        	.usernameParameter("loginId")
            .passwordParameter("password")
        	.and()
    	.logout()
    		.logoutUrl("/logout")
    		.logoutSuccessUrl("/login")
    		.invalidateHttpSession(true)
//    		.deleteCookies("JSESSIONID")
        ;

    }

    /**
     * Ignore static resources.
     */
    @Override
    public void configure(WebSecurity web) {
		
    	log.info("▶ configure(WebSecurity web)");
    	
    	web
    	.ignoring() 
			.antMatchers("/css/**", "/js/**", "/img/**");
		 
    }
    
    /**
     * Local용 H2 DB web console에 대한, Security 설정 해제
     * @param http
     * @throws Exception
     */
    private void disableSecurityForLocalH2Console(HttpSecurity http) throws Exception {
        if (isLocalProfile()) {
          log.warn("Disable security to allow H2 console");
          String url = "/h2-console/**";
          http.csrf().ignoringAntMatchers(url);
          http.authorizeRequests().antMatchers(url).permitAll();
          http.headers().frameOptions().disable();
        }
      }

    /**
     * Spring Profile이 로컬(local)인지 Check.
     * @return
     */
      private boolean isLocalProfile() {
    	  boolean isLocal = Arrays.asList(environment.getActiveProfiles()).contains("local");
    	  log.debug("▶ isLocal : {}", isLocal);
    	  return isLocal;
      }
    
}