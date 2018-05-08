/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateful;

import Stateful.Producto;
import java.util.HashMap;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author Adriel
 */
@Stateful
@LocalBean
public class Compra {
    public Compra() {
        this.compra = new HashMap<>();
    }
    private HashMap<Producto, Integer> compra;
    private final String nombre = "CompraHecha";

    public HashMap<Producto, Integer> getCompra() {
        return compra;
    }

    public void setCompra(HashMap<Producto, Integer> compra) {
        this.compra = compra;
    }
}
