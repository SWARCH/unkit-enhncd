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
import javax.validation.constraints.Size;

/**
 *
 * @author mauricio
 */
@Embeddable
public class OrderPartPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "orderId")
    private String orderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customerId")
    private String customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "partId")
    private String partId;

    public OrderPartPK() {
    }

    public OrderPartPK(String orderId, String customerId, String partId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.partId = partId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        hash += (customerId != null ? customerId.hashCode() : 0);
        hash += (partId != null ? partId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderPartPK)) {
            return false;
        }
        OrderPartPK other = (OrderPartPK) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        if ((this.partId == null && other.partId != null) || (this.partId != null && !this.partId.equals(other.partId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataAccess.entity.OrderPartPK[ orderId=" + orderId + ", customerId=" + customerId + ", partId=" + partId + " ]";
    }
    
}
