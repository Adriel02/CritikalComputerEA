/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesProveedores;

import Singletons.Log;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import models.Proveedores;
import operaciones.ProveedoresFacade;

/**
 *
 * @author Adriel
 */
public class addProveedor extends Controller.controller{

    ProveedoresFacade proveedoresFacade = lookupProveedoresFacadeBean();

    @Override
    public void process() {
        Proveedores proveedor = new Proveedores();
        proveedor.setNombre(request.getParameter("nombre"));
        proveedor.setApellidos(request.getParameter("apellidos"));
        proveedor.setEmpresa(request.getParameter("empresa"));
        proveedoresFacade.create(proveedor);
        try {
            forward("/principalAdministrador.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(addProveedor.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(addProveedor.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage());
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
    
}
