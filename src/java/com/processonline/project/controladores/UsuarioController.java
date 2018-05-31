package com.processonline.project.controladores;


import com.processonline.project.acceso.AccesoUsuario;
import com.processonline.project.dominio.Dependencia;
import com.processonline.project.dominio.Perfil;
import com.processonline.project.dominio.Usuario;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhosepgranda
 */
@Controller
@Configuration
@ComponentScan("com.processonline.project.acceso")
public class UsuarioController {
    
    public AccesoUsuario usuarioDAO;
    
    @RequestMapping(value="usuario.htm",method=RequestMethod.GET)
    public ModelAndView usuario() { 
       ModelAndView mv = new ModelAndView("usuario","command", new Usuario());
       mv.addObject("dependencias",Dependencia.values());
       mv.addObject("perfiles",Perfil.values());
       mv.addObject("accion","crear");
       return mv;
   }
   
   @RequestMapping(value="newUser.htm",method = RequestMethod.POST)
    public ModelAndView crearUsuario(HttpServletRequest request, HttpServletResponse response){
        
        Usuario user = new Usuario();
        user.setId(parseInt(request.getParameter("id")));
        
        if (request.getParameter("activo").equals("True")){
            user.setActivo(Boolean.TRUE);
        }else {
            user.setActivo(Boolean.FALSE);
        }
        String[] vector = request.getParameter("fecha_nacimiento").split("-");
        int año = parseInt(vector[0]);
        int mes = parseInt(vector[1]);
        int dia = parseInt(vector[2]);

        try{
            user.setFecha_nacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_nacimiento")));
        }catch(Exception e){
            user.setFecha_nacimiento(new Date(año,mes,dia));
        }
        
        Dependencia[] v = Dependencia.values();
        for (int i=0;i<v.length;i++){
            if(v[i].toString().equals(request.getParameter("dependencia"))){
                user.setDependencia(v[i]);
            }
        }
        
        usuarioDAO = new AccesoUsuario();
        usuarioDAO.crearUsuario(user);
        
        return new ModelAndView("index");
    }
    
    @RequestMapping(value="actualizar.htm",method = RequestMethod.POST)
    public ModelAndView actualizar(HttpServletRequest request, HttpServletResponse response){ 
         Usuario user = new Usuario();
        user.setId(parseInt(request.getParameter("id")));
        
        if (request.getParameter("activo").equals("True")){
            user.setActivo(Boolean.TRUE);
        }else {
            user.setActivo(Boolean.FALSE);
        }
        String[] vector = request.getParameter("fecha_nacimiento").split("-");
        int año = parseInt(vector[0]);
        int mes = parseInt(vector[1]);
        int dia = parseInt(vector[2]);
        user.setFecha_nacimiento(new Date(año,mes,dia));
        
        Dependencia[] v = Dependencia.values();
        for (int i=0;i<v.length;i++){
            if(v[i].toString().equals(request.getParameter("dependencia"))){
                user.setDependencia(v[i]);
            }
        }
        
        usuarioDAO = new AccesoUsuario();
        usuarioDAO.actualizarUsuario(user);
        return new ModelAndView("index");
    }       
            
    @RequestMapping(value="actualizar.htm")
    public ModelAndView actualizarUsuario(HttpServletRequest request, HttpServletResponse response){
        usuarioDAO = new AccesoUsuario();
        Usuario user = usuarioDAO.buscarUsuarioId(parseInt(request.getParameter("id")));
        
        ModelAndView mv = new ModelAndView("usuario","command", user);
        mv.addObject("dependencias",Dependencia.values());
        mv.addObject("perfiles",Perfil.values());
        mv.addObject("accion","actualizar");
        return mv;
    }
    
    @RequestMapping(value="borrar.htm")
    public ModelAndView borrarUsuario(HttpServletRequest request, HttpServletResponse response){
        usuarioDAO = new AccesoUsuario();
        Usuario user = usuarioDAO.buscarUsuarioId(parseInt(request.getParameter("id")));
        usuarioDAO.borrarUsuario(user);
        return new ModelAndView("index");
    }
}
