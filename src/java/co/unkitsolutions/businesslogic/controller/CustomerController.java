/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.businesslogic.controller;

import co.unkitsolutions.accessdata.dao.CustomerDAO;
import co.unkitsolutions.accessdata.dao.UserDAO;
import co.unkitsolutions.accessdata.entity.Customer;
import co.unkitsolutions.accessdata.entity.User;

/**
 *
 * @author lorenags
 */
public class CustomerController {
    
    public void registerCustomer(String userName, String tradeName, String id, String type, String password){
        
        User user=new User();
        Customer customer = new Customer();
        
        user.setId(id);
        user.setPassword(password);
        user.setUsername(userName);
        
        customer.setUserId(id);
        customer.setTradeName(tradeName);
        customer.setType(type);
        
        UserDAO userDAO = new UserDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        
        userDAO.create(user);
        customerDAO.create(customer);
        
    }
    
}
