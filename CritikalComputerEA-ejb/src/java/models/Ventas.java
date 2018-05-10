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
@Table(name = "VENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findById", query = "SELECT v FROM Ventas v WHERE v.id = :id")
    , @NamedQuery(name = "Ventas.findByFecha", query = "SELECT v FROM Ventas v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Ventas.findByPreciototal", query = "SELECT v FROM Ventas v WHERE v.preciototal = :preciototal")
    , @NamedQuery(name = "Ventas.findByUsuario", query = "SELECT v FROM Ventas v WHERE v.usuario = :usuario")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FECHA")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOTOTAL")
    private double preciototal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USUARIO")
    private String usuario;

    public Ventas() {
    }

    public Ventas(Integer id) {
        this.id = id;
    }

    public Ventas(Integer id, String fecha, double preciototal, String usuario) {
        this.id = id;
        this.fecha = fecha;
        this.preciototal = preciototal;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Ventas[ id=" + id + " ]";
    }
    
}
