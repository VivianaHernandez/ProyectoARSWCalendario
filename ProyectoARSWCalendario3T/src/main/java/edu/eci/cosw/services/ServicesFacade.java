/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.services;

import edu.eci.cosw.samples.model.Blueprint;
import edu.eci.cosw.samples.model.Grupo;
import edu.eci.cosw.samples.model.Point;
import edu.eci.cosw.samples.model.Tarea;
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
   
    private static final Map<String,Grupo> dummyBluePrints=new LinkedHashMap<>();
    
    static{
        dummyBluePrints.put("Grupo1",new Grupo("grupo1",new Tarea[]{new Tarea("t1","de1",null),new Tarea("t11","de1",null)}));
        dummyBluePrints.put("Grupo2",new Grupo("grupo2",new Tarea[]{new Tarea("t2","de1",null),new Tarea("t21","de1",null)}));
        dummyBluePrints.put("grupo3", new Grupo("grupo3",new Tarea[]{new Tarea("t3","de3",null),new Tarea("t31","de31",null)}));
    }
    
    public void addNewGrupo(String name,Grupo bp){
        dummyBluePrints.put(name,bp);
    }
    
    public Set<String> getGrupoNames(){
        return dummyBluePrints.keySet();
    }
    
    public Grupo getGrupoByName(String name){
        return dummyBluePrints.get(name);
    }
    
}
