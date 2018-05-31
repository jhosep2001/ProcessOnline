/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processonline.project.controladores;

import com.processonline.project.acceso.AccesoUsuario;
import com.processonline.project.dominio.Dependencia;
import com.processonline.project.dominio.Perfil;
import com.processonline.project.dominio.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author jhosepgranda
 */
@Controller
@org.springframework.context.annotation.Configuration
@ComponentScan("com.processonline.project.acceso")
public class PrincipalController {
    
    @Autowired
    public AccesoUsuario usuarioDAO;
    
    @RequestMapping(value="index.htm",method=RequestMethod.GET)
    public ModelAndView Index(){
        
        Map<String, Object> model = new HashMap<String, Object>();
        String name = "index";
        usuarioDAO = new AccesoUsuario();
        try{
            List<Usuario> usuarios=usuarioDAO.todos();
            model.put("usuarios",usuarios);
        }catch (Exception e){
            System.out.println("Exception with DAO "+e.getMessage());
        }
        ModelAndView mv = new ModelAndView(name,model);
        return  mv;
    }
   
}
