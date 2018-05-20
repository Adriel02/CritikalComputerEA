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
import models.Ofertas;
import models.Producto;
import models.Proveedores;
import operaciones.OfertasFacade;
import operaciones.ProductoFacade;
import operaciones.ProveedoresFacade;

/**
 *
 * @author Adriel
 */
public class seleccionarProducto extends Controller.controller {

    OfertasFacade ofertasFacade = lookupOfertasFacadeBean();

    ProveedoresFacade proveedoresFacade = lookupProveedoresFacadeBean();

    ProductoFacade productoFacade = lookupProductoFacadeBean();

    @Override
    public void process() {
        List<Proveedores> proveedores= proveedoresFacade.findAll();
        List<Ofertas> ofertas= ofertasFacade.findAll();
        List<Producto> productos= productoFacade.findAll();
        request.setAttribute("listaProveedores", proveedores);
        int idproducto=Integer.parseInt(request.getParameter("id"));
        Producto producto= new Producto();
        for (Producto p: productos) {
            if(p.getId()==idproducto){
                producto=p;
            }
        }
        request.setAttribute("producto", producto);
        request.setAttribute("listaOfertas", ofertas);
        try {
            forward("/ModificarProducto.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(seleccionadorOpciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(seleccionadorOpciones.class.getName()).log(Level.SEVERE, null, ex);
        }
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
