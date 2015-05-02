/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.realtimeapp.model;

import java.util.ArrayList;

public class Calendario {

  private ArrayList<Tarea> tareas;

   public Calendario(Tarea tarea) {
     
      adicionarTarea(tarea);
    }
    
   public void adicionarTarea(Tarea tarea)
   {
     tareas.add(tarea);
   }
   
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }
    
     
    
    
}
