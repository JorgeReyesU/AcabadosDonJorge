/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kings
 */
@Entity
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenes.findAll", query = "SELECT o FROM Ordenes o")
    , @NamedQuery(name = "Ordenes.findByOrdCodigo", query = "SELECT o FROM Ordenes o WHERE o.ordCodigo = :ordCodigo")
    , @NamedQuery(name = "Ordenes.findByOrdFechaOrden", query = "SELECT o FROM Ordenes o WHERE o.ordFechaOrden = :ordFechaOrden")
    , @NamedQuery(name = "Ordenes.findByOrdFechaDespacho", query = "SELECT o FROM Ordenes o WHERE o.ordFechaDespacho = :ordFechaDespacho")
    , @NamedQuery(name = "Ordenes.findByOrdFechaPago", query = "SELECT o FROM Ordenes o WHERE o.ordFechaPago = :ordFechaPago")
    , @NamedQuery(name = "Ordenes.findByOrdDireccionEnvio", query = "SELECT o FROM Ordenes o WHERE o.ordDireccionEnvio = :ordDireccionEnvio")
    , @NamedQuery(name = "Ordenes.findByOrdTelefonoEnvio", query = "SELECT o FROM Ordenes o WHERE o.ordTelefonoEnvio = :ordTelefonoEnvio")
    , @NamedQuery(name = "Ordenes.findByOrdComentario", query = "SELECT o FROM Ordenes o WHERE o.ordComentario = :ordComentario")
    , @NamedQuery(name = "Ordenes.findByOrdDescuento", query = "SELECT o FROM Ordenes o WHERE o.ordDescuento = :ordDescuento")
    , @NamedQuery(name = "Ordenes.findByOrdTipoPago", query = "SELECT o FROM Ordenes o WHERE o.ordTipoPago = :ordTipoPago")})
public class Ordenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ordCodigo")
    private Integer ordCodigo;
    @Column(name = "ordFechaOrden")
    @Temporal(TemporalType.DATE)
    private Date ordFechaOrden;
    @Column(name = "ordFechaDespacho")
    @Temporal(TemporalType.DATE)
    private Date ordFechaDespacho;
    @Column(name = "ordFechaPago")
    @Temporal(TemporalType.DATE)
    private Date ordFechaPago;
    @Column(name = "ordDireccionEnvio")
    private String ordDireccionEnvio;
    @Column(name = "ordTelefonoEnvio")
    private String ordTelefonoEnvio;
    @Column(name = "ordComentario")
    private String ordComentario;
    @Column(name = "ordDescuento")
    private Integer ordDescuento;
    @Column(name = "ordTipoPago")
    private String ordTipoPago;
    @JoinColumn(name = "cliNIT", referencedColumnName = "cliNIT")
    @ManyToOne
    private Clientes cliNIT;
    @OneToMany(mappedBy = "ordCodigo")
    private List<Detallesorden> detallesordenList;

    public Ordenes() {
    }

    public Ordenes(Integer ordCodigo) {
        this.ordCodigo = ordCodigo;
    }

    public Integer getOrdCodigo() {
        return ordCodigo;
    }

    public void setOrdCodigo(Integer ordCodigo) {
        this.ordCodigo = ordCodigo;
    }

    public Date getOrdFechaOrden() {
        return ordFechaOrden;
    }

    public void setOrdFechaOrden(Date ordFechaOrden) {
        this.ordFechaOrden = ordFechaOrden;
    }

    public Date getOrdFechaDespacho() {
        return ordFechaDespacho;
    }

    public void setOrdFechaDespacho(Date ordFechaDespacho) {
        this.ordFechaDespacho = ordFechaDespacho;
    }

    public Date getOrdFechaPago() {
        return ordFechaPago;
    }

    public void setOrdFechaPago(Date ordFechaPago) {
        this.ordFechaPago = ordFechaPago;
    }

    public String getOrdDireccionEnvio() {
        return ordDireccionEnvio;
    }

    public void setOrdDireccionEnvio(String ordDireccionEnvio) {
        this.ordDireccionEnvio = ordDireccionEnvio;
    }

    public String getOrdTelefonoEnvio() {
        return ordTelefonoEnvio;
    }

    public void setOrdTelefonoEnvio(String ordTelefonoEnvio) {
        this.ordTelefonoEnvio = ordTelefonoEnvio;
    }

    public String getOrdComentario() {
        return ordComentario;
    }

    public void setOrdComentario(String ordComentario) {
        this.ordComentario = ordComentario;
    }

    public Integer getOrdDescuento() {
        return ordDescuento;
    }

    public void setOrdDescuento(Integer ordDescuento) {
        this.ordDescuento = ordDescuento;
    }

    public String getOrdTipoPago() {
        return ordTipoPago;
    }

    public void setOrdTipoPago(String ordTipoPago) {
        this.ordTipoPago = ordTipoPago;
    }

    public Clientes getCliNIT() {
        return cliNIT;
    }

    public void setCliNIT(Clientes cliNIT) {
        this.cliNIT = cliNIT;
    }

    @XmlTransient
    public List<Detallesorden> getDetallesordenList() {
        return detallesordenList;
    }

    public void setDetallesordenList(List<Detallesorden> detallesordenList) {
        this.detallesordenList = detallesordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordCodigo != null ? ordCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenes)) {
            return false;
        }
        Ordenes other = (Ordenes) object;
        if ((this.ordCodigo == null && other.ordCodigo != null) || (this.ordCodigo != null && !this.ordCodigo.equals(other.ordCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ordenes[ ordCodigo=" + ordCodigo + " ]";
    }
    
}
