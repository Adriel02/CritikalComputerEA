/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesCarrito;

/**
 *
 * @author Adriel
 */

import Singletons.Log;
import Stateful.Carrito;
import Stateless.Producto;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

public class AddProduct extends Controller.controller{

    Carrito carrito = lookupCarritoBean();

    Stateless.Producto producto = lookupProductoBean();

    Log log = lookupLogBean();

    @Override
    public void process() {
       producto.setNombre(request.getParameter("nombre"));
       producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
       producto.setDescripcion(request.getParameter("descripcion"));
       
        carrito = (Carrito) request.getSession().getAttribute("Carrito");  //devuelve un obj y tiene que ponerlo tipo carrito.
        
        HashMap<Producto,Integer> carro=carrito.getCarrito();
        Producto encontrado= null;
        for (Producto p : carro.keySet()) {
            if(p.getNombre().equals(producto.getNombre()))
                encontrado=p;
        }
        if(encontrado==null)
            carro.put(producto, 1);
        else
            carro.put(encontrado, carro.get(encontrado)+1);
        
        carrito.setCarrito(carro);
        request.getSession().setAttribute("Carrito", carrito);
        try {
            redirect("/CritikalComputerEA-war/Tienda.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
        }
    }

    private Log lookupLogBean() {
        try {
            Context c = new InitialContext();
            return (Log) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Log!Singletons.Log");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Stateless.Producto lookupProductoBean() {
        try {
            Context c = new InitialContext();
            return (Stateless.Producto) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Producto!Stateless.Producto");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Carrito lookupCarritoBean() {
        try {
            Context c = new InitialContext();
            return (Carrito) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Carrito!Stateful.Carrito");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
