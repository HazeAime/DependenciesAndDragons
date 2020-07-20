/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.daos;

import com.dependencies.dragons.dnd.entities.DndCampaign;
import java.util.List;

/**
 *
 * @author siessejordan
 */
public interface DndCampaignDao {

    public Integer getNewId(DndCampaign toAdd);
    
    public void editCampaign(DndCampaign toEdit);
    
    public List<DndCampaign> findCampaignsByUsername(String username);
}
