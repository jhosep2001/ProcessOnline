/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processonline.project.acceso;

import com.processonline.project.dominio.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author jhosepgranda
 */
public class AccesoUsuario {
    
    public HibernateUtil hibernate;

    public AccesoUsuario() {
    }
    
    public void crearUsuario(Usuario user){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(user); //<|--- Aqui guardamos el objeto en la base de datos.
        session.getTransaction().commit();
    }
    
    public Usuario buscarUsuarioId(Integer id){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Usuario user = (Usuario) session.get(Usuario.class, id); //<|--- Aqui guardamos el objeto en la base de datos.
        session.getTransaction().commit();
        return  user;
    }
    
    public void actualizarUsuario(Usuario user){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("UPDATE Usuario SET Activo = "+user.getActivo()+"', Fecha_nacimiento = '"+user.getFecha_nacimiento()+"'"
                + ", dependencia ='"+user.getDependencia().toString()+"' WHERE id= '"+user.getId()+""); //AL ser id autoincrementable es necesario un query
        query.executeUpdate();
        session.getTransaction().commit();
  
    }
    
    public void borrarUsuario(Usuario user){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.delete(user); //<|--- Aqui guardamos el objeto en la base de datos.

        session.getTransaction().commit();
      
    }

    public List<Usuario> todos() {
       Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT u FROM Usuario u");
        List<Usuario> listado = query.list();
        session.getTransaction().commit();
        return listado;
    }
    
    
    
}
