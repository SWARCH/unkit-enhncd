/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.businesslogic.service;

import co.unkitsolutions.businesslogic.controller.ResponseMessage;
import co.unkitsolutions.businesslogic.controller.Shop;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author mauricio
 */
@WebService(serviceName = "VehicleSellerWS")
public class VehicleSellerWS {

    @WebMethod(operationName = "buyVehicle")
    public ResponseMessage buyVehicle(Integer custId, Integer vehicleId, Integer quantity) {
        Shop shop = new Shop();
        System.out.println("Web Service: custId =" + custId + ", partId =" + vehicleId + ", q = " + quantity);
        ResponseMessage success = shop.buyVehicle(custId, vehicleId, quantity); 
        System.out.println("ResponseMessage = " + success.isSuccess());
        return success; 
    }
    
    
        
}
