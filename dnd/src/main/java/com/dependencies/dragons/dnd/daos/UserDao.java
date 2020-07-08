/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.daos;

import com.dependencies.dragons.dnd.entities.User;
import java.util.List;

/**
 *
 * @author codedchai
 */
public interface UserDao {
    
    public User getUserById(int id);
    
    public User getUserByName(String userName);
    
    public List<User> getAllUsers();
    
    public void updateUser(User user);
    
    public void deleteUserById(int id);
    
    public User createUser(User user);
    
}
