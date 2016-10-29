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
public class OrderVehiclePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "orderId")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customerId")
    private int customerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicleId")
    private int vehicleId;

    public OrderVehiclePK() {
    }

    public OrderVehiclePK(int orderId, int customerId, int vehicleId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
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

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderId;
        hash += (int) customerId;
        hash += (int) vehicleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderVehiclePK)) {
            return false;
        }
        OrderVehiclePK other = (OrderVehiclePK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.vehicleId != other.vehicleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unkitsolutions.accessdata.entity.OrderVehiclePK[ orderId=" + orderId + ", customerId=" + customerId + ", vehicleId=" + vehicleId + " ]";
    }
    
}
