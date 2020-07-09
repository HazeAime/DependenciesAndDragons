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

    public DndCampaign createCampaign();

    public DndCampaign getCampaignById(int id);

    public List<DndCampaign> getAllCampaigns();

    public void updateCampaign(DndCampaign toEdit);

    public void deleteCampaign(DndCampaign toRemove);

}
