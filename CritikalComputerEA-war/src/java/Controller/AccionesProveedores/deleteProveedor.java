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
public class deleteProveedor extends Controller.controller {

    ProveedoresFacade proveedoresFacade = lookupProveedoresFacadeBean();

    @Override
    public void process() {
        int idproveedor = Integer.parseInt(request.getParameter("id"));
        Proveedores proveedor = proveedoresFacade.find(idproveedor);
        if (proveedor != null) {
            proveedoresFacade.remove(proveedor);
            try {
                forward("principalAdministrador.jsp");
            } catch (ServletException ex) {
                Logger.getLogger(deleteProveedor.class.getName()).log(Level.SEVERE, null, ex);
                Log.guardarExcepcion(ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(deleteProveedor.class.getName()).log(Level.SEVERE, null, ex);
                Log.guardarExcepcion(ex.getMessage());
            }
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
