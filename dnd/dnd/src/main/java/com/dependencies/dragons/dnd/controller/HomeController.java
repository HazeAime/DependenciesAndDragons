/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dependencies.dragons.dnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jweez
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String displayHomepage() {
        return "homepage";
    }
}
