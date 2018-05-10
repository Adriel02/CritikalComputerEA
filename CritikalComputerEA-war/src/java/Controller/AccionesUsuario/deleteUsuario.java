/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesUsuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Adriel
 */
public class deleteUsuario extends Controller.controller {
     @Override
    public void process() {
        try {
            connectAndQuery();
            try {
                forward("/principalAdministrador.jsp");
            } catch (ServletException ex) {
            } catch (IOException ex) {
                Logger.getLogger(deleteUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
        }
    }

    public void connectAndQuery() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ASBaseDatos", "adriel", "adriel");
        String selectQuery = "select * from ADRIEL.USUARIOS";
        PreparedStatement usuarios = con.prepareStatement(selectQuery);
        ResultSet rs = usuarios.executeQuery();

        int i = 1;
        while (rs.next()) {
            i++;
        } 
        try {
            Statement st = con.createStatement();
            String query = "delete ADRIEL.USUARIOS where id= ?";
            System.out.println("QUERY: " + query);
            st.executeUpdate(query);
        } catch (SQLException ex) {
        }
    }
}
