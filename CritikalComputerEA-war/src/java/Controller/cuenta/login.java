/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cuenta;

import Singletons.Estadisticas;
import Singletons.Log;
import Stateful.Compra;
import Stateful.Usuario;
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

/**
 *
 * @author Adriel
 */
public class login extends Controller.controller {

    Log log = lookupLogBean();

    Estadisticas estadisticas = lookupEstadisticasBean();

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        Compra compra = lookupCompraBean();
        Stateful.Carrito carrito = lookupCarritoBean();
        Usuario usuario = lookupUsuarioBean();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setContraseña(request.getParameter("pass"));
        session.setAttribute("Usuario", usuario);
        session.setAttribute("Carrito", carrito);
        session.setAttribute("Compra", compra);
        Estadisticas.incrementarLogin();
        System.out.println(request.getParameter("tipo"));
        try {
            if (userIsValid()) {
                if(request.getParameter("tipo").equals("Administrador")){
                updateSession();
                redirect("/CritikalComputerEA-war/principalAdministrador.jsp");
                }
                if(request.getParameter("tipo").equals("Cliente")){
                updateSession();
                redirect("/CritikalComputerEA-war/Tienda.jsp");
                }  
            }else{
                redirect("/CritikalComputerEA-war/index.jsp");
            }
        } catch (ServletException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean userIsValid() throws SQLException {
        try {
            ResultSet resultSet = connectAndQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
        }

        return false;
    }
    public void updateSession() {
        HttpSession session = request.getSession(true);
        Usuario usuario = lookupUsuarioBean();
        Compra compra = lookupCompraBean();
        Stateful.Carrito carrito = lookupCarritoBean();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setContraseña(request.getParameter("pass"));
        session.setAttribute("Usuario", usuario);
        session.setAttribute("Carrito", carrito);
        session.setAttribute("Compra", compra);
        Estadisticas.incrementarLogin();
    }
    
    public ResultSet connectAndQuery() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ASBaseDatos", "adriel", "adriel");
        String query = "select * from USUARIOS where NOMBRE = ? AND CONTRASEÑA = ? AND TIPO = ? ";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, request.getParameter("nombre"));
        statement.setString(2, request.getParameter("pass"));
        statement.setString(3, request.getParameter("tipo"));
        System.out.println(query);
        return statement.executeQuery();
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

    private Compra lookupCompraBean() {
        try {
            Context c = new InitialContext();
            return (Compra) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Compra!Stateful.Compra");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
