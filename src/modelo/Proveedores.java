/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kings
 */
@Entity
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByProNIT", query = "SELECT p FROM Proveedores p WHERE p.proNIT = :proNIT")
    , @NamedQuery(name = "Proveedores.findByProNombre", query = "SELECT p FROM Proveedores p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "Proveedores.findByProTelefono", query = "SELECT p FROM Proveedores p WHERE p.proTelefono = :proTelefono")
    , @NamedQuery(name = "Proveedores.findByProDireccion", query = "SELECT p FROM Proveedores p WHERE p.proDireccion = :proDireccion")
    , @NamedQuery(name = "Proveedores.findByProEmail", query = "SELECT p FROM Proveedores p WHERE p.proEmail = :proEmail")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "proNIT")
    public String proNIT;
    @Column(name = "proNombre")
    private String proNombre;
    @Column(name = "proTelefono")
    private String proTelefono;
    @Column(name = "proDireccion")
    private String proDireccion;
    @Column(name = "proEmail")
    private String proEmail;
    @OneToMany(mappedBy = "proNIT")
    private List<Productos> productosList;
    @OneToMany(mappedBy = "proNIT")
    private List<Materiasprimas> materiasprimasList;

    public Proveedores() {
    }

    public Proveedores(String proNIT) {
        this.proNIT = proNIT;
    }

    public String getProNIT() {
        return proNIT;
    }

    public void setProNIT(String proNIT) {
        this.proNIT = proNIT;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProTelefono() {
        return proTelefono;
    }

    public void setProTelefono(String proTelefono) {
        this.proTelefono = proTelefono;
    }

    public String getProDireccion() {
        return proDireccion;
    }

    public void setProDireccion(String proDireccion) {
        this.proDireccion = proDireccion;
    }

    public String getProEmail() {
        return proEmail;
    }

    public void setProEmail(String proEmail) {
        this.proEmail = proEmail;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @XmlTransient
    public List<Materiasprimas> getMateriasprimasList() {
        return materiasprimasList;
    }

    public void setMateriasprimasList(List<Materiasprimas> materiasprimasList) {
        this.materiasprimasList = materiasprimasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proNIT != null ? proNIT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.proNIT == null && other.proNIT != null) || (this.proNIT != null && !this.proNIT.equals(other.proNIT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proveedores[ proNIT=" + proNIT + " ]";
    }
    
}
