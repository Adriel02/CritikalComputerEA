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
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import models.Ofertas;
import models.Producto;
import operaciones.OfertasFacade;
import operaciones.ProductoFacade;

public class addCarrito extends Controller.controller {


    ProductoFacade productoFacade = lookupProductoFacadeBean();

    Log log = lookupLogBean();
    Carrito carrito = lookupCarritoBean();

    @Override
    public void process() {
        Producto producto = productoFacade.find(Integer.parseInt(request.getParameter("id")));
        
        carrito = (Carrito) request.getSession().getAttribute("Carrito");  //devuelve un obj y tiene que ponerlo tipo carrito.
        
        HashMap<Producto, Integer> carro = carrito.getCarrito();
        Producto encontrado = null;
        for (Producto p : carro.keySet()) {
            if (p.getId()==producto.getId()) {
                encontrado = p;
            }
        }
        System.out.println("Encontrado= " + encontrado);

        if (encontrado == null) {
            carro.put(producto, 1);
        } else {
            carro.put(encontrado, carro.get(encontrado) + 1);
        }

        carrito.setCarrito(carro);
        request.getSession().setAttribute("Carrito", carrito);
        try {
            redirect("/CritikalComputerEA-war/principalAdministrador.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(addCarrito.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addCarrito.class.getName()).log(Level.SEVERE, null, ex);
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

    private Carrito lookupCarritoBean() {
        try {
            Context c = new InitialContext();
            return (Carrito) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/Carrito!Stateful.Carrito");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
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
