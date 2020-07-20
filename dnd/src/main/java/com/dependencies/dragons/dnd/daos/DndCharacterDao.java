/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.daos;

import com.dependencies.dragons.dnd.entities.DndCharacter;
import java.util.List;

/**
 *
 * @author siessejordan
 */
public interface DndCharacterDao {

    public Integer getNewId(DndCharacter toAdd);
    
    public List<DndCharacter> findCharactersByUsername(String username);
    
}
