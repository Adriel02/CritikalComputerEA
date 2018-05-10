/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cuenta;


import Singletons.Log;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import operaciones.UsuariosFacade;

/**
 *
 * @author Adriel
 */
public class Registro extends Controller.controller{

    UsuariosFacade usuariosFacade = lookupUsuariosFacadeBean();

    Stateful.Carrito carrito = lookupCarritoBean();


    Log log = lookupLogBean();

    @Override
    public void process() {
        HttpSession session= request.getSession(true);
        usuario.setNombre(request.getParameter("usuario"));
        usuario.setContraseña(request.getParameter("pass"));
        session.setAttribute("Usuario", usuario);
        session.setAttribute("Carrito", carrito);
        try {
            redirect("/CritikalComputerEA-war/Tienda.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
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

    private Usuario lookupUsuarioBean() {
        try {
            Context c = new InitialContext();
            return (Usuario) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Usuario!Stateful.Usuario");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Stateful.Carrito lookupCarritoBean() {
        try {
            Context c = new InitialContext();
            return (Stateful.Carrito) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Carrito!Stateful.Carrito");
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
    
}
