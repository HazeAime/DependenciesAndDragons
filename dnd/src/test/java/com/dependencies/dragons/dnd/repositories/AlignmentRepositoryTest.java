/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.repositories;

import com.dependencies.dragons.dnd.entities.Alignment;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author bkb
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AlignmentRepositoryTest {

    @Autowired
    AlignmentRepository align;

    @Autowired
    AttackOrSpellRepository attkOrSpl;

    @Autowired
    CharacterClassRepository charClass;

    @Autowired
    DndCampaignRepository campaign;

    @Autowired
    DndCharacterRepository dndChar;

    @Autowired
    ItemRepository item;

    @Autowired
    RaceRepository race;

    @Autowired
    RoleRepository role;

    @Autowired
    SkillRepository skill;

    @Autowired
    UserRepository user;

    @Autowired
    JdbcTemplate template;

    public AlignmentRepositoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        dndChar.deleteAll();
        campaign.deleteAll();
        user.deleteAll();
        role.deleteAll();
        charClass.deleteAll();
        item.deleteAll();
        skill.deleteAll();
        attkOrSpl.deleteAll();
        race.deleteAll();
        
        align.deleteAll();
        
        
        

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetAllAlignGoldenPath() {

        Alignment toTest = new Alignment();
        toTest.setName("Lawful Evil");

        align.save(toTest);

        List<Alignment> allAlignments = align.findAll();

        assertEquals("Lawful Evil", allAlignments.get(0).getName());
        assertEquals(1, allAlignments.size());

    }

}
