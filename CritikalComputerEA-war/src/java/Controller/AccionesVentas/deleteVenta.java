/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesVentas;

import Controller.AccionesOfertas.deleteOferta;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import models.Ventas;
import operaciones.VentasFacade;

/**
 *
 * @author Adriel
 */
public class deleteVenta extends Controller.controller{

    VentasFacade ventasFacade = lookupVentasFacadeBean();

    @Override
    public void process() {
        int idVenta=Integer.parseInt(request.getParameter("id"));
        Ventas venta= ventasFacade.find(idVenta);
        if(venta!= null){
            ventasFacade.remove(venta);
            try {
                forward("/principalAdministrador.jsp");
            } catch (ServletException ex) {
                Logger.getLogger(deleteOferta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(deleteOferta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private VentasFacade lookupVentasFacadeBean() {
        try {
            Context c = new InitialContext();
            return (VentasFacade) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/VentasFacade!operaciones.VentasFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
