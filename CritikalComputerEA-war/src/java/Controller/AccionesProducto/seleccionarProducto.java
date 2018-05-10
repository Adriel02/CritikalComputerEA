/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesProducto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import operaciones.OfertasFacade;
import operaciones.ProductoFacade;
import operaciones.ProveedoresFacade;

/**
 *
 * @author Adriel
 */
public class seleccionarProducto extends Controller.controller{

    OfertasFacade ofertasFacade = lookupOfertasFacadeBean();

    ProveedoresFacade proveedoresFacade = lookupProveedoresFacadeBean();

    ProductoFacade productoFacade = lookupProductoFacadeBean();

    @Override
    public void process() {
        
    }

    private ProductoFacade lookupProductoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ProductoFacade) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/ProductoFacade!operaciones.ProductoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ProveedoresFacade lookupProveedoresFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ProveedoresFacade) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/ProveedoresFacade!operaciones.ProveedoresFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
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
