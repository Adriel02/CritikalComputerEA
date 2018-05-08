/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateless;

import Stateful.Producto;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Adriel
 */
@Stateless
@LocalBean
public class Oferta {
    private double descuento;
    private String fechaOferta;
    private String nombreOferta;

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getFechaOferta() {
        return fechaOferta;
    }

    public void setFechaOferta(String fechaOferta) {
        this.fechaOferta = fechaOferta;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }
    
    public double getPrecioConDescuento(Producto producto){
        return producto.getPrecio()-(producto.getPrecio()*descuento);
    }
    
}
