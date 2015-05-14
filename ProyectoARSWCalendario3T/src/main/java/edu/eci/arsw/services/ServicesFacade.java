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

@Service
public class ServicesFacade {
   
    private static final Map<String,Grupo> dummyBluePrints=new LinkedHashMap<>();
    private static final Date fecha=new Date();
    static{
        fecha.setDate(2);fecha.setMonth(7);fecha.setYear(2015);
        dummyBluePrints.put("Grupo1",new Grupo("grupo1",new Tarea[]{new Tarea("Tarea ARSW","Descripcion 1",fecha),new Tarea("Tarea ARSW+","Descripcion 11",fecha)}));
        fecha.setDate(3);fecha.setMonth(5);fecha.setYear(2015);
        dummyBluePrints.put("Grupo2",new Grupo("grupo2",new Tarea[]{new Tarea("Tarea LANS","Descripcion 2",fecha),new Tarea("Tarea LANS+","Descripcion 21",fecha)}));
        fecha.setDate(8);fecha.setMonth(12);fecha.setYear(2015);
        dummyBluePrints.put("Grupo3", new Grupo("grupo3",new Tarea[]{new Tarea("Tarea PGR1","Descripcion 3",fecha),new Tarea("TAREA PGR1+","Descripcion 31",fecha)}));
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
