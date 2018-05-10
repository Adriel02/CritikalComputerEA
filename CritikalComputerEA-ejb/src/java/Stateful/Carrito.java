/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateful;

import java.util.HashMap;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import models.Producto;

/**
 *
 * @author Adriel
 */
@Stateful
@LocalBean
public class Carrito {

    public Carrito() {
        this.carrito = new HashMap<>();
    }
    private HashMap<Producto, Integer> carrito;
    private final String nombre="Carrito";
    
    

    public HashMap<Producto, Integer> getCarrito() {
        return carrito;
    }

    public void setCarrito(HashMap<Producto, Integer> carrito) {
        this.carrito = carrito;
    }
    
}