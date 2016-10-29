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
@WebService(serviceName = "ShopWS")
public class ShopWS {

    @WebMethod(operationName = "buyPart")
    public ResponseMessage buyPart(Integer custId, Integer partId, Integer quantity) {
        Shop shop = new Shop();
        return shop.buyPart(custId, partId, quantity);
    }
    
    @WebMethod(operationName = "buyVehicle")
    public ResponseMessage buyVehicle(Integer custId, Integer vehicleId, Integer quantity) {
        Shop shop = new Shop();
        return shop.buyVehicle(custId, vehicleId, quantity);
    }
    
    
}
