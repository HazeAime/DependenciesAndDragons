/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.service;

import com.dependencies.dragons.dnd.dao.UserDao;
import com.dependencies.dragons.dnd.entities.Role;
//import com.dependencies.dragons.dnd.entities.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jweez
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao uDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.dependencies.dragons.dnd.entities.User toGet = uDao.getUserByName(username);
        Set<GrantedAuthority> fakeroles = new HashSet<>();
        
        for(Role toConvert: toGet.getRoles()) {
            fakeroles.add(new SimpleGrantedAuthority(toConvert.getRole()));
        }
        
        return new User(username, toGet.getPassword(), fakeroles);
    }
    
}
