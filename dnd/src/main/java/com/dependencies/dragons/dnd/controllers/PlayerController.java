/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.controllers;

import com.dependencies.dragons.dnd.daos.DndCharacterDao;
import com.dependencies.dragons.dnd.entities.Alignment;
import com.dependencies.dragons.dnd.entities.CharacterClass;
import com.dependencies.dragons.dnd.entities.DndCampaign;
import com.dependencies.dragons.dnd.entities.DndCharacter;
import com.dependencies.dragons.dnd.entities.Race;
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
public class PlayerController {
    
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
    DndCharacterDao charDao;
    
    @GetMapping("createcharacter")
    public String createCharacter(Model model) {
        model.addAttribute("campaigns", campaign.findAll());
        model.addAttribute("alignments", align.findAll());
        model.addAttribute("classes", charClass.findAll());
        model.addAttribute("races", race.findAll());
        model.addAttribute("skills", skill.findAll());
        model.addAttribute("items", item.findAll());
        model.addAttribute("attacksSpells", attkOrSpl.findAll());
        return "createcharacter";
    }
    
    @PostMapping("createcharacter")
    public String createCharacter(HttpServletRequest request, DndCharacter toAdd) {
        Integer classId = Integer.parseInt(request.getParameter("classId"));
        CharacterClass cClass = charClass.findById(classId).orElse(null);
        Integer alignmentId = Integer.parseInt(request.getParameter("alignmentId"));
        Alignment cAlign = align.findById(alignmentId).orElse(null);
        Integer raceId = Integer.parseInt(request.getParameter("raceId"));
        Race cRace = race.findById(raceId).orElse(null);
        Integer campaignId = Integer.parseInt(request.getParameter("campaignId"));
        DndCampaign cCamp = campaign.findById(campaignId).orElse(null);
        toAdd.setCharacterClass(cClass);
        toAdd.setAlignment(cAlign);
        toAdd.setCharacterRace(cRace);
        toAdd.setCampaign(cCamp);
        Integer newId = charDao.getNewId(toAdd);
        toAdd.setId(newId);
        dndChar.save(toAdd);
        return "redirect:/characters";
    }
    
    @GetMapping("characters")
    public String displayAllCharacters(Model model) {
        List<DndCharacter> allCharacters = dndChar.findAll();
        List<DndCharacter> approvedList = new ArrayList<>();
        for (int i = 0; i < allCharacters.size(); i++) {
            if (allCharacters.get(i).isApproval() == true) {
                approvedList.add(allCharacters.get(i));
            }
        }
        model.addAttribute("characters", approvedList);
        return "characters";
    }
    
    @GetMapping("updatecharacter/{id}")
    public String updateCharacter(Model model, @PathVariable Integer id) {
        model.addAttribute("character", dndChar.findById(id).orElse(null));
        model.addAttribute("campaigns", campaign.findAll());
        model.addAttribute("alignments", align.findAll());
        model.addAttribute("classes", charClass.findAll());
        model.addAttribute("races", race.findAll());
        model.addAttribute("skills", skill.findAll());
        model.addAttribute("items", item.findAll());
        model.addAttribute("attacksSpells", attkOrSpl.findAll());
        return "updatecharacter";
    }
    
    @PostMapping("updatecharacter")
    public String updateCharacter(DndCharacter toEdit) {
        dndChar.save(toEdit);
        return "redirect:/characters";
    }
    
    @GetMapping("characterdetails/{id}")
    public String displayCharacterDetails(Model model, @PathVariable Integer id){
        DndCharacter char2 = dndChar.findById(id).orElse(null);
        model.addAttribute("character", char2);
        return "characterdetails";
    }
    
}
