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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author bkb
 */
@Entity
public class DndCampaign {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer campaignId;

    @Column(nullable = false)
    private String map;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User dmAffiliated;
}
