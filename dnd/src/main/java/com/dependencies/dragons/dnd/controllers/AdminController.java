/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.controllers;

import com.dependencies.dragons.dnd.entities.DndCampaign;
import com.dependencies.dragons.dnd.entities.DndCharacter;
import com.dependencies.dragons.dnd.repositories.DndCampaignRepository;
import com.dependencies.dragons.dnd.repositories.RoleRepository;
import com.dependencies.dragons.dnd.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author codedchai
 */
@Controller
public class AdminController {

    @Autowired
    UserRepository user;

    @Autowired
    DndCampaignRepository campaign;

    @GetMapping("/admin")
    public String displayAdminScreen() {
        return "admin";
    }

    @GetMapping("/users")
    public String displayUsers(Model model) {
        model.addAttribute("users", user.findAll());
        return "users";
    }

    @GetMapping("approvecampaign")
    public String displayCharacterApproval(Model model) {
        model.addAttribute("campaigns", campaign.findAll());
        return "approvecharacter";
    }

    @PostMapping("approvecampaign")
    public String updateApproval(List<DndCampaign> campaigns) {
        campaign.saveAll(campaigns);
        return "redirect:/approvecharacter";
    }

}
