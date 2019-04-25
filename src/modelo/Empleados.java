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
import javax.persistence.Id;
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
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByEmpDni", query = "SELECT e FROM Empleados e WHERE e.empDni = :empDni")
    , @NamedQuery(name = "Empleados.findByEmpNombre", query = "SELECT e FROM Empleados e WHERE e.empNombre = :empNombre")
    , @NamedQuery(name = "Empleados.findByEmpApellido", query = "SELECT e FROM Empleados e WHERE e.empApellido = :empApellido")
    , @NamedQuery(name = "Empleados.findByEmpGenero", query = "SELECT e FROM Empleados e WHERE e.empGenero = :empGenero")
    , @NamedQuery(name = "Empleados.findByEmpFechaNacimiento", query = "SELECT e FROM Empleados e WHERE e.empFechaNacimiento = :empFechaNacimiento")
    , @NamedQuery(name = "Empleados.findByEmpFechaContratacion", query = "SELECT e FROM Empleados e WHERE e.empFechaContratacion = :empFechaContratacion")
    , @NamedQuery(name = "Empleados.findByEmpSalario", query = "SELECT e FROM Empleados e WHERE e.empSalario = :empSalario")
    , @NamedQuery(name = "Empleados.findByEmpCargo", query = "SELECT e FROM Empleados e WHERE e.empCargo = :empCargo")
    , @NamedQuery(name = "Empleados.findByEmpFechaDespido", query = "SELECT e FROM Empleados e WHERE e.empFechaDespido = :empFechaDespido")})
public class Empleados implements Serializable {

    @OneToMany(mappedBy = "empDni")
    private List<Cuentas> cuentasList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "empDni")
    private Integer empDni;
    @Column(name = "empNombre")
    private String empNombre;
    @Column(name = "empApellido")
    private String empApellido;
    @Column(name = "empGenero")
    private Character empGenero;
    @Column(name = "empFechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date empFechaNacimiento;
    @Column(name = "empFechaContratacion")
    @Temporal(TemporalType.DATE)
    private Date empFechaContratacion;
    @Column(name = "empSalario")
    private Integer empSalario;
    @Column(name = "empCargo")
    private String empCargo;
    @Column(name = "empFechaDespido")
    @Temporal(TemporalType.DATE)
    private Date empFechaDespido;
    @OneToMany(mappedBy = "empDni")
    private List<Observaciones> observacionesList;

    public Empleados() {
    }

    public Empleados(Integer empDni) {
        this.empDni = empDni;
    }

    public Integer getEmpDni() {
        return empDni;
    }

    public void setEmpDni(Integer empDni) {
        this.empDni = empDni;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpApellido() {
        return empApellido;
    }

    public void setEmpApellido(String empApellido) {
        this.empApellido = empApellido;
    }

    public Character getEmpGenero() {
        return empGenero;
    }

    public void setEmpGenero(Character empGenero) {
        this.empGenero = empGenero;
    }

    public Date getEmpFechaNacimiento() {
        return empFechaNacimiento;
    }

    public void setEmpFechaNacimiento(Date empFechaNacimiento) {
        this.empFechaNacimiento = empFechaNacimiento;
    }

    public Date getEmpFechaContratacion() {
        return empFechaContratacion;
    }

    public void setEmpFechaContratacion(Date empFechaContratacion) {
        this.empFechaContratacion = empFechaContratacion;
    }

    public Integer getEmpSalario() {
        return empSalario;
    }

    public void setEmpSalario(Integer empSalario) {
        this.empSalario = empSalario;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }

    public Date getEmpFechaDespido() {
        return empFechaDespido;
    }

    public void setEmpFechaDespido(Date empFechaDespido) {
        this.empFechaDespido = empFechaDespido;
    }

    @XmlTransient
    public List<Observaciones> getObservacionesList() {
        return observacionesList;
    }

    public void setObservacionesList(List<Observaciones> observacionesList) {
        this.observacionesList = observacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empDni != null ? empDni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.empDni == null && other.empDni != null) || (this.empDni != null && !this.empDni.equals(other.empDni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleados[ empDni=" + empDni + " ]";
    }

    @XmlTransient
    public List<Cuentas> getCuentasList() {
        return cuentasList;
    }

    public void setCuentasList(List<Cuentas> cuentasList) {
        this.cuentasList = cuentasList;
    }
    
}
