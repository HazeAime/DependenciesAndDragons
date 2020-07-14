/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bkb
 */
@Entity
public class CharacterClass {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String hitDie;

    @Column(nullable = false)
    private String primaryAbility;

    @Column(nullable = false)
    private String saves;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.hitDie);
        hash = 67 * hash + Objects.hashCode(this.primaryAbility);
        hash = 67 * hash + Objects.hashCode(this.saves);
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
        final CharacterClass other = (CharacterClass) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.hitDie, other.hitDie)) {
            return false;
        }
        if (!Objects.equals(this.primaryAbility, other.primaryAbility)) {
            return false;
        }
        if (!Objects.equals(this.saves, other.saves)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the hitDie
     */
    public String getHitDie() {
        return hitDie;
    }

    /**
     * @param hitDie the hitDie to set
     */
    public void setHitDie(String hitDie) {
        this.hitDie = hitDie;
    }

    /**
     * @return the primaryAbility
     */
    public String getPrimaryAbility() {
        return primaryAbility;
    }

    /**
     * @param primaryAbility the primaryAbility to set
     */
    public void setPrimaryAbility(String primaryAbility) {
        this.primaryAbility = primaryAbility;
    }

    /**
     * @return the saves
     */
    public String getSaves() {
        return saves;
    }

    /**
     * @param saves the saves to set
     */
    public void setSaves(String saves) {
        this.saves = saves;
    }

}
