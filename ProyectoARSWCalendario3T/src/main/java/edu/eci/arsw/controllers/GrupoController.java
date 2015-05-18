/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controllers;


import edu.eci.arsw.samples.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    
    @Autowired
    
    ManejadorGrupos mg;
    
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<String> consords() {
        return mg.getGrupos();
    }
    
    @RequestMapping(value="/{numgrupo}",method = RequestMethod.GET)
    public Grupo consord(@PathVariable int numgrupo) throws ExcepcionManejadorGrupos {
        Grupo g=null;
        System.out.println("q");
        
        try{
            g=mg.consultarGrupo(numgrupo+"");
        }catch(ExcepcionManejadorGrupos e){
        }
        return g;
    }
    
    @RequestMapping(value="/{numgrupo}",method = RequestMethod.POST)
    public ResponseEntity<?> persist(@PathVariable int numgrupo,@RequestBody Tarea tarea ) throws ExcepcionManejadorGrupos {
       System.out.println("ENTRO A ESTE METODO POOOOOOOOOOOST"+tarea.getDescripcion()+"grupoooo:"+numgrupo);
        mg.agregarGrupoTareas(numgrupo+"",tarea);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> persist(@RequestBody Grupo g) {    
        mg.registrarGrupo(g);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

