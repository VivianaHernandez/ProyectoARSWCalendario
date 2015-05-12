
package edu.eci.arsw.samples.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Grupo {

    private List<Tarea> tareas=null;
    
    String nombre=null;
    
    public Grupo(String nombre,Tarea[] tar){
        this.nombre=nombre;
        tareas=Arrays.asList(tar);
    }
          
    public Grupo(String nombre){
        this.nombre=nombre;
        tareas=new ArrayList<>();
    }

    public String getName() {
        return nombre;
    }

    public List<Tarea> getTarea() {
        return tareas;
    }
    
    public void addTarea(Tarea p){
        this.tareas.add(p);
    }
    
}
