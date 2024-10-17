package com.baz83.webapp.saluti_web_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController 
@RequestMapping("/test") 
public class SalutiCheckAPI { 
    @GetMapping()                 
    public String testGetTstAPI(){ 
        return "Verifica Web Api Saluti OK"; 
    } 
} 
