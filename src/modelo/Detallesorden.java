/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kings
 */
@Entity
@Table(name = "detallesorden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallesorden.findAll", query = "SELECT d FROM Detallesorden d")
    , @NamedQuery(name = "Detallesorden.findByDetCodigo", query = "SELECT d FROM Detallesorden d WHERE d.detCodigo = :detCodigo")
    , @NamedQuery(name = "Detallesorden.findByDetCantidad", query = "SELECT d FROM Detallesorden d WHERE d.detCantidad = :detCantidad")
    , @NamedQuery(name = "Detallesorden.findByDetDescripcion", query = "SELECT d FROM Detallesorden d WHERE d.detDescripcion = :detDescripcion")})
public class Detallesorden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detCodigo")
    private Integer detCodigo;
    @Column(name = "detCantidad")
    private Integer detCantidad;
    @Column(name = "detDescripcion")
    private String detDescripcion;
    @JoinColumn(name = "ordCodigo", referencedColumnName = "ordCodigo")
    @ManyToOne
    private Ordenes ordCodigo;
    @JoinColumn(name = "prodCodigo", referencedColumnName = "prodCodigo")
    @ManyToOne
    private Productos prodCodigo;

    public Detallesorden() {
    }

    public Detallesorden(Integer detCodigo) {
        this.detCodigo = detCodigo;
    }

    public Integer getDetCodigo() {
        return detCodigo;
    }

    public void setDetCodigo(Integer detCodigo) {
        this.detCodigo = detCodigo;
    }

    public Integer getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(Integer detCantidad) {
        this.detCantidad = detCantidad;
    }

    public String getDetDescripcion() {
        return detDescripcion;
    }

    public void setDetDescripcion(String detDescripcion) {
        this.detDescripcion = detDescripcion;
    }

    public Ordenes getOrdCodigo() {
        return ordCodigo;
    }

    public void setOrdCodigo(Ordenes ordCodigo) {
        this.ordCodigo = ordCodigo;
    }

    public Productos getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(Productos prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detCodigo != null ? detCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallesorden)) {
            return false;
        }
        Detallesorden other = (Detallesorden) object;
        if ((this.detCodigo == null && other.detCodigo != null) || (this.detCodigo != null && !this.detCodigo.equals(other.detCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Detallesorden[ detCodigo=" + detCodigo + " ]";
    }
    
}
