/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author jweez
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsService udService;
    
    @Override
    protected void configure(HttpSecurity sec) throws Exception {
        sec.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/css/**", "/js/**", "/fonts/**").permitAll()
                .anyRequest().access("hasRole('ROLE_DM') or hasRole('ROLE_PLAYER')")
                .and().formLogin().loginPage("/login")
                    .failureUrl("/login?login_error=1").permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll();
    }
    
    @Autowired
    public void configureGlobalInDB(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(udService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
