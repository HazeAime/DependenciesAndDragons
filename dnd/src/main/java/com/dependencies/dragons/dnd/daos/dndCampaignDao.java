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
public interface dndCampaignDao {
    
<<<<<<< HEAD:dnd/src/main/java/com/dependencies/dragons/dnd/daos/CampaignDao.java
    public DndCampaign createCampaign();
    
    public DndCampaign getCampaignById(int id);
    
    public List<DndCampaign> getAllCampaigns();
    
    public void updateCampaign(DndCampaign toEdit);
    
    public void deleteCampaign(DndCampaign toRemove);
=======
    public dndCampaign createCampaign();
    
    public dndCampaign getCampaignById(int id);
    
    public List<dndCampaign> getAllCampaigns();
    
    public void updateCampaign(dndCampaign toEdit);
    
    public void deleteCampaign(dndCampaign toRemove);
>>>>>>> 6ce7674cc6580a0613745af7b67b49bc6e7e45a9:dnd/src/main/java/com/dependencies/dragons/dnd/daos/dndCampaignDao.java
    
}
