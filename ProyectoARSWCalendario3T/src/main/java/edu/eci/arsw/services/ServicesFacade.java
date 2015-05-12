/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.services;

import edu.eci.arsw.samples.model.Grupo;
import edu.eci.arsw.samples.model.Tarea;
import java.util.Date;
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
    private static final Date fecha=new Date();
    static{
        fecha.setDate(2);fecha.setMonth(2);fecha.setYear(2);
        dummyBluePrints.put("Grupo1",new Grupo("grupo1",new Tarea[]{new Tarea("t1","de1",fecha),new Tarea("t11","de11",fecha)}));
        fecha.setDate(3);fecha.setMonth(3);fecha.setYear(3);
        dummyBluePrints.put("Grupo2",new Grupo("grupo2",new Tarea[]{new Tarea("t2","de2",fecha),new Tarea("t21","de21",fecha)}));
        fecha.setDate(4);fecha.setMonth(4);fecha.setYear(4);
        dummyBluePrints.put("Grupo3", new Grupo("grupo3",new Tarea[]{new Tarea("t3","de3",fecha),new Tarea("t31","de31",fecha)}));
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
