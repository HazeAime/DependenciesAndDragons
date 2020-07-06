/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.dao;

import com.dependencies.dragons.dnd.entities.Role;
import java.util.List;

/**
 *
 * @author jweez
 */
public interface RoleDao {
    
    public Role getRoleById(int id);
    
    public Role getRoleByName(String role);
    
    public List<Role> getAllRoles();
    
    public void updateRole(Role toUpdate);
    
    public void deleteRole(int id);
    
    public Role createRole(Role toAdd);
}
