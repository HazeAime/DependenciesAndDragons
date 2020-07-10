/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.controllers;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    
}
