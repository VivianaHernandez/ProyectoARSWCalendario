/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controllers;


import edu.eci.arsw.samples.model.Grupo;
import edu.eci.arsw.services.ServicesFacade;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    
    @Autowired
    ServicesFacade services;
    
    
    @RequestMapping(value="/check",method = RequestMethod.GET)        
    public String check() {
        return "REST API OK";        
    }
    
    @RequestMapping(method = RequestMethod.POST)        
    public ResponseEntity<?> addGrupo(@RequestBody Grupo p) {       
        services.addNewGrupo(p.getName(),p);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    
    @RequestMapping(method = RequestMethod.GET)
    public Set<String> allBlueprintNames() {       
        return services.getGrupoNames();
    }
    
    @RequestMapping(value = "/{gruponame}",method = RequestMethod.GET)        
    public Grupo getABlueprint(@PathVariable("gruponame") String gruponame) {       
        return services.getGrupoByName(gruponame);
    } 
    
    @RequestMapping(value = "/{gruponame}",method = RequestMethod.POST)        
    public Grupo getAGrupo(@PathVariable("gruponame") String gruponame) {       
        return services.getGrupoByName(gruponame);
    } 
}

