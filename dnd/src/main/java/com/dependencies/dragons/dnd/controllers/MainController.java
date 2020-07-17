/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.controllers;

import com.dependencies.dragons.dnd.entities.Role;
import com.dependencies.dragons.dnd.entities.User;
import com.dependencies.dragons.dnd.entities.UserVM;
import com.dependencies.dragons.dnd.repositories.AlignmentRepository;
import com.dependencies.dragons.dnd.repositories.AttackOrSpellRepository;
import com.dependencies.dragons.dnd.repositories.CharacterClassRepository;
import com.dependencies.dragons.dnd.repositories.DndCampaignRepository;
import com.dependencies.dragons.dnd.repositories.DndCharacterRepository;
import com.dependencies.dragons.dnd.repositories.ItemRepository;
import com.dependencies.dragons.dnd.repositories.RaceRepository;
import com.dependencies.dragons.dnd.repositories.RoleRepository;
import com.dependencies.dragons.dnd.repositories.SkillRepository;
import com.dependencies.dragons.dnd.repositories.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author codedchai
 */
@Controller
public class MainController {
    
    @Autowired
    AlignmentRepository align;
    
    @Autowired 
    AttackOrSpellRepository attkOrSpl;
    
    @Autowired
    CharacterClassRepository charClass;
    
    @Autowired
    DndCampaignRepository campaign;
    
    @Autowired
    DndCharacterRepository dndChar;
    
    @Autowired
    ItemRepository item;
    
    @Autowired
    RaceRepository race;
    
    @Autowired
    RoleRepository role;
    
    @Autowired
    SkillRepository skill;
    
    @Autowired
    UserRepository user;
    
    @GetMapping("/")
    public String displayHomepage() {   
        return "home";
    }
    
    @GetMapping("createnewuser")
    public String createNewUser(Model model) {
        List<Role> allRoles = role.findAll();
        model.addAttribute("roles", allRoles.stream().filter(r -> !r.getRole().equals("ROLE_ADMIN")).collect(Collectors.toList()));
        return "createnewuser";
    }
    
    @PostMapping("createnewuser")
    public String createNewUser(UserVM vm) {
        // TODO: Validate UserVM has valid data
        User toAdd = new User(vm);
        user.save(toAdd);
        return "redirect:/login";
    }
    
}
