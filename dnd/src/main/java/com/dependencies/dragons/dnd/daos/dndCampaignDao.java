/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.daos;

import java.util.List;

/**
 *
 * @author siessejordan
 */
public interface dndCampaignDao {
    
    public dndCampaign createCampaign();
    
    public dndCampaign getCampaignById(int id);
    
    public List<dndCampaign> getAllCampaigns();
    
    public void updateCampaign(dndCampaign toEdit);
    
    public void deleteCampaign(dndCampaign toRemove);
    
}
