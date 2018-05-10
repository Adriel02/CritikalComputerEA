/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adriel
 */
@Entity
@Table(name = "OFERTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ofertas.findAll", query = "SELECT o FROM Ofertas o")
    , @NamedQuery(name = "Ofertas.findById", query = "SELECT o FROM Ofertas o WHERE o.id = :id")
    , @NamedQuery(name = "Ofertas.findByNombre", query = "SELECT o FROM Ofertas o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Ofertas.findByDescuento", query = "SELECT o FROM Ofertas o WHERE o.descuento = :descuento")})
public class Ofertas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO")
    private int descuento;

    public Ofertas() {
    }

    public Ofertas(Integer id) {
        this.id = id;
    }

    public Ofertas(Integer id, String nombre, int descuento) {
        this.id = id;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertas)) {
            return false;
        }
        Ofertas other = (Ofertas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Ofertas[ id=" + id + " ]";
    }
    
}
