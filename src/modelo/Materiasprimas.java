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
@Table(name = "materiasprimas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiasprimas.findAll", query = "SELECT m FROM Materiasprimas m")
    , @NamedQuery(name = "Materiasprimas.findByMatCodigo", query = "SELECT m FROM Materiasprimas m WHERE m.matCodigo = :matCodigo")
    , @NamedQuery(name = "Materiasprimas.findByMatNombre", query = "SELECT m FROM Materiasprimas m WHERE m.matNombre = :matNombre")
    , @NamedQuery(name = "Materiasprimas.findByMatDescripcion", query = "SELECT m FROM Materiasprimas m WHERE m.matDescripcion = :matDescripcion")
    , @NamedQuery(name = "Materiasprimas.findByMatUnidadMedida", query = "SELECT m FROM Materiasprimas m WHERE m.matUnidadMedida = :matUnidadMedida")
    , @NamedQuery(name = "Materiasprimas.findByMatCatidad", query = "SELECT m FROM Materiasprimas m WHERE m.matCatidad = :matCatidad")
    , @NamedQuery(name = "Materiasprimas.findByMatPrecioComprado", query = "SELECT m FROM Materiasprimas m WHERE m.matPrecioComprado = :matPrecioComprado")})
public class Materiasprimas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "matCodigo")
    private Integer matCodigo;
    @Column(name = "matNombre")
    private String matNombre;
    @Column(name = "matDescripcion")
    private String matDescripcion;
    @Column(name = "matUnidadMedida")
    private String matUnidadMedida;
    @Column(name = "matCatidad")
    private Integer matCatidad;
    @Column(name = "matPrecioComprado")
    private Integer matPrecioComprado;
    @JoinColumn(name = "proNIT", referencedColumnName = "proNIT")
    @ManyToOne
    private Proveedores proNIT;

    public Materiasprimas() {
    }

    public Materiasprimas(Integer matCodigo) {
        this.matCodigo = matCodigo;
    }

    public Integer getMatCodigo() {
        return matCodigo;
    }

    public void setMatCodigo(Integer matCodigo) {
        this.matCodigo = matCodigo;
    }

    public String getMatNombre() {
        return matNombre;
    }

    public void setMatNombre(String matNombre) {
        this.matNombre = matNombre;
    }

    public String getMatDescripcion() {
        return matDescripcion;
    }

    public void setMatDescripcion(String matDescripcion) {
        this.matDescripcion = matDescripcion;
    }

    public String getMatUnidadMedida() {
        return matUnidadMedida;
    }

    public void setMatUnidadMedida(String matUnidadMedida) {
        this.matUnidadMedida = matUnidadMedida;
    }

    public Integer getMatCatidad() {
        return matCatidad;
    }

    public void setMatCatidad(Integer matCatidad) {
        this.matCatidad = matCatidad;
    }

    public Integer getMatPrecioComprado() {
        return matPrecioComprado;
    }

    public void setMatPrecioComprado(Integer matPrecioComprado) {
        this.matPrecioComprado = matPrecioComprado;
    }

    public Proveedores getProNIT() {
        return proNIT;
    }

    public void setProNIT(Proveedores proNIT) {
        this.proNIT = proNIT;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matCodigo != null ? matCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiasprimas)) {
            return false;
        }
        Materiasprimas other = (Materiasprimas) object;
        if ((this.matCodigo == null && other.matCodigo != null) || (this.matCodigo != null && !this.matCodigo.equals(other.matCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Materiasprimas[ matCodigo=" + matCodigo + " ]";
    }
    
}
