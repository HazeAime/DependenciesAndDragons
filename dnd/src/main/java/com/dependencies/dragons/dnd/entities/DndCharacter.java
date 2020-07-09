/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bkb
 */
@Entity
public class DndCharacter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer characterId;
    
    DndCampaign campaign;
    
    String characterName;
    String playerName;
    String alignment;
    Integer xp;
    Integer characterLvl;
    Integer classId;
    Integer strength;
    Integer dexterity;
    Integer constitution;
    Integer intelligence;
    Integer wisdom;
    Integer stStrength;
    Integer stDexterity;
    Integer stConstitution;
    Integer stIntelligence;
    Integer stWisdom;
    Integer stCharisma;
    Integer charisma;
    Integer money;
    String backstory;
    Integer hitDice;
    Integer armorClass;
    
}
