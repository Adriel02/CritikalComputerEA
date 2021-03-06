/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cuenta;

import Singletons.Estadisticas;
import Singletons.Log;
import Stateful.Carrito;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpSession;
import models.Usuarios;
import operaciones.UsuariosFacade;

/**
 *
 * @author Adriel
 */
public class login extends Controller.controller {

    Carrito carrito = lookupCarritoBean();

    UsuariosFacade usuariosFacade = lookupUsuariosFacadeBean();

    Log log = lookupLogBean();

    Estadisticas estadisticas = lookupEstadisticasBean();

    @Override
    public void process() {
        HttpSession session = request.getSession();
        Usuarios usuario = new Usuarios();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setContraseña(request.getParameter("pass"));
        usuario.setTipo(request.getParameter("tipo"));
        session.setAttribute("Usuario", usuario);
        session.setAttribute("Carrito", carrito);
        Estadisticas.incrementarLogin();
        try {
            redirect("/CritikalComputerEA-war/principalAdministrador.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
        }
    }

    private Estadisticas lookupEstadisticasBean() {
        try {
            Context c = new InitialContext();
            return (Estadisticas) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Estadisticas!Singletons.Estadisticas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            Log.guardarExcepcion(ne.getMessage()); //Guardar en mi log
            throw new RuntimeException(ne);
        }
    }

    private Log lookupLogBean() {
        try {
            Context c = new InitialContext();
            return (Log) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Log!Singletons.Log");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuariosFacade lookupUsuariosFacadeBean() {
        try {
            Context c = new InitialContext();
            return (UsuariosFacade) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/UsuariosFacade!operaciones.UsuariosFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Carrito lookupCarritoBean() {
        try {
            Context c = new InitialContext();
            return (Carrito) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Carrito!Stateful.Carrito");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
