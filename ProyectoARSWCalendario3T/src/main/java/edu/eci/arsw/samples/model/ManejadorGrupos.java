/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.samples.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author torresmy
 */
public class ManejadorGrupos {
    //List<Grupo> grupos;
    Map<String,Grupo> grupos=new LinkedHashMap<>();
    	public ManejadorGrupos(){
		cargarGrupos(this);
	}
        
        private static void cargarGrupos(ManejadorGrupos mg){
		Grupo g=new Grupo();
                Date fecha1=new Date(2015,04,13);
                Date fecha2=new Date(2015,06,10);
                Date fecha3=new Date(2015,07,12);
		g.addTarea(new Tarea("Tarea ARSW","Descripcion Tarea ARSW 1",fecha1));
		g.addTarea(new Tarea("Tarea ARSW Lab+","Descripcion Tarea ARSW lAB 11 ",fecha1));
		
		mg.registrarGrupo(g);
		
		g=new Grupo();
		g.addTarea(new Tarea("Tarea LANS","Descripcion Tarea LANS 2",fecha2));
		g.addTarea(new Tarea("Tarea LANS Lab+","Descripcion Tarea Lans Lab 21",fecha2));
                mg.registrarGrupo(g);
                g=new Grupo();
		g.addTarea(new Tarea("Tarea PGR1","Descripcion tarea Pgr 3",fecha3));
		g.addTarea(new Tarea("TAREA PGR1+","Descripcion Tarea pgr1++ 31",fecha3));
		
		mg.registrarGrupo(g);
	}
        
        public void registrarGrupo(Grupo g){
		grupos.put(grupos.size()+"",g);
	}
        

        public ArrayList<String> getGrupos() {
            ArrayList<String> arr=new ArrayList<String>();
            String key = null ;
            Iterator it = grupos.keySet().iterator();
            while(it.hasNext()){
              key = (String)it.next();
            arr.add(key);
              System.out.println("Clave: " + key + " -> Valor: " + grupos.get(key));
            }   
            return arr;
        }
        
        public Grupo consultarGrupo(String n) throws ExcepcionManejadorGrupos{
		//if (n>=grupos.size()) throw new ExcepcionManejadorGrupos("grupo inexistente:");
		return grupos.get(n);
	}
        
    public List<Tarea> consultarGrupoTareas(String n) throws ExcepcionManejadorGrupos{
        return grupos.get(n).getTarea();
    }

    public void agregarGrupoTareas(String n, Tarea tarea) {
        System.out.println("tareaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa: "+tarea.getNombre());
        grupos.get(n).addTarea(tarea);
    }

}