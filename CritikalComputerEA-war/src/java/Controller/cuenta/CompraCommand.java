/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cuenta;

import Singletons.Log;
import Stateful.Carrito;
import Stateful.Compra;
import Stateful.Producto;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adriel
 */
public class CompraCommand extends Controller.controller{

    Log log = lookupLogBean();

    @Override
    public void process() {
        HttpSession session= request.getSession(true);
        Carrito carro = (Carrito) session.getAttribute("Carrito");
        Compra compra= (Compra) session.getAttribute("Compra");
        HashMap<Producto,Integer> carrito= (HashMap<Producto,Integer>) carro.getCarrito().clone();
        compra.setCompra(carrito);
        carro.getCarrito().clear();
        
        try {
            redirect("/CritikalComputerEA-war/Tienda.jsp");
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
    
}
