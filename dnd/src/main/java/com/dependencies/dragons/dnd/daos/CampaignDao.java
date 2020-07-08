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
public interface CampaignDao {
    
    public Campaign createCampaign();
    
    public Campaign getCampaignById(int id);
    
    public List<Campaign> getAllCampaigns();
    
    public void updateCampaign(Campaign toEdit);
    
    public void deleteCampaign(Campaign toRemove);
    
}
