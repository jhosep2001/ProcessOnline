/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processonline.project.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 *
 * @author jhosepgranda
 */
@Embeddable
public class Tarea implements Serializable{
    
    @Column(name="idTarea")
    public Integer id;
    
    @Column(name="Nombre")
    public String nombre;

    public Tarea() {
    }

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
