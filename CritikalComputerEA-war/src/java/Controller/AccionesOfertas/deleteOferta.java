/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesOfertas;

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
public class deleteOferta extends Controller.controller{

    OfertasFacade ofertasFacade = lookupOfertasFacadeBean();

    @Override
    public void process() {
        int idoferta= Integer.parseInt(request.getParameter("id"));
        Ofertas oferta= ofertasFacade.find(idoferta);
        if(oferta!=null){
            ofertasFacade.remove(oferta);
            try {
                forward("/principalAdministrador.jsp");
            } catch (ServletException ex) {
                Logger.getLogger(deleteOferta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(deleteOferta.class.getName()).log(Level.SEVERE, null, ex);
            }
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
