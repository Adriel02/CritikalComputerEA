/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesOfertas;

import Singletons.Log;
import java.io.IOException;
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
public class addOferta extends Controller.controller{

    OfertasFacade ofertasFacade = lookupOfertasFacadeBean();

    @Override
    public void process() {
        Ofertas oferta = new Ofertas();
        oferta.setNombre(request.getParameter("nombre"));
        oferta.setDescuento(Integer.parseInt(request.getParameter("descuento")));
        ofertasFacade.create(oferta);
        try {
            forward("principalAdministrador.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(addOferta.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(addOferta.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage());
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
