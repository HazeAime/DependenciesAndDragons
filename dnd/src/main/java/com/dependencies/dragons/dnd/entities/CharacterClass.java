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
public class CharacterClass {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer classId;
    
    private String className;
    private String hitDie;
    private String primaryAbility;
    private String saves;

}
