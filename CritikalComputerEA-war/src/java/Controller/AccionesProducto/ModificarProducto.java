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
public class ModificarProducto extends Controller.controller {

    ProductoFacade productoFacade = lookupProductoFacadeBean();

    @Override
    public void process() {
        System.out.println("id-->"+request.getParameter("idProducto"));
        List<Producto> productos = productoFacade.findAll();
        Producto producto = new Producto();
        for (Producto p : productos) {
            if(Integer.parseInt(request.getParameter("idProducto"))==p.getId()){
                producto = p;
            }
        }
        producto.setDescripcion(request.getParameter("descripcion"));
        producto.setNombre(request.getParameter("nombre"));
        producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
        producto.setOferta(Integer.parseInt(request.getParameter("oferta")));
        producto.setProveedor(Integer.parseInt(request.getParameter("proveedor")));
        productoFacade.modificarProducto(producto);
        try {
            forward("/principalAdministrador.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(addProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addProducto.class.getName()).log(Level.SEVERE, null, ex);
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

}
