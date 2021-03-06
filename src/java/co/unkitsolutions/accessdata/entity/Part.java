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
@Table(name = "Part")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Part.findAll", query = "SELECT p FROM Part p"),
    @NamedQuery(name = "Part.findById", query = "SELECT p FROM Part p WHERE p.id = :id"),
    @NamedQuery(name = "Part.findByName", query = "SELECT p FROM Part p WHERE p.name = :name"),
    @NamedQuery(name = "Part.findByDescription", query = "SELECT p FROM Part p WHERE p.description = :description"),
    @NamedQuery(name = "Part.findByCost", query = "SELECT p FROM Part p WHERE p.cost = :cost"),
    @NamedQuery(name = "Part.findByUnits", query = "SELECT p FROM Part p WHERE p.units = :units")})
public class Part implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 300)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @Column(name = "units")
    private Integer units;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "part")
    private List<OrderPart> orderPartList;

    public Part() {
    }

    public Part(Integer id) {
        this.id = id;
    }

    public Part(Integer id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public List<OrderPart> getOrderPartList() {
        return orderPartList;
    }

    public void setOrderPartList(List<OrderPart> orderPartList) {
        this.orderPartList = orderPartList;
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
        if (!(object instanceof Part)) {
            return false;
        }
        Part other = (Part) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unkitsolutions.accessdata.entity.Part[ id=" + id + " ]";
    }
    
}
