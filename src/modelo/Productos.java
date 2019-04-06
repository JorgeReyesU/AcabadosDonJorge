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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByProdCodigo", query = "SELECT p FROM Productos p WHERE p.prodCodigo = :prodCodigo")
    , @NamedQuery(name = "Productos.findByProdNombre", query = "SELECT p FROM Productos p WHERE p.prodNombre = :prodNombre")
    , @NamedQuery(name = "Productos.findByProdDescripcion", query = "SELECT p FROM Productos p WHERE p.prodDescripcion = :prodDescripcion")
    , @NamedQuery(name = "Productos.findByProdUnidadMedida", query = "SELECT p FROM Productos p WHERE p.prodUnidadMedida = :prodUnidadMedida")
    , @NamedQuery(name = "Productos.findByProdCantidad", query = "SELECT p FROM Productos p WHERE p.prodCantidad = :prodCantidad")
    , @NamedQuery(name = "Productos.findByProdPrecioComprado", query = "SELECT p FROM Productos p WHERE p.prodPrecioComprado = :prodPrecioComprado")
    , @NamedQuery(name = "Productos.findByProdPrecioVenta", query = "SELECT p FROM Productos p WHERE p.prodPrecioVenta = :prodPrecioVenta")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prodCodigo")
    private Integer prodCodigo;
    @Column(name = "prodNombre")
    private String prodNombre;
    @Column(name = "prodDescripcion")
    private String prodDescripcion;
    @Column(name = "prodUnidadMedida")
    private String prodUnidadMedida;
    @Column(name = "prodCantidad")
    private Integer prodCantidad;
    @Column(name = "prodPrecioComprado")
    private Integer prodPrecioComprado;
    @Column(name = "prodPrecioVenta")
    private Integer prodPrecioVenta;
    @OneToMany(mappedBy = "prodCodigo")
    private List<Detallesorden> detallesordenList;
    @JoinColumn(name = "proNIT", referencedColumnName = "proNIT")
    @ManyToOne
    private Proveedores proNIT;

    public Productos() {
    }

    public Productos(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public Integer getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    public String getProdDescripcion() {
        return prodDescripcion;
    }

    public void setProdDescripcion(String prodDescripcion) {
        this.prodDescripcion = prodDescripcion;
    }

    public String getProdUnidadMedida() {
        return prodUnidadMedida;
    }

    public void setProdUnidadMedida(String prodUnidadMedida) {
        this.prodUnidadMedida = prodUnidadMedida;
    }

    public Integer getProdCantidad() {
        return prodCantidad;
    }

    public void setProdCantidad(Integer prodCantidad) {
        this.prodCantidad = prodCantidad;
    }

    public Integer getProdPrecioComprado() {
        return prodPrecioComprado;
    }

    public void setProdPrecioComprado(Integer prodPrecioComprado) {
        this.prodPrecioComprado = prodPrecioComprado;
    }

    public Integer getProdPrecioVenta() {
        return prodPrecioVenta;
    }

    public void setProdPrecioVenta(Integer prodPrecioVenta) {
        this.prodPrecioVenta = prodPrecioVenta;
    }

    @XmlTransient
    public List<Detallesorden> getDetallesordenList() {
        return detallesordenList;
    }

    public void setDetallesordenList(List<Detallesorden> detallesordenList) {
        this.detallesordenList = detallesordenList;
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
        hash += (prodCodigo != null ? prodCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.prodCodigo == null && other.prodCodigo != null) || (this.prodCodigo != null && !this.prodCodigo.equals(other.prodCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Productos[ prodCodigo=" + prodCodigo + " ]";
    }
    
}
