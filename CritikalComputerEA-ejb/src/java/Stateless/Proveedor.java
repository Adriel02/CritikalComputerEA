/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateless;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Adriel
 */
@Stateless
@LocalBean
public class Proveedor {
    private String empresa;
    private String nombre;
    private int id;
    private String areaReparto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaReparto() {
        return areaReparto;
    }

    public void setAreaReparto(String areaReparto) {
        this.areaReparto = areaReparto;
    }
    

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
