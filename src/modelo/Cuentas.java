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
@Table(name = "cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentas.findAll", query = "SELECT c FROM Cuentas c")
    , @NamedQuery(name = "Cuentas.findByCuentaCodigo", query = "SELECT c FROM Cuentas c WHERE c.cuentaCodigo = :cuentaCodigo")
    , @NamedQuery(name = "Cuentas.findByCuentaPassword", query = "SELECT c FROM Cuentas c WHERE c.cuentaPassword = :cuentaPassword")})
public class Cuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cuentaCodigo")
    private Integer cuentaCodigo;
    @Column(name = "cuentaPassword")
    private String cuentaPassword;
    @JoinColumn(name = "empDni", referencedColumnName = "empDni")
    @ManyToOne
    private Empleados empDni;

    public Cuentas() {
    }

    public Cuentas(Integer cuentaCodigo) {
        this.cuentaCodigo = cuentaCodigo;
    }

    public Integer getCuentaCodigo() {
        return cuentaCodigo;
    }

    public void setCuentaCodigo(Integer cuentaCodigo) {
        this.cuentaCodigo = cuentaCodigo;
    }

    public String getCuentaPassword() {
        return cuentaPassword;
    }

    public void setCuentaPassword(String cuentaPassword) {
        this.cuentaPassword = cuentaPassword;
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
        hash += (cuentaCodigo != null ? cuentaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentas)) {
            return false;
        }
        Cuentas other = (Cuentas) object;
        if ((this.cuentaCodigo == null && other.cuentaCodigo != null) || (this.cuentaCodigo != null && !this.cuentaCodigo.equals(other.cuentaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cuentas[ cuentaCodigo=" + cuentaCodigo + " ]";
    }
    
}
