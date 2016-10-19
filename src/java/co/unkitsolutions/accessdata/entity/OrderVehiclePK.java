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
public class OrderVehiclePK implements Serializable {

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
    @Column(name = "vehicleId")
    private String vehicleId;

    public OrderVehiclePK() {
    }

    public OrderVehiclePK(String orderId, String customerId, String vehicleId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
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

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        hash += (customerId != null ? customerId.hashCode() : 0);
        hash += (vehicleId != null ? vehicleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderVehiclePK)) {
            return false;
        }
        OrderVehiclePK other = (OrderVehiclePK) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        if ((this.vehicleId == null && other.vehicleId != null) || (this.vehicleId != null && !this.vehicleId.equals(other.vehicleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataAccess.entity.OrderVehiclePK[ orderId=" + orderId + ", customerId=" + customerId + ", vehicleId=" + vehicleId + " ]";
    }
    
}
