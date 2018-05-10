/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Proveedores;

/**
 *
 * @author Adriel
 */
@Stateless
public class ProveedoresFacade extends AbstractFacade<Proveedores> {

    @PersistenceContext(unitName = "CritikalComputerEA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresFacade() {
        super(Proveedores.class);
    }
    
}
