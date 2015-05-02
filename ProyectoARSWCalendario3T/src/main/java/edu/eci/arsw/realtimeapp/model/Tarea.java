/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.realtimeapp.model;

import java.util.Date;

/**
 *
 * @author hcadavid
 */
public class Tarea {
    
    private String grupo;
    private String nombre;
    private String descripcion;
    private Date fecha;

     public Tarea(String nombre,String descripcion, Date fecha) {
        this.nombre = nombre;
        this.descripcion =descripcion;
        this.fecha=fecha;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

   

    
}
