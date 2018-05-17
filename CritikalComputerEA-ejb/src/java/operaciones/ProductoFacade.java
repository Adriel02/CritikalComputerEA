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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        String query= "INSERT INTO PRODUCTO(nombre,precio,descripcion,proveedor,oferta) VALUES (?,?,?,?,?)";
        em.createNativeQuery(query).setParameter(1, producto.getNombre()).
                              setParameter(2, producto.getPrecio()).
                              setParameter(3, producto.getDescripcion()).
                              setParameter(4, producto.getProveedor()).
                              setParameter(5, producto.getOferta()).executeUpdate();
    }
    public List<Producto> verProductos(){
        String query="SELECT p FROM Producto p ORDER BY p.precio ASC";
        return em.createQuery(query).getResultList();
    }
    public void modificarProducto(Producto producto){
        String query="UPDATE Producto set nombre=:nombre,precio=:precio,descripcion=:descripcion,proveedor=:proveedor,oferta=:oferta where id=:id";
        em.createQuery(query).setParameter("nombre",producto.getNombre()).
                setParameter("precio", producto.getPrecio()).
                setParameter("descripcion", producto.getDescripcion()).
                setParameter("proveedor", producto.getProveedor()).
                setParameter("oferta", producto.getOferta()).
                setParameter("id", producto.getId()).executeUpdate();
    }
    public void eliminarProducto(Producto producto){
        String query= "DELETE FROM Producto p where p.id=:id";
        em.createQuery(query).setParameter("id", producto.getId()).executeUpdate();
}
   public List<Producto> verProductosPrecioDesc(){
       CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<Producto> query = cb.createQuery(Producto.class);
       Root<Producto> root = query.from(Producto.class);
       query.select(root);
       query.orderBy(cb.desc(root.get("precio")));
       return em.createQuery(query).getResultList();
   } 
   public List<Producto> verProductosPrecioAsc(){
       CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<Producto> query = cb.createQuery(Producto.class);
       Root<Producto> root = query.from(Producto.class);
       query.select(root);
       query.orderBy(cb.asc(root.get("precio")));
       return em.createQuery(query).getResultList();
   } 
   public List<Producto> verProductosAlfabetico(){
       CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<Producto> query = cb.createQuery(Producto.class);
       Root<Producto> root = query.from(Producto.class);
       query.select(root);
       query.orderBy(cb.asc(root.get("nombre")));
       return em.createQuery(query).getResultList();
   } 
   
   
}
