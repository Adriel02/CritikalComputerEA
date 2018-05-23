/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesCarrito;


import Singletons.Log;
import Stateful.Carrito;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

/**
 *
 * @author Adriel
 */
public class EliminarProducto extends Controller.controller {

    OfertasFacade ofertasFacade = lookupOfertasFacadeBean();


    Carrito carrito = lookupCarritoBean();
    
    Log log = lookupLogBean();

    @Override
    public void process() {
        int idproducto= Integer.parseInt(request.getParameter("id"));
        carrito = (Carrito) request.getSession().getAttribute("Carrito");  //devuelve un obj y tiene que ponerlo tipo carrito.

        HashMap<Producto, Integer> carro = carrito.getCarrito();
        Producto encontrado = null;
        for (Producto p : carro.keySet()) {
            if (p.getId()==idproducto) {
                encontrado = p;
            }
        }
        carro.put(encontrado, carro.get(encontrado) - 1);
        if(carro.get(encontrado)==0)
            carro.remove(encontrado);
            
        carrito.setCarrito(carro);
        request.getSession().setAttribute("Carrito", carrito);
        List<Ofertas> listaOfertas = ofertasFacade.findAll();
        request.setAttribute("listaOfertas", listaOfertas);
        try {
            forward("/Carrito.jsp");
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
