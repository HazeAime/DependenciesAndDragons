/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.entities;

import java.util.List;

/**
 *
 * @author bkb
 */
public class DndCampaign {
    Integer campaignId;
    List<DndCharacter> characterList;
    String map;
    String description;
    User dmAffiliated;
}
