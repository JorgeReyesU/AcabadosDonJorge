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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCliNIT", query = "SELECT c FROM Clientes c WHERE c.cliNIT = :cliNIT")
    , @NamedQuery(name = "Clientes.findByCliNombre", query = "SELECT c FROM Clientes c WHERE c.cliNombre = :cliNombre")
    , @NamedQuery(name = "Clientes.findByCliApellido", query = "SELECT c FROM Clientes c WHERE c.cliApellido = :cliApellido")
    , @NamedQuery(name = "Clientes.findByCliTelefono", query = "SELECT c FROM Clientes c WHERE c.cliTelefono = :cliTelefono")
    , @NamedQuery(name = "Clientes.findByCliDireccion", query = "SELECT c FROM Clientes c WHERE c.cliDireccion = :cliDireccion")
    , @NamedQuery(name = "Clientes.findByCliEmail", query = "SELECT c FROM Clientes c WHERE c.cliEmail = :cliEmail")
    , @NamedQuery(name = "Clientes.findByCliTipoCliente", query = "SELECT c FROM Clientes c WHERE c.cliTipoCliente = :cliTipoCliente")
    , @NamedQuery(name = "Clientes.findByCliDescuento", query = "SELECT c FROM Clientes c WHERE c.cliDescuento = :cliDescuento")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cliNIT")
    public String cliNIT;
    @Column(name = "cliNombre")
    private String cliNombre;
    @Column(name = "cliApellido")
    private String cliApellido;
    @Column(name = "cliTelefono")
    private String cliTelefono;
    @Column(name = "cliDireccion")
    private String cliDireccion;
    @Column(name = "cliEmail")
    private String cliEmail;
    @Column(name = "cliTipoCliente")
    private String cliTipoCliente;
    @Column(name = "cliDescuento")
    private Integer cliDescuento;
    @OneToMany(mappedBy = "cliNIT")
    private List<Ordenes> ordenesList;

    public Clientes() {
    }

    public Clientes(String cliNIT) {
        this.cliNIT = cliNIT;
    }

    public String getCliNIT() {
        return cliNIT;
    }

    public void setCliNIT(String cliNIT) {
        this.cliNIT = cliNIT;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliTipoCliente() {
        return cliTipoCliente;
    }

    public void setCliTipoCliente(String cliTipoCliente) {
        this.cliTipoCliente = cliTipoCliente;
    }

    public Integer getCliDescuento() {
        return cliDescuento;
    }

    public void setCliDescuento(Integer cliDescuento) {
        this.cliDescuento = cliDescuento;
    }

    @XmlTransient
    public List<Ordenes> getOrdenesList() {
        return ordenesList;
    }

    public void setOrdenesList(List<Ordenes> ordenesList) {
        this.ordenesList = ordenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliNIT != null ? cliNIT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cliNIT == null && other.cliNIT != null) || (this.cliNIT != null && !this.cliNIT.equals(other.cliNIT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Clientes[ cliNIT=" + cliNIT + " ]";
    }
    
}
