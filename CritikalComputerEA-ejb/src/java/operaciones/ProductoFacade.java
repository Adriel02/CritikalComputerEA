/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Producto;

/**
 *
 * @author Adriel
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "CritikalComputerEA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    public void crearProducto(Producto producto){
        String query= "INSERT INTO PRODUCTO(nombre,precio,descripcion,proveedor,oferta) VALUES (:nombre,:precio,:descripcion,:proveedor,:oferta);";
        em.createQuery(query).setParameter("nombre", producto.getNombre()).
                              setParameter("precio", producto.getPrecio()).
                              setParameter("descripcion", producto.getDescripcion()).
                              setParameter("proveedor", producto.getProveedor()).
                              setParameter("oferta", producto.getOferta()).executeUpdate();
    }
    public List<Producto> verProductos(){
        String query="SELECT * FROM PRODUCTO ORDER BY precio ASC";
        return em.createQuery(query).getResultList();
    }
    public void modificarProducto(Producto producto){
        String query="UPDATE productos set nombre=:nombre,precio=:precio,descripcion=:descripcion,proveedor=:proveedor,oferta=:oferta where id=:id";
        em.createQuery(query).setParameter("nombre",producto.getNombre()).
                setParameter("precio", producto.getPrecio()).
                setParameter("descripcion", producto.getDescripcion()).
                setParameter("proveedor", producto.getProveedor()).
                setParameter("oferta", producto.getOferta()).
                setParameter("id", producto.getId()).executeUpdate();
    }
    public void eliminarProducto(Producto producto){
        String query= "DELETE FROM PRODUCTOS where id=:id";
        em.createQuery(query).setParameter("id", producto.getId()).executeUpdate();
    }
}
