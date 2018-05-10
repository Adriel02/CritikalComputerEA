/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Ventas;

/**
 *
 * @author Adriel
 */
@Stateless
public class VentasFacade extends AbstractFacade<Ventas> {

    @PersistenceContext(unitName = "CritikalComputerEA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasFacade() {
        super(Ventas.class);
    }
    
}
