
package edu.eci.arsw.samples.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Grupo {

    private List<Tarea> tareas=null;
    
    

    public Grupo(){
        tareas=new ArrayList<>();
    }
    

    public List<Tarea> getTarea() {
        return tareas;
    }
    
    public void addTarea(Tarea p){
        this.tareas.add(p);
    }
    
}
