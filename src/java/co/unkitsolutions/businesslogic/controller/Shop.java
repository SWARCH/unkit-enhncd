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

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private VehicleDAO vehicleDAO = new VehicleDAO();
    private PartDAO partDAO = new PartDAO();
    private OrderPartDAO orderPartDAO = new OrderPartDAO();
    private OrderVehicleDAO orderVehicleDAO = new OrderVehicleDAO();
    private ProductOrderDAO productOrderDAO = new ProductOrderDAO();

    public ResponseMessage buyPart(Integer custId, Integer partId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();

        Part part = new Part();
        PartDAO partDAO = new PartDAO();
        part = partDAO.searchById(partId);

        if (part.getUnits() - quantity >= 0) {
            part.setUnits(part.getUnits() - quantity);
            partDAO.update(partId, part);
            responseMessage.setSuccess(true);
        }
        responseMessage.setData(part.getCost() * quantity);
        return responseMessage;
    }

    public ResponseMessage buyVehicle(Integer custId, Integer vehicleId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();

        Vehicle vehicle = new Vehicle();
        VehicleDAO vehicleDAO = new VehicleDAO();
        vehicle = vehicleDAO.searchById(vehicleId);

        if (vehicle.getUnits() - quantity >= 0) {
            vehicle.setUnits(vehicle.getUnits() - quantity);
            vehicleDAO.update(vehicleId, vehicle);
            responseMessage.setSuccess(true);
        }
        responseMessage.setData(vehicle.getCost() * quantity);
        return responseMessage;
    }

    public ResponseMessage buyPart_(Integer custId, Integer partId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (isValidCustomer(custId)) {
            if (isPartAvailable(partId, quantity)) {
                responseMessage.setData(makePartPurchase(custId, partId, quantity));
                responseMessage.setSuccess(true);
            } else {
                responseMessage.setSuccess(false);
                responseMessage.setErrorMessage("Invalid quantity");
            }
        } else {
            responseMessage.setSuccess(false);
            responseMessage.setErrorMessage("Invalid customer");
        }
        return responseMessage;
    }
    
    public ResponseMessage buyVehicle_(Integer custId, Integer vehicleId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (isValidCustomer(custId)) {
            if (isVehicleAvailable(vehicleId, quantity)) {
                responseMessage.setData(makeVehiclePurchase(custId, vehicleId, quantity));
                responseMessage.setSuccess(true);
            } else {
                responseMessage.setSuccess(false);
                responseMessage.setErrorMessage("Invalid quantity");
            }
        } else {
            responseMessage.setSuccess(false);
            responseMessage.setErrorMessage("Invalid customer");
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
        //return retrievedCustomer == null;
        return true;
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
        Part retrievedPart = partDAO.searchById(partId);
        Double orderCost = retrievedPart.getCost() * quantity;
        retrievedPart.setUnits(retrievedPart.getUnits() - quantity);
        partDAO.update(custId, retrievedPart);
        makePartOrder(custId, partId, quantity);
        return orderCost;
    }
    
    public void makePartOrder(Integer custId, Integer partId, Integer quantity) {
        Date today;
        String result;
        SimpleDateFormat formatter;
        
        formatter = new SimpleDateFormat("ddMMyy", Locale.US);
        today = new Date();
        String s = formatter.format(today) + custId + partId;
        System.err.println("orderId " + s);
        Integer orderId = Integer.parseInt(s);
        OrderPartPK orderPartPK = new OrderPartPK(orderId, custId, partId);
        OrderPart orderPart = new OrderPart(orderPartPK, quantity);
        orderPartDAO.create(orderPart);
    }
    
    public Double makeVehiclePurchase(Integer custId, Integer vehicleId, Integer quantity) {
        Vehicle retrievedVehicle = vehicleDAO.searchById(vehicleId);
        Double orderCost = retrievedVehicle.getCost() * quantity;
        retrievedVehicle.setUnits(retrievedVehicle.getUnits() - quantity);
        vehicleDAO.update(custId, retrievedVehicle);
        makeVehicleOrder(custId, vehicleId, quantity);
        return orderCost;
    }
    
    public void makeVehicleOrder(Integer custId, Integer vehicleId, Integer quantity) {
        Date today;
        String result;
        SimpleDateFormat formatter;
        
        formatter = new SimpleDateFormat("ddMMyy", Locale.US);
        today = new Date();
        String s = formatter.format(today) + custId + vehicleId;
        System.err.println("vehicleId " + s);
        Integer orderId = Integer.parseInt(s);
        OrderVehiclePK orderVehiclePK = new OrderVehiclePK(orderId, custId, vehicleId);
        OrderVehicle orderVehicle = new OrderVehicle(orderVehiclePK, quantity);
        orderVehicleDAO.create(orderVehicle);
    }

    

}
