/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.controllers;

import com.dependencies.dragons.dnd.repositories.RoleRepository;
import com.dependencies.dragons.dnd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author codedchai
 */
@Controller
public class AdminController {
    
    @Autowired
    UserRepository user;
 
    @GetMapping("/admin")
    public String displayAdminScreen() {
        return "admin";
    }
    
    @GetMapping("/users")
    public String displayUsers(Model model) {
        model.addAttribute("users", user.findAll());
        return "users";
    }
    
}
