/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processonline.project.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jhosepgranda
 */
@Entity
@Table(name="Fila")
public class Fila implements Serializable{
    
    @Id
    @Column(name="IdFila")
    public Integer idFila;
    
    @Column(name="Duracion")
    public Integer duracion;
    
    @Embedded
    public Tarea tarea;
    
    public Fila() {
    }

    public Fila(Integer duracion, Tarea tarea) {
        this.duracion = duracion;
        this.tarea = tarea;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
}