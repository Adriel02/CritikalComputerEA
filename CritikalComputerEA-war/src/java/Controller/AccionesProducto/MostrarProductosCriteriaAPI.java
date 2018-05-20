/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesProducto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class MostrarProductosCriteriaAPI extends Controller.controller {

    OfertasFacade ofertasFacade = lookupOfertasFacadeBean();

    ProveedoresFacade proveedoresFacade = lookupProveedoresFacadeBean();

    ProductoFacade productoFacade = lookupProductoFacadeBean();

    @Override
    public void process() {
        String criterio = "";
        Map<Integer, Proveedores> proveedores = new HashMap<>();
        Map<Integer, Ofertas> ofertas = new HashMap<>();
        criterio = request.getParameter("criterio");
        System.out.println("CRITERIO: "+criterio);
        List<Producto> productos = new ArrayList<>();
        switch (criterio) {
            case "asc":
                productos = productoFacade.verProductosPrecioAsc();
                break;
            case "desc":
                productos = productoFacade.verProductosPrecioDesc();
                break;
            case "abcd":
                productos = productoFacade.verProductosAlfabetico();
                break;
            default:
                productos = productoFacade.verProductosPrecioDesc();
                break;
        }
        request.setAttribute("listaProductos", productos);
        for (Producto p : productos) {
            proveedores.put(p.getProveedor(),proveedoresFacade.find(p.getProveedor()));
        }
        for (Producto p : productos) {
            ofertas.put(p.getOferta(),ofertasFacade.find(p.getOferta()));
        }
        request.setAttribute("mapaProveedores", proveedores);
        request.setAttribute("mapaOfertas", ofertas);
        try {
            forward("/verProductos.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(MostrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MostrarProductos.class.getName()).log(Level.SEVERE, null, ex);
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
