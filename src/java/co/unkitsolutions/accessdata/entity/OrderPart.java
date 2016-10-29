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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauricio
 */
@Entity
@Table(name = "OrderPart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderPart.findAll", query = "SELECT o FROM OrderPart o"),
    @NamedQuery(name = "OrderPart.findByOrderId", query = "SELECT o FROM OrderPart o WHERE o.orderPartPK.orderId = :orderId"),
    @NamedQuery(name = "OrderPart.findByCustomerId", query = "SELECT o FROM OrderPart o WHERE o.orderPartPK.customerId = :customerId"),
    @NamedQuery(name = "OrderPart.findByPartId", query = "SELECT o FROM OrderPart o WHERE o.orderPartPK.partId = :partId"),
    @NamedQuery(name = "OrderPart.findByQuantity", query = "SELECT o FROM OrderPart o WHERE o.quantity = :quantity")})
public class OrderPart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderPartPK orderPartPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumns({
        @JoinColumn(name = "orderId", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ProductOrder productOrder;
    @JoinColumn(name = "partId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Part part;

    public OrderPart() {
    }

    public OrderPart(OrderPartPK orderPartPK) {
        this.orderPartPK = orderPartPK;
    }

    public OrderPart(OrderPartPK orderPartPK, int quantity) {
        this.orderPartPK = orderPartPK;
        this.quantity = quantity;
    }

    public OrderPart(int orderId, int customerId, int partId) {
        this.orderPartPK = new OrderPartPK(orderId, customerId, partId);
    }

    public OrderPartPK getOrderPartPK() {
        return orderPartPK;
    }

    public void setOrderPartPK(OrderPartPK orderPartPK) {
        this.orderPartPK = orderPartPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderPartPK != null ? orderPartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderPart)) {
            return false;
        }
        OrderPart other = (OrderPart) object;
        if ((this.orderPartPK == null && other.orderPartPK != null) || (this.orderPartPK != null && !this.orderPartPK.equals(other.orderPartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unkitsolutions.accessdata.entity.OrderPart[ orderPartPK=" + orderPartPK + " ]";
    }
    
}
