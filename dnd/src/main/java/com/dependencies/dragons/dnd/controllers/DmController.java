/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.controllers;

import com.dependencies.dragons.dnd.daos.dndCampaignDao;
import com.dependencies.dragons.dnd.entities.DndCampaign;
import com.dependencies.dragons.dnd.entities.DndCharacter;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author codedchai
 */
@Controller
public class DmController {
    
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
    
    @Autowired
    dndCampaignDao campDao;
    
    @GetMapping("createcampaign")
    public String createCampaign(Model model) {
        model.addAttribute("users", user.findAll());
        return "createcampaign";
    }
    
    @PostMapping("createcampaign")
    public String createCampaign(DndCampaign toAdd, HttpServletRequest request) {
        String dmId = request.getParameter("dmId");
        toAdd.setDmAffiliated(user.findById(Integer.parseInt(dmId)).orElse(null));
        Integer newId = campDao.getNewId(toAdd);
        toAdd.setId(newId);
        campaign.save(toAdd);
        return "redirect:/campaigns";
    }
    
    @GetMapping("campaigns")
    public String displayAllCampaigns(Model model) {  
        List<DndCampaign> allCampaigns = campaign.findAll();
        List<DndCampaign> approvedList = new ArrayList<>();
        for (int i=0; i<allCampaigns.size(); i++) {
            if (allCampaigns.get(i).isApproval()== true) {
                approvedList.add(allCampaigns.get(i));
            }
        }
        model.addAttribute("campaigns", approvedList);
        return "campaigns";
    }
    
    @GetMapping("updatecampaign/{id}")
    public String updateCampaign(Model model, @PathVariable Integer id) {
        DndCampaign camp = campaign.findById(id).orElse(null);
        model.addAttribute("campaign", camp);
        model.addAttribute("users", user.findAll());
        
        return "updatecampaign";
    }
    
    @PostMapping("updatecampaign")
    public String updateCampaign(DndCampaign toEdit) {
        campaign.save(toEdit);
        return "redirect:/campaigns";
    }
    
    @GetMapping("campaigndetails/{id}")
    public String displayCampaignDetails(Model model, @PathVariable Integer id){
        DndCampaign camp = campaign.findById(id).orElse(null);
        model.addAttribute("campaign", camp);
        return "campaigndetails";
    }
    
//    @GetMapping("campaign/characters")
//    public String viewCharacters(Model model) {
//        model.addAttribute("campaign", campaign)
//        return "";
//    }
//    
    @GetMapping("approvecharacter")
    public String displayCharacterApproval(Model model) {
        List<DndCharacter> allChars = dndChar.findAll();
        List<DndCharacter> toPassIn = new ArrayList<>();
        for (DndCharacter dndCharacter: allChars) {
            if (!dndCharacter.isApproval()) {
                toPassIn.add(dndCharacter);
            }
        }
        model.addAttribute("characters", toPassIn);
        return "approvecharacter";
    }
    
    //cannot hit method
    @PostMapping("approvecharacter")
    public String updateApproval(Integer[] charIds){
        for (Integer id: charIds) {
            DndCharacter dndCharacter = dndChar.findById(id).orElse(null);
            dndCharacter.setApproval(true);
            dndChar.save(dndCharacter);
        }
        return "redirect:/approvecharacter";
    }
    
}
