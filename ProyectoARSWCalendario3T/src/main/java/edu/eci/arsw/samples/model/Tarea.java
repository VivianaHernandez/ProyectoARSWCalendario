/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.arsw.samples.model;

import java.util.Date;

/**
 *
 * @author hcadavid
 */
public class Tarea {
    
    private String nombre;
    private String descripcion;
    private Date fecha;
    private int dia;

     public Tarea(String nombre,String descripcion, Date fecha) {
        this.nombre = nombre;
        this.descripcion =descripcion;
        this.fecha=fecha;
        this.dia=fecha.getDate();
    }

    public Tarea(String grupo1, Tarea[] tarea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public int getDia()
    {
    return fecha.getDate();
    }
    
     public int getMonth()
    {
    return fecha.getMonth();
    }
     
      public int getYear()
    {
    return fecha.getYear();
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }    
}
