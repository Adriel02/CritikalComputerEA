/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesUsuario;

import Singletons.Log;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import models.Usuarios;
import operaciones.UsuariosFacade;

/**
 *
 * @author Adriel
 */
public class deleteUsuario extends Controller.controller {

    UsuariosFacade usuariosFacade = lookupUsuariosFacadeBean();

    @Override
    public void process() {
        int idusuario = Integer.parseInt(request.getParameter("id"));

        Usuarios usuario = usuariosFacade.find(idusuario);
        if (usuario != null) {
            usuariosFacade.remove(usuario);
            try {
                forward("/principalAdministrador.jsp");
            } catch (ServletException ex) {
                Logger.getLogger(deleteUsuario.class.getName()).log(Level.SEVERE, null, ex);
                Log.guardarExcepcion(ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(deleteUsuario.class.getName()).log(Level.SEVERE, null, ex);
                Log.guardarExcepcion(ex.getMessage());
            }
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
