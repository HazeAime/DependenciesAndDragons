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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author bkb
 */
@Entity
public class DndCampaign {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.approval ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.map);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.dmAffiliated);
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
        final DndCampaign other = (DndCampaign) obj;
        if (this.approval != other.approval) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dmAffiliated, other.dmAffiliated)) {
            return false;
        }
        return true;
    }

    @Column(nullable=false)
    private boolean approval;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String map;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User dmAffiliated;


    
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
     * @return the map
     */
    public String getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(String map) {
        this.map = map;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the dmAffiliated
     */
    public User getDmAffiliated() {
        return dmAffiliated;
    }

    /**
     * @param dmAffiliated the dmAffiliated to set
     */
    public void setDmAffiliated(User dmAffiliated) {
        this.dmAffiliated = dmAffiliated;
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
}
