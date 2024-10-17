package com.baz83.webapp.saluti_web_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController 
@RequestMapping("/api/saluti") 
public class SalutiController { 
    @GetMapping()                 // case 1 
    //@GetMapping("/test")        // case 2 
    public String GetSaluti(){ 
        return "Ciao Mondo, sono il primo web servlet"; 
    } 

    @GetMapping(value = "/{nome}") 
    public String GetSaluti2(@PathVariable("nome") String nome){ 
        return String.format("Ciao %s, sono il primo web servlet", nome); 
    }

} 
