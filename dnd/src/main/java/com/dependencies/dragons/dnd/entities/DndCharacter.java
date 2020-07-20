/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.entities;

import java.util.List;
import java.util.Objects;
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

    @Column(nullable = false)
    private boolean approval;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "campaignId")
    private DndCampaign campaign;
    
    @Column(nullable = false)
    private String characterName;
    
    @Column(nullable = false)
    private String playerName;
    
    @ManyToOne
    @JoinColumn(name = "alignmentId")
    private Alignment alignment;
    
    @Column(nullable = false)
    private Integer xp;
    
    @Column(nullable = false)
    private Integer characterLvl;
    
    @ManyToOne
    @JoinColumn(name = "classId")
    private CharacterClass characterClass;
    
    @Column(nullable = false)
    private Integer strength;
    
    @Column(nullable = false)
    private Integer dexterity;
    
    @Column(nullable = false)
    private Integer constitution;
    
    @Column(nullable = false)
    private Integer intelligence;
    
    @Column(nullable = false)
    private Integer wisdom;
    
    @Column(nullable = false)
    private Integer stStrength;
    
    @Column(nullable = false)
    private Integer stDexterity;
    
    @Column(nullable = false)
    private Integer stConstitution;
    
    @Column(nullable = false)
    private Integer stIntelligence;
    
    @Column(nullable = false)
    private Integer stWisdom;
    
    @Column(nullable = false)
    private Integer stCharisma;
    
    @Column(nullable = false)
    private Integer charisma;
    
    @Column(nullable = false)
    private Integer money;
    
    @Column(nullable = false)
    private String backstory;
    
    @Column(nullable = false)
    private String hitDice;
    
    @Column(nullable = false)
    private Integer armorClass;
    
    @ManyToOne
    @JoinColumn(name = "raceId")
    private Race characterRace;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.approval ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.campaign);
        hash = 83 * hash + Objects.hashCode(this.characterName);
        hash = 83 * hash + Objects.hashCode(this.playerName);
        hash = 83 * hash + Objects.hashCode(this.alignment);
        hash = 83 * hash + Objects.hashCode(this.xp);
        hash = 83 * hash + Objects.hashCode(this.characterLvl);
        hash = 83 * hash + Objects.hashCode(this.characterClass);
        hash = 83 * hash + Objects.hashCode(this.strength);
        hash = 83 * hash + Objects.hashCode(this.dexterity);
        hash = 83 * hash + Objects.hashCode(this.constitution);
        hash = 83 * hash + Objects.hashCode(this.intelligence);
        hash = 83 * hash + Objects.hashCode(this.wisdom);
        hash = 83 * hash + Objects.hashCode(this.stStrength);
        hash = 83 * hash + Objects.hashCode(this.stDexterity);
        hash = 83 * hash + Objects.hashCode(this.stConstitution);
        hash = 83 * hash + Objects.hashCode(this.stIntelligence);
        hash = 83 * hash + Objects.hashCode(this.stWisdom);
        hash = 83 * hash + Objects.hashCode(this.stCharisma);
        hash = 83 * hash + Objects.hashCode(this.charisma);
        hash = 83 * hash + Objects.hashCode(this.money);
        hash = 83 * hash + Objects.hashCode(this.backstory);
        hash = 83 * hash + Objects.hashCode(this.hitDice);
        hash = 83 * hash + Objects.hashCode(this.armorClass);
        hash = 83 * hash + Objects.hashCode(this.characterRace);
        hash = 83 * hash + Objects.hashCode(this.user);
        hash = 83 * hash + Objects.hashCode(this.allSkills);
        hash = 83 * hash + Objects.hashCode(this.allItems);
        hash = 83 * hash + Objects.hashCode(this.allAttackOrSpells);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DndCharacter other = (DndCharacter) obj;
        if (this.approval != other.approval) {
            return false;
        }
        if (!Objects.equals(this.characterName, other.characterName)) {
            return false;
        }
        if (!Objects.equals(this.playerName, other.playerName)) {
            return false;
        }
        if (!Objects.equals(this.backstory, other.backstory)) {
            return false;
        }
        if (!Objects.equals(this.hitDice, other.hitDice)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.campaign, other.campaign)) {
            return false;
        }
        if (!Objects.equals(this.alignment, other.alignment)) {
            return false;
        }
        if (!Objects.equals(this.xp, other.xp)) {
            return false;
        }
        if (!Objects.equals(this.characterLvl, other.characterLvl)) {
            return false;
        }
        if (!Objects.equals(this.characterClass, other.characterClass)) {
            return false;
        }
        if (!Objects.equals(this.strength, other.strength)) {
            return false;
        }
        if (!Objects.equals(this.dexterity, other.dexterity)) {
            return false;
        }
        if (!Objects.equals(this.constitution, other.constitution)) {
            return false;
        }
        if (!Objects.equals(this.intelligence, other.intelligence)) {
            return false;
        }
        if (!Objects.equals(this.wisdom, other.wisdom)) {
            return false;
        }
        if (!Objects.equals(this.stStrength, other.stStrength)) {
            return false;
        }
        if (!Objects.equals(this.stDexterity, other.stDexterity)) {
            return false;
        }
        if (!Objects.equals(this.stConstitution, other.stConstitution)) {
            return false;
        }
        if (!Objects.equals(this.stIntelligence, other.stIntelligence)) {
            return false;
        }
        if (!Objects.equals(this.stWisdom, other.stWisdom)) {
            return false;
        }
        if (!Objects.equals(this.stCharisma, other.stCharisma)) {
            return false;
        }
        if (!Objects.equals(this.charisma, other.charisma)) {
            return false;
        }
        if (!Objects.equals(this.money, other.money)) {
            return false;
        }
        if (!Objects.equals(this.armorClass, other.armorClass)) {
            return false;
        }
        if (!Objects.equals(this.characterRace, other.characterRace)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.allSkills, other.allSkills)) {
            return false;
        }
        if (!Objects.equals(this.allItems, other.allItems)) {
            return false;
        }
        if (!Objects.equals(this.allAttackOrSpells, other.allAttackOrSpells)) {
            return false;
        }
        return true;
    }
    
    @ManyToMany
    @JoinTable(name = "Character_Skill", 
            joinColumns = {@JoinColumn(name = "characterId")},
            inverseJoinColumns = {@JoinColumn(name = "skillId")})
    private List<Skill> allSkills;
    
    @ManyToMany
    @JoinTable(name = "Character_Item", 
            joinColumns = {@JoinColumn(name = "characterId")},
            inverseJoinColumns = {@JoinColumn(name = "itemId")})
    private List<Item> allItems;
    
    @ManyToMany
    @JoinTable(name = "Character_AttackOrSpell", 
            joinColumns = {@JoinColumn(name = "characterId")},
            inverseJoinColumns = {@JoinColumn(name = "attackOrSpellId")})
    private List<AttackOrSpell> allAttackOrSpells;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the campaign
     */
    public DndCampaign getCampaign() {
        return campaign;
    }

    /**
     * @param campaign the campaign to set
     */
    public void setCampaign(DndCampaign campaign) {
        this.campaign = campaign;
    }

    /**
     * @return the characterName
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * @param characterName the characterName to set
     */
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the alignment
     */
    public Alignment getAlignment() {
        return alignment;
    }

    /**
     * @param alignment the alignment to set
     */
    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    /**
     * @return the xp
     */
    public Integer getXp() {
        return xp;
    }

    /**
     * @param xp the xp to set
     */
    public void setXp(Integer xp) {
        this.xp = xp;
    }

    /**
     * @return the characterLvl
     */
    public Integer getCharacterLvl() {
        return characterLvl;
    }

    /**
     * @param characterLvl the characterLvl to set
     */
    public void setCharacterLvl(Integer characterLvl) {
        this.characterLvl = characterLvl;
    }

    /**
     * @return the characterClass
     */
    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    /**
     * @param characterClass the characterClass to set
     */
    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    /**
     * @return the strength
     */
    public Integer getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    /**
     * @return the dexterity
     */
    public Integer getDexterity() {
        return dexterity;
    }

    /**
     * @param dexterity the dexterity to set
     */
    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * @return the constitution
     */
    public Integer getConstitution() {
        return constitution;
    }

    /**
     * @param constitution the constitution to set
     */
    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    /**
     * @return the intelligence
     */
    public Integer getIntelligence() {
        return intelligence;
    }

    /**
     * @param intelligence the intelligence to set
     */
    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * @return the wisdom
     */
    public Integer getWisdom() {
        return wisdom;
    }

    /**
     * @param wisdom the wisdom to set
     */
    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * @return the stStrength
     */
    public Integer getStStrength() {
        return stStrength;
    }

    /**
     * @param stStrength the stStrength to set
     */
    public void setStStrength(Integer stStrength) {
        this.stStrength = stStrength;
    }

    /**
     * @return the stDexterity
     */
    public Integer getStDexterity() {
        return stDexterity;
    }

    /**
     * @param stDexterity the stDexterity to set
     */
    public void setStDexterity(Integer stDexterity) {
        this.stDexterity = stDexterity;
    }

    /**
     * @return the stConstitution
     */
    public Integer getStConstitution() {
        return stConstitution;
    }

    /**
     * @param stConstitution the stConstitution to set
     */
    public void setStConstitution(Integer stConstitution) {
        this.stConstitution = stConstitution;
    }

    /**
     * @return the stIntelligence
     */
    public Integer getStIntelligence() {
        return stIntelligence;
    }

    /**
     * @param stIntelligence the stIntelligence to set
     */
    public void setStIntelligence(Integer stIntelligence) {
        this.stIntelligence = stIntelligence;
    }

    /**
     * @return the stWisdom
     */
    public Integer getStWisdom() {
        return stWisdom;
    }

    /**
     * @param stWisdom the stWisdom to set
     */
    public void setStWisdom(Integer stWisdom) {
        this.stWisdom = stWisdom;
    }

    /**
     * @return the stCharisma
     */
    public Integer getStCharisma() {
        return stCharisma;
    }

    /**
     * @param stCharisma the stCharisma to set
     */
    public void setStCharisma(Integer stCharisma) {
        this.stCharisma = stCharisma;
    }

    /**
     * @return the charisma
     */
    public Integer getCharisma() {
        return charisma;
    }

    /**
     * @param charisma the charisma to set
     */
    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    /**
     * @return the money
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * @return the backstory
     */
    public String getBackstory() {
        return backstory;
    }

    /**
     * @param backstory the backstory to set
     */
    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    /**
     * @return the hitDice
     */
    public String getHitDice() {
        return hitDice;
    }

    /**
     * @param hitDice the hitDice to set
     */
    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    /**
     * @return the armorClass
     */
    public Integer getArmorClass() {
        return armorClass;
    }

    /**
     * @param armorClass the armorClass to set
     */
    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    /**
     * @return the characterRace
     */
    public Race getCharacterRace() {
        return characterRace;
    }

    /**
     * @param characterRace the characterRace to set
     */
    public void setCharacterRace(Race characterRace) {
        this.characterRace = characterRace;
    }

    /**
     * @return the allSkills
     */
    public List<Skill> getAllSkills() {
        return allSkills;
    }

    /**
     * @param allSkills the allSkills to set
     */
    public void setAllSkills(List<Skill> allSkills) {
        this.allSkills = allSkills;
    }

    /**
     * @return the allItems
     */
    public List<Item> getAllItems() {
        return allItems;
    }

    /**
     * @param allItems the allItems to set
     */
    public void setAllItems(List<Item> allItems) {
        this.allItems = allItems;
    }

    /**
     * @return the allAttackOrSpells
     */
    public List<AttackOrSpell> getAllAttackOrSpells() {
        return allAttackOrSpells;
    }

    /**
     * @param allAttackOrSpells the allAttackOrSpells to set
     */
    public void setAllAttackOrSpells(List<AttackOrSpell> allAttackOrSpells) {
        this.allAttackOrSpells = allAttackOrSpells;
    }

    /**
     * @return the approval
     */
    public boolean isApproval() {
        return approval;
    }

    /**
     * @param approval the approval to set
     */
    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
}


                