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
    private static final Date fecha1=new Date(2015,04,13);
    private static final Date fecha2=new Date(2015,06,10);
    private static final Date fecha3=new Date(2015,07,12);
    static{
        
        dummyBluePrints.put("Grupo1",new Grupo("grupo1",new Tarea[]{new Tarea("Tarea ARSW","Descripcion Tarea ARSW 1",fecha1),new Tarea("Tarea ARSW Lab+","Descripcion Tarea ARSW lAB 11 ",fecha1)}));
        dummyBluePrints.put("Grupo2",new Grupo("grupo2",new Tarea[]{new Tarea("Tarea LANS","Descripcion Tarea LANS 2",fecha2),new Tarea("Tarea LANS Lab+","Descripcion Tarea Lans Lab 21",fecha2)}));
        dummyBluePrints.put("Grupo3", new Grupo("grupo3",new Tarea[]{new Tarea("Tarea PGR1","Descripcion tarea Pgr 3",fecha3),new Tarea("TAREA PGR1+","Descripcion Tarea pgr1++ 31",fecha3)}));
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
