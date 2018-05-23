/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesCarrito;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import models.Ofertas;
import operaciones.OfertasFacade;

/**
 *
 * @author Adriel
 */
public class carrito extends Controller.controller{

    OfertasFacade ofertasFacade = lookupOfertasFacadeBean();

    @Override
    public void process() {
        List<Ofertas> listaOfertas = ofertasFacade.findAll();
        request.setAttribute("listaOfertas", listaOfertas);
        try {
            forward("/Carrito.jsp");
                    } catch (ServletException ex) {
            Logger.getLogger(carrito.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(carrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private OfertasFacade lookupOfertasFacadeBean() {
        try {
            Context c = new InitialContext();
            return (OfertasFacade) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/OfertasFacade!operaciones.OfertasFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
