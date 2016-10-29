/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mauricio
 */
@Embeddable
public class OrderPartPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "orderId")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customerId")
    private int customerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partId")
    private int partId;

    public OrderPartPK() {
    }

    public OrderPartPK(int orderId, int customerId, int partId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.partId = partId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderId;
        hash += (int) customerId;
        hash += (int) partId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderPartPK)) {
            return false;
        }
        OrderPartPK other = (OrderPartPK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.partId != other.partId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unkitsolutions.accessdata.entity.OrderPartPK[ orderId=" + orderId + ", customerId=" + customerId + ", partId=" + partId + " ]";
    }
    
}
