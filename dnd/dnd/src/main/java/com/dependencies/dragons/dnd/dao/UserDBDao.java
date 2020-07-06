/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.dao;

import com.dependencies.dragons.dnd.entities.Role;
import com.dependencies.dragons.dnd.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author jweez
 */
@Component
public class UserDBDao implements UserDao {

    @Autowired
    JdbcTemplate template;
    
    @Override
    public User getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByName(String userName) {
        try {
            User toGet = template.queryForObject("select * from user where username = ?", new UserMapper(), userName);
            Set<Role> userRoles = getRolesByUserId();
            toGet.setRoles(userRoles);
            
            return toGet;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(User toUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User createUser(User toAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Set<Role> getRolesByUserId() {
        return new HashSet<>(template.query("select * from role inner join user_role on role.id = user_role.roleid", new RoleMapper()));
    }

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User toReturn = new User();
            toReturn.setId(rs.getInt("id"));
            toReturn.setUserName(rs.getString("userName"));
            toReturn.setPassword(rs.getString("password"));
            toReturn.setEnabled(rs.getBoolean("enabled"));
            return toReturn;
        }

       
    }

    private static class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int i) throws SQLException {
            Role toReturn = new Role();
            toReturn.setId(rs.getInt("id"));
            toReturn.setRole("role");
            return toReturn;
        }

        
    }
    
}
