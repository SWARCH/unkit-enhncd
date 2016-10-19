/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauricio
 */
@Entity
@Table(name = "Order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductOrder.findAll", query = "SELECT p FROM ProductOrder p"),
    @NamedQuery(name = "ProductOrder.findById", query = "SELECT p FROM ProductOrder p WHERE p.productOrderPK.id = :id"),
    @NamedQuery(name = "ProductOrder.findByOrderCost", query = "SELECT p FROM ProductOrder p WHERE p.orderCost = :orderCost"),
    @NamedQuery(name = "ProductOrder.findByDate", query = "SELECT p FROM ProductOrder p WHERE p.date = :date"),
    @NamedQuery(name = "ProductOrder.findByDeliveryDate", query = "SELECT p FROM ProductOrder p WHERE p.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "ProductOrder.findByCustomerId", query = "SELECT p FROM ProductOrder p WHERE p.productOrderPK.customerId = :customerId")})
public class ProductOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductOrderPK productOrderPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "orderCost")
    private Double orderCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "deliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @JoinColumn(name = "customerId", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productOrder")
    private Collection<OrderVehicle> orderVehicleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productOrder")
    private Collection<OrderPart> orderPartCollection;

    public ProductOrder() {
    }

    public ProductOrder(ProductOrderPK productOrderPK) {
        this.productOrderPK = productOrderPK;
    }

    public ProductOrder(ProductOrderPK productOrderPK, Date date) {
        this.productOrderPK = productOrderPK;
        this.date = date;
    }

    public ProductOrder(String id, String customerId) {
        this.productOrderPK = new ProductOrderPK(id, customerId);
    }

    public ProductOrderPK getProductOrderPK() {
        return productOrderPK;
    }

    public void setProductOrderPK(ProductOrderPK productOrderPK) {
        this.productOrderPK = productOrderPK;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @XmlTransient
    public Collection<OrderVehicle> getOrderVehicleCollection() {
        return orderVehicleCollection;
    }

    public void setOrderVehicleCollection(Collection<OrderVehicle> orderVehicleCollection) {
        this.orderVehicleCollection = orderVehicleCollection;
    }

    @XmlTransient
    public Collection<OrderPart> getOrderPartCollection() {
        return orderPartCollection;
    }

    public void setOrderPartCollection(Collection<OrderPart> orderPartCollection) {
        this.orderPartCollection = orderPartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productOrderPK != null ? productOrderPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductOrder)) {
            return false;
        }
        ProductOrder other = (ProductOrder) object;
        if ((this.productOrderPK == null && other.productOrderPK != null) || (this.productOrderPK != null && !this.productOrderPK.equals(other.productOrderPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataAccess.entity.ProductOrder[ productOrderPK=" + productOrderPK + " ]";
    }
    
}
