/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.service;

import com.dependencies.dragons.dnd.daos.UserDao;
import com.dependencies.dragons.dnd.entities.Role;
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
 * @author codedchai
 */
@Service
public class UserDetalsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao uDao;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.dependencies.dragons.dnd.entities.User toConvert = uDao.getUserByName(userName);
        Set<GrantedAuthority> fakeRoles = new HashSet<>();
        for (Role role: toConvert.getRoles()) {
            fakeRoles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(userName, toConvert.getPassword(), fakeRoles);
    }
    
}
