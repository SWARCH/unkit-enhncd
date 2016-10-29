/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauricio
 */
@Entity
@Table(name = "Vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id"),
    @NamedQuery(name = "Vehicle.findByTrademark", query = "SELECT v FROM Vehicle v WHERE v.trademark = :trademark"),
    @NamedQuery(name = "Vehicle.findByModel", query = "SELECT v FROM Vehicle v WHERE v.model = :model"),
    @NamedQuery(name = "Vehicle.findByDescription", query = "SELECT v FROM Vehicle v WHERE v.description = :description"),
    @NamedQuery(name = "Vehicle.findByColor", query = "SELECT v FROM Vehicle v WHERE v.color = :color"),
    @NamedQuery(name = "Vehicle.findByCost", query = "SELECT v FROM Vehicle v WHERE v.cost = :cost"),
    @NamedQuery(name = "Vehicle.findByUnits", query = "SELECT v FROM Vehicle v WHERE v.units = :units")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "trademark")
    private String trademark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "model")
    private int model;
    @Size(max = 300)
    @Column(name = "description")
    private String description;
    @Size(max = 25)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @Column(name = "units")
    private Integer units;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private List<OrderVehicle> orderVehicleList;

    public Vehicle() {
    }

    public Vehicle(Integer id) {
        this.id = id;
    }

    public Vehicle(Integer id, String trademark, int model, double cost) {
        this.id = id;
        this.trademark = trademark;
        this.model = model;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    @XmlTransient
    public List<OrderVehicle> getOrderVehicleList() {
        return orderVehicleList;
    }

    public void setOrderVehicleList(List<OrderVehicle> orderVehicleList) {
        this.orderVehicleList = orderVehicleList;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unkitsolutions.accessdata.entity.Vehicle[ id=" + id + " ]";
    }
    
}
