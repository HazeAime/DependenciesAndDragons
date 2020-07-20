/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.repositories;

import com.dependencies.dragons.dnd.entities.DndCampaign;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author codedchai
 */
@Repository
public interface DndCampaignRepository extends JpaRepository<DndCampaign, Integer> {
//    
//    @Query(value = "select c from DndCampaign c join User on c.userId = User.id "
//            + "where User.username = ?1", nativeQuery = true)
//    List<Object[]> findByUserName(String username);
//    
}
