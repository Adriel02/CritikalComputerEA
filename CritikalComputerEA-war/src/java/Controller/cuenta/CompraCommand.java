/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cuenta;

import Singletons.Log;
import Stateful.Carrito;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import models.Producto;
import models.Usuarios;
import models.Ventas;
import operaciones.VentasFacade;

/**
 *
 * @author Adriel
 */
public class CompraCommand extends Controller.controller{

    VentasFacade ventasFacade = lookupVentasFacadeBean();


    Log log = lookupLogBean();

    @Override
    public void process() {
        HttpSession session= request.getSession(true);
            Carrito carro = (Carrito) session.getAttribute("Carrito");
            Usuarios usuario = (Usuarios) session.getAttribute("Usuario");
        Ventas venta= new Ventas(); 
        venta.setUsuario(usuario.getNombre());
        venta.setFecha(new Date().toString());
        double precioTotal=0;
        
        HashMap<Producto,Integer> carrito= (HashMap<Producto,Integer>) carro.getCarrito().clone();
        for (Producto p : carro.getCarrito().keySet()){
            precioTotal+=p.getPrecio()*carro.getCarrito().get(p); //cantidad de productos
        }
        venta.setPreciototal(precioTotal);
        ventasFacade.create(venta);
        carro.getCarrito().clear();
        
        try {
            redirect("/CritikalComputerEA-war/principalAdministrador.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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

    private VentasFacade lookupVentasFacadeBean() {
        try {
            Context c = new InitialContext();
            return (VentasFacade) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/VentasFacade!operaciones.VentasFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    
}
