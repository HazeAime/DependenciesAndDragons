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
    
    public DndCharacter createCharacter();
    
    public DndCharacter getCharacterById(int id);
    
    public List<DndCharacter> getAllCharacters();
    
    public void updateCharacter(DndCharacter toEdit);
    
    public void deleteCharacter(DndCharacter toRemove);

    public Integer getNewId(DndCharacter toAdd);
    
}
