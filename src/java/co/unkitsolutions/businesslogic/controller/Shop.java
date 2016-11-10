package co.unkitsolutions.businesslogic.controller;

import co.unkitsolutions.accessdata.dao.CustomerDAO;
import co.unkitsolutions.accessdata.dao.OrderVehicleDAO;
import co.unkitsolutions.accessdata.dao.PartDAO;
import co.unkitsolutions.accessdata.dao.ProductOrderDAO;
import co.unkitsolutions.accessdata.dao.VehicleDAO;
import co.unkitsolutions.accessdata.entity.Customer;
import co.unkitsolutions.accessdata.entity.OrderPart;
import co.unkitsolutions.accessdata.entity.OrderVehicle;
import co.unkitsolutions.accessdata.entity.OrderVehiclePK;
import co.unkitsolutions.accessdata.entity.Part;
import co.unkitsolutions.accessdata.entity.ProductOrder;
import co.unkitsolutions.accessdata.entity.ProductOrderPK;
import co.unkitsolutions.accessdata.entity.Vehicle;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class encapsulates de buying logic for <code>Part</code>s and
 * <code>Vehicle</code>s.
 *
 * @author mauricio
 */
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    
    public ResponseMessage buyPart(Integer custId, Integer partId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();
        
        Part part = new Part();
        PartDAO partDAO = new PartDAO();
        part = partDAO.searchById(partId);
        
        if (part.getUnits() - quantity >= 0){
               part.setUnits(part.getUnits() - quantity);
                partDAO.update(partId, part);
            responseMessage.setSuccess(true);
        }
        responseMessage.setData(part.getCost()*quantity);
        return responseMessage ;
    }
    
    public ResponseMessage buyVehicle(Integer custId, Integer vehicleId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();
        
        Vehicle vehicle = new Vehicle();
        VehicleDAO vehicleDAO = new VehicleDAO();
        vehicle = vehicleDAO.searchById(vehicleId);
        
        if (vehicle.getUnits() - quantity >= 0){
               vehicle.setUnits(vehicle.getUnits() - quantity);
                vehicleDAO.update(vehicleId, vehicle);
            responseMessage.setSuccess(true);
        }
        responseMessage.setData(vehicle.getCost()*quantity);
        return responseMessage;
    }

    public ResponseMessage buyPart_(Integer custId, Integer partId, Integer quantity) {
        ResponseMessage responseMessage = new ResponseMessage();
        
        Part part = new Part();
        PartDAO partDAO = new PartDAO();
        part = partDAO.searchById(partId);
        
        if (part.getUnits() - quantity >= 0){
            ProductOrder order = new ProductOrder();
            ProductOrderDAO orderDAO = new ProductOrderDAO();
            ProductOrderPK productOrderPK = new ProductOrderPK();
            productOrderPK.setCustomerId(custId);
            productOrderPK.setId(partId);
            order.setProductOrderPK(productOrderPK);
            Customer cx = new Customer();
            CustomerDAO cxDAO = new CustomerDAO();
            cx = cxDAO.searchById(custId);
            order.setCustomer(cx);
            order.setDate(new Date());
            order.setDeliveryDate(this.addDays(new Date()));
            order.setOrderCost(quantity * part.getCost());
            new ArrayList<OrderPart>();
           // order.setOrderPartList();
            
            responseMessage.setSuccess(orderDAO.create(order));
            if (responseMessage.isSuccess()) {
                part.setUnits(part.getUnits() - quantity);
                partDAO.update(partId, part);
            }
        } else {
            responseMessage.setSuccess(false);
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

    }
