/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesVentas;

import Controller.AccionesOfertas.MostrarOfertas;
import java.io.IOException;
import java.util.List;
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
public class MostrarVentas extends Controller.controller{

    VentasFacade ventasFacade = lookupVentasFacadeBean();

    @Override
    public void process() {
        List<Ventas> ventas=ventasFacade.findAll();
        request.setAttribute("listaVentas", ventas);
        try {
            forward("/verVentas.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(MostrarOfertas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MostrarOfertas.class.getName()).log(Level.SEVERE, null, ex);
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
