/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processonline.project.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhosepgranda
 */
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{
    
    @Id
    @Column(name="Id")
    @NotNull
    public Integer id;
    
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name="Fecha_nacimiento")
    public Date fecha_nacimiento;
    
    @Column(name="Activo")
    public boolean activo;
    
    @Enumerated(EnumType.STRING)
    public Dependencia dependencia;
 /*   
    @Column(name="Perfil")
    public Perfil[] perfil;
    
    @NotBlank
    @Column(name="nombre")
    public List<Fila> filas;
*/
    public Usuario() {
    }

    public Usuario(Integer id,Date fecha_nacimiento, Boolean activo, Dependencia dependencia) {
        this.id=id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.activo = activo;
        this.dependencia = dependencia;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
}
