/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.daos;

import com.dependencies.dragons.dnd.daos.UserDaoDB.UserMapper;
import com.dependencies.dragons.dnd.entities.DndCampaign;
import com.dependencies.dragons.dnd.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author bkb
 */
@Component
public class DndCampaignDaoDB implements DndCampaignDao {

    @Autowired
    JdbcTemplate template;

    @Override
    @Transactional
    public Integer getNewId(DndCampaign toAdd) {
        Integer newId = template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return newId;
    }

    @Override
    public void editCampaign(DndCampaign toEdit) {
        final String editCamp = "UPDATE DndCampaign SET description=?, approval=?,"
                + "userId=?, map=? WHERE id=?";
        template.update(editCamp,
                toEdit.getDescription(),
                toEdit.isApproval(),
                toEdit.getUser().getId(),
                toEdit.getMap(),
                toEdit.getId());
    }

    @Override
    public List<DndCampaign> findCampaignsByUsername(String username) {
        final String SELECT_CAMPAIGNS_BY_USERNAME = "SELECT c.* FROM DndCampaign "
                + "c JOIN User ON c.userId = User.id WHERE User.username = ?";
        List<DndCampaign> toReturn = template.query(SELECT_CAMPAIGNS_BY_USERNAME, 
                new CampaignMapper(), username);
        associateUser(toReturn);
        return toReturn;
    }

    private void associateUser(List<DndCampaign> campaigns) {
        for (DndCampaign campaign: campaigns) {
            campaign.setUser(getUserForCampaign(campaign.getId()));
        }
    }

    private User getUserForCampaign(Integer campaignId) {
        final String SELECT_CAMPAIGN_FOR_USER = "SELECT User.* FROM DndCampaign c JOIN "
                + "User ON User.id = c.userId WHERE c.id = ?";
        return template.queryForObject(SELECT_CAMPAIGN_FOR_USER, new UserMapper(), campaignId);
    }

    public static final class CampaignMapper implements RowMapper<DndCampaign> {

        @Override
        public DndCampaign mapRow(ResultSet rs, int index) throws SQLException {
            DndCampaign dc = new DndCampaign();
            dc.setId(rs.getInt("id"));
            dc.setApproval(rs.getBoolean("approval"));
            dc.setMap(rs.getString("map"));
            dc.setDescription(rs.getString("description"));
            return dc;
        }

    }
}
