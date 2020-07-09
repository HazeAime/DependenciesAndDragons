/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author bkb
 */
@Entity
public class DndCharacter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer characterId;
    
    @ManyToOne
    @JoinColumn(name = "campaignId")
    DndCampaign campaign;
    
    @Column(nullable = false)
    String characterName;
    
    @Column(nullable = false)
    String playerName;
    
    @ManyToOne
    @JoinColumn(name = "alignmentId")
    Alignment alignment;
    
    @Column(nullable = false)
    Integer xp;
    
    @Column(nullable = false)
    Integer characterLvl;
    
    @ManyToOne
    @JoinColumn(name = "classId")
    CharacterClass characterClass;
    
    @Column(nullable = false)
    Integer strength;
    
    @Column(nullable = false)
    Integer dexterity;
    
    @Column(nullable = false)
    Integer constitution;
    
    @Column(nullable = false)
    Integer intelligence;
    
    @Column(nullable = false)
    Integer wisdom;
    
    @Column(nullable = false)
    Integer stStrength;
    
    @Column(nullable = false)
    Integer stDexterity;
    
    @Column(nullable = false)
    Integer stConstitution;
    
    @Column(nullable = false)
    Integer stIntelligence;
    
    @Column(nullable = false)
    Integer stWisdom;
    
    @Column(nullable = false)
    Integer stCharisma;
    
    @Column(nullable = false)
    Integer charisma;
    
    @Column(nullable = false)
    Integer money;
    
    @Column(nullable = false)
    String backstory;
    
    @Column(nullable = false)
    Integer hitDice;
    
    @Column(nullable = false)
    Integer armorClass;
    
    @ManyToOne
    @JoinColumn(name = "raceId")
    Race characterRace;
    
    @ManyToMany
    @JoinTable(name = "character_skill", 
            joinColumns = {@JoinColumn(name = "characterId")},
            inverseJoinColumns = {@JoinColumn(name = "skillId")})
    List<Skill> allSkills;
    
    @ManyToMany
    @JoinTable(name = "character_item", 
            joinColumns = {@JoinColumn(name = "characterId")},
            inverseJoinColumns = {@JoinColumn(name = "itemId")})
    List<Item> allItems;
    
    @ManyToMany
    @JoinTable(name = "character_attackOrSpell", 
            joinColumns = {@JoinColumn(name = "characterId")},
            inverseJoinColumns = {@JoinColumn(name = "attackOrSpellId")})
    List<AttackOrSpell> allAttackOrSpells;
    
    
}


                