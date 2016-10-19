/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauricio
 */
@Entity
@Table(name = "OrderVehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderVehicle.findAll", query = "SELECT o FROM OrderVehicle o"),
    @NamedQuery(name = "OrderVehicle.findByOrderId", query = "SELECT o FROM OrderVehicle o WHERE o.orderVehiclePK.orderId = :orderId"),
    @NamedQuery(name = "OrderVehicle.findByCustomerId", query = "SELECT o FROM OrderVehicle o WHERE o.orderVehiclePK.customerId = :customerId"),
    @NamedQuery(name = "OrderVehicle.findByVehicleId", query = "SELECT o FROM OrderVehicle o WHERE o.orderVehiclePK.vehicleId = :vehicleId")})
public class OrderVehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderVehiclePK orderVehiclePK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "quantity")
    private String quantity;
    @JoinColumns({
        @JoinColumn(name = "orderId", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ProductOrder productOrder;
    @JoinColumn(name = "vehicleId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vehicle vehicle;

    public OrderVehicle() {
    }

    public OrderVehicle(OrderVehiclePK orderVehiclePK) {
        this.orderVehiclePK = orderVehiclePK;
    }

    public OrderVehicle(OrderVehiclePK orderVehiclePK, String quantity) {
        this.orderVehiclePK = orderVehiclePK;
        this.quantity = quantity;
    }

    public OrderVehicle(String orderId, String customerId, String vehicleId) {
        this.orderVehiclePK = new OrderVehiclePK(orderId, customerId, vehicleId);
    }

    public OrderVehiclePK getOrderVehiclePK() {
        return orderVehiclePK;
    }

    public void setOrderVehiclePK(OrderVehiclePK orderVehiclePK) {
        this.orderVehiclePK = orderVehiclePK;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderVehiclePK != null ? orderVehiclePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderVehicle)) {
            return false;
        }
        OrderVehicle other = (OrderVehicle) object;
        if ((this.orderVehiclePK == null && other.orderVehiclePK != null) || (this.orderVehiclePK != null && !this.orderVehiclePK.equals(other.orderVehiclePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataAccess.entity.OrderVehicle[ orderVehiclePK=" + orderVehiclePK + " ]";
    }
    
}
