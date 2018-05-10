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
import javax.servlet.ServletException;

/**
 *
 * @author Adriel
 */
public class MostrarUsuarios extends Controller.controller{
    @Override
    public void process() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ASBaseDatos", "adriel", "adriel");
            PreparedStatement ps = con.prepareStatement("select * from ADRIEL.USUARIOS");
            ResultSet noRs = ps.executeQuery();
            request.setAttribute("noRs", noRs);
            forward("/verUsuarios.jsp");
        } catch (SQLException | ServletException | IOException ex) {
        }
        
    }
}
