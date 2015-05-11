
package edu.eci.arsw.samples.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Grupo {

    private List<Tarea> tareas=null;
    
    String name=null;
    
    public Grupo(String name,Tarea[] tar){
        this.name=name;
        tareas=Arrays.asList(tar);
    }
          
    public Grupo(String name){
        this.name=name;
        tareas=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Tarea> getTarea() {
        return tareas;
    }
    
    public void addTarea(Tarea p){
        this.tareas.add(p);
    }
    
}
