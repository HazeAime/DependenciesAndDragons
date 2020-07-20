/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.daos;

import com.dependencies.dragons.dnd.entities.DndCharacter;
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
 * @author jweez
 */
@Component
public class DndCharacterDaoDB implements DndCharacterDao {

    @Autowired
    JdbcTemplate template;

    @Override
    @Transactional
    public Integer getNewId(DndCharacter toAdd) {
        Integer newId = template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return newId;
    }

    @Override
    public List<DndCharacter> findCharactersByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class CharacterMapper implements RowMapper<DndCharacter> {

        @Override
        public DndCharacter mapRow(ResultSet rs, int index) throws SQLException {
            DndCharacter dc = new DndCharacter();
            dc.setId(rs.getInt("id"));
            dc.setApproval(rs.getBoolean("approval"));
            dc.setCharacterName(rs.getString("characterName"));
            dc.setPlayerName(rs.getString("playerName"));
            dc.setXp(rs.getInt("xp"));
            dc.setCharacterLvl(rs.getInt("characterLvl"));
            dc.setStrength(rs.getInt("strength"));
            dc.setDexterity(rs.getInt("dexterity"));
            dc.setConstitution(rs.getInt("constitution"));
            dc.setIntelligence(rs.getInt("intelligence"));
            dc.setWisdom(rs.getInt("wisdom"));
            dc.setCharisma(rs.getInt("charisma"));
            dc.setStStrength(rs.getInt("stStrength"));
            dc.setStDexterity(rs.getInt("stDexterity"));
            dc.setStConstitution(rs.getInt("stConstitution"));
            dc.setStIntelligence(rs.getInt("stIntelligence"));
            dc.setStWisdom(rs.getInt("stWisdom"));
            dc.setStCharisma(rs.getInt("stCharisma"));
            dc.setMoney(rs.getInt("money"));
            dc.setBackstory(rs.getString("backstory"));
            dc.setHitDice(rs.getString("hitDice"));
            dc.setArmorClass(rs.getInt("armorClass"));    
            return dc;
        }

    }
    
}
