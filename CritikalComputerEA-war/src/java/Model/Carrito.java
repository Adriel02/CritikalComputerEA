/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Adriel
 */
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
