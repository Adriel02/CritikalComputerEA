/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesProducto;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import models.Producto;
import operaciones.ProductoFacade;

/**
 *
 * @author Adriel
 */
public class MostrarProductos extends Controller.controller{

    ProductoFacade productoFacade = lookupProductoFacadeBean();

    private ProductoFacade lookupProductoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ProductoFacade) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/ProductoFacade!operaciones.ProductoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public void process() {
        List<Producto> productos= productoFacade.verProductos();
        request.setAttribute("listaProductos", productos);
        try {
            forward("/verProductos");
        } catch (ServletException ex) {
            Logger.getLogger(MostrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MostrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
