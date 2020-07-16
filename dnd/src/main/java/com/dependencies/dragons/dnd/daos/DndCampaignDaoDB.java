/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.daos;

import com.dependencies.dragons.dnd.entities.DndCampaign;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author bkb
 */
@Component
public class DndCampaignDaoDB implements dndCampaignDao {

    @Autowired
    JdbcTemplate template;

    @Transactional
    public Integer getNewId(DndCampaign toAdd) {

        Integer newId = template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return newId;

    }
}
