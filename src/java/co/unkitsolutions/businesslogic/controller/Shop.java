package co.unkitsolutions.businesslogic.controller;

import co.unkitsolutions.accessdata.dao.CustomerDAO;
import co.unkitsolutions.accessdata.dao.EmployeeDAO;
import co.unkitsolutions.accessdata.dao.OrderPartDAO;
import co.unkitsolutions.accessdata.dao.OrderVehicleDAO;
import co.unkitsolutions.accessdata.dao.PartDAO;
import co.unkitsolutions.accessdata.dao.ProductOrderDAO;
import co.unkitsolutions.accessdata.dao.UserDAO;
import co.unkitsolutions.accessdata.dao.VehicleDAO;
import co.unkitsolutions.accessdata.entity.Customer;
import co.unkitsolutions.accessdata.entity.OrderPart;
import co.unkitsolutions.accessdata.entity.OrderPartPK;
import co.unkitsolutions.accessdata.entity.OrderVehicle;
import co.unkitsolutions.accessdata.entity.OrderVehiclePK;
import co.unkitsolutions.accessdata.entity.Part;
import co.unkitsolutions.accessdata.entity.ProductOrder;
import co.unkitsolutions.accessdata.entity.ProductOrderPK;
import co.unkitsolutions.accessdata.entity.Vehicle;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * This class encapsulates de buying logic for <code>Part</code>s and
 * <code>Vehicle</code>s.
 *
 * @author mauricio
 */
public class Shop implements Serializable {
    public final String SUCCESS_MESSAGE = "Compra realizada con éxito";
    public final String BAD_QUANTITY_MESSAGE = "La cantidad ingresada es erronea";
    public final String BAD_CUSTOMER_MESSAGE = "Usuario invalido";

    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO = new CustomerDAO();
    private VehicleDAO vehicleDAO = new VehicleDAO();
    private PartDAO partDAO = new PartDAO();
    private OrderPartDAO orderPartDAO = new OrderPartDAO();
    private OrderVehicleDAO orderVehicleDAO = new OrderVehicleDAO();
    
    public Shop() {
        
    }

    public ResponseMessage buyPart(Integer custId, Integer partId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (isValidCustomer(custId)) {
            if (isPartAvailable(partId, quantity)) {
                responseMessage.setData(makePartPurchase(custId, partId, quantity));
                responseMessage.setSuccess(true);
                responseMessage.setErrorMessage(SUCCESS_MESSAGE);
            } else {
                responseMessage.setSuccess(false);
                responseMessage.setErrorMessage(BAD_QUANTITY_MESSAGE);
            }
        } else {
            responseMessage.setSuccess(false);
            responseMessage.setErrorMessage(BAD_CUSTOMER_MESSAGE);
        }
        return responseMessage;
    }
    
    public ResponseMessage buyVehicle(Integer custId, Integer vehicleId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (isValidCustomer(custId)) {
            if (isVehicleAvailable(vehicleId, quantity)) {
                responseMessage.setData(makeVehiclePurchase(custId, vehicleId, quantity));
                responseMessage.setSuccess(true);
                responseMessage.setErrorMessage(SUCCESS_MESSAGE);
            } else {
                responseMessage.setSuccess(false);
                responseMessage.setErrorMessage(BAD_QUANTITY_MESSAGE);
            }
        } else {
            responseMessage.setSuccess(false);
            responseMessage.setErrorMessage(BAD_CUSTOMER_MESSAGE);
        }
        return responseMessage;
    }

    public Date addDays(Date date) {
        int delivaryDays = 5;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, delivaryDays);
        return calendar.getTime();
    }

    public boolean isValidCustomer(Integer custId) {
        Customer retrievedCustomer = customerDAO.searchById(custId);
        return retrievedCustomer != null;
    }

    public boolean isPartAvailable(Integer partId, Integer quantity) {
        Part retrievedPart = partDAO.searchById(partId);
        Integer stock = retrievedPart.getUnits();
        return quantity > 0 && quantity < stock;
    }

    public boolean isVehicleAvailable(Integer vehicleId, Integer quantity) {
        Vehicle retrievedVehicle = vehicleDAO.searchById(vehicleId);
        Integer stock = retrievedVehicle.getUnits();
        return quantity > 0 && quantity < stock;
    }

    public Double makePartPurchase(Integer custId, Integer partId, Integer quantity) {
        //ProductOrderPK productOrderPK = new ProductOrderPK(partId.hashCode(), custId);
        //ProductOrder productOrder = new ProductOrder(productOrderPK, new Date());
        //productOrderDAO.create(productOrder);
        
        Part retrievedPart = partDAO.searchById(partId);
        retrievedPart.setUnits(retrievedPart.getUnits() - quantity);
        partDAO.update(custId, retrievedPart);
        //makePartOrder(custId, partId, quantity);
        return retrievedPart.getCost() * quantity;
    }
    
    public void makePartOrder(Integer custId, Integer partId, Integer quantity) {
        OrderPartPK orderPartPK = new OrderPartPK(partId.hashCode(), custId, partId);
        OrderPart orderPart = new OrderPart(orderPartPK, quantity);
        orderPartDAO.create(orderPart);
    }
    
    public Double makeVehiclePurchase(Integer custId, Integer vehicleId, Integer quantity) {
        //ProductOrderPK productOrderPK = new ProductOrderPK(vehicleId.hashCode(), custId);
        //ProductOrder productOrder = new ProductOrder(productOrderPK, new Date());
        //productOrderDAO.create(productOrder);
        Vehicle retrievedVehicle = vehicleDAO.searchById(vehicleId);
        retrievedVehicle.setUnits(retrievedVehicle.getUnits() - quantity);
        vehicleDAO.update(custId, retrievedVehicle);
        //makeVehicleOrder(custId, vehicleId, quantity);
        return retrievedVehicle.getCost() * quantity;
    }
    
    public void makeVehicleOrder(Integer custId, Integer vehicleId, Integer quantity) {
        OrderVehiclePK orderVehiclePK = new OrderVehiclePK(vehicleId.hashCode(), custId, vehicleId);
        OrderVehicle orderVehicle = new OrderVehicle(orderVehiclePK, quantity);
        orderVehicleDAO.create(orderVehicle);
    }

}
