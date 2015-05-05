/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.realtimeapp.services;

import edu.eci.arsw.realtimeapp.model.Grupo;
import edu.eci.arsw.realtimeapp.model.Tarea;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class ServicesFacade {
    private static final Map<String,Grupo> grupos=new LinkedHashMap<>();
    
    static{
        grupos.put("grupo1", new Grupo("grupo1",new Tarea[]{new Tarea("t1","de1",null),new Tarea("t11","de11",null)}));
        grupos.put("grupo2", new Grupo("grupo2",new Tarea[]{new Tarea("t2","de2",null),new Tarea("t21","de21",null)}));
        grupos.put("grupo3", new Grupo("grupo3",new Tarea[]{new Tarea("t3","de3",null),new Tarea("t31","de31",null)}));
    }
    
    public void addNewGrupo(String name,Grupo bp){
        grupos.put(name,bp);
    }
    
    public Set<String> getGrupoNames(){
        return grupos.keySet();
    }
    
    public Grupo getBlueprintByName(String name){
        return grupos.get(name);
    }
    
}
