/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kings
 */
@Entity
@Table(name = "observaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observaciones.findAll", query = "SELECT o FROM Observaciones o")
    , @NamedQuery(name = "Observaciones.findByObsCodigo", query = "SELECT o FROM Observaciones o WHERE o.obsCodigo = :obsCodigo")
    , @NamedQuery(name = "Observaciones.findByObsDescripcion", query = "SELECT o FROM Observaciones o WHERE o.obsDescripcion = :obsDescripcion")
    , @NamedQuery(name = "Observaciones.findByObsFecha", query = "SELECT o FROM Observaciones o WHERE o.obsFecha = :obsFecha")})
public class Observaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "obsCodigo")
    private Integer obsCodigo;
    @Column(name = "obsDescripcion")
    private String obsDescripcion;
    @Column(name = "obsFecha")
    @Temporal(TemporalType.DATE)
    private Date obsFecha;
    @JoinColumn(name = "empDni", referencedColumnName = "empDni")
    @ManyToOne
    private Empleados empDni;

    public Observaciones() {
    }

    public Observaciones(Integer obsCodigo) {
        this.obsCodigo = obsCodigo;
    }

    public Integer getObsCodigo() {
        return obsCodigo;
    }

    public void setObsCodigo(Integer obsCodigo) {
        this.obsCodigo = obsCodigo;
    }

    public String getObsDescripcion() {
        return obsDescripcion;
    }

    public void setObsDescripcion(String obsDescripcion) {
        this.obsDescripcion = obsDescripcion;
    }

    public Date getObsFecha() {
        return obsFecha;
    }

    public void setObsFecha(Date obsFecha) {
        this.obsFecha = obsFecha;
    }

    public Empleados getEmpDni() {
        return empDni;
    }

    public void setEmpDni(Empleados empDni) {
        this.empDni = empDni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obsCodigo != null ? obsCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observaciones)) {
            return false;
        }
        Observaciones other = (Observaciones) object;
        if ((this.obsCodigo == null && other.obsCodigo != null) || (this.obsCodigo != null && !this.obsCodigo.equals(other.obsCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Observaciones[ obsCodigo=" + obsCodigo + " ]";
    }
    
}
