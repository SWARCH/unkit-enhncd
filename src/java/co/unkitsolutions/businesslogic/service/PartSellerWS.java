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
@WebService(serviceName = "PartSellerWS")
public class PartSellerWS {

    @WebMethod(operationName = "buyPart")
    public ResponseMessage buyPart(Integer custId, Integer partId, Integer quantity) {
        System.out.println("Web Service: custId =" + custId + ", partId =" + partId + ", q = " + quantity);
        Shop shop = new Shop();
        ResponseMessage success = shop.buyPart(custId, partId, quantity);
        System.out.println("ResponseMessage = " + success.isSuccess());
        return success;
    }
}
