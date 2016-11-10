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
import java.io.Serializable;

/**
 *
 * @author lorenags
 */
public class CustomerController implements Serializable {
    private static final long serialVersionUID = 1L;
    public String registerCustomer(String userName, String tradeName, Integer id, String type, String password, String passwordC) {

        User user = new User();
        Customer customer = new Customer();

        user.setId(id);
        user.setPassword(password);
        user.setUsername(userName);

        customer.setUserId(id);
        customer.setTradeName(tradeName);
        customer.setType(type);

        UserDAO userDAO = new UserDAO();

        if (userDAO.searchByUsername(userName) == null) {
            if (userDAO.searchById(id) == null) {
                if (password.equals(passwordC) == true) {
                    CustomerDAO customerDAO = new CustomerDAO();
                    userDAO.create(user);
                    customerDAO.create(customer);
                    return "Su cuenta se creó exitosamente";
                } else {
                    return "Las contraseñas no coinciden";
                }
            } else {
                return "El número de identificación ya está registrado";
            }
        }else{
            return "El nombre de ususario ya existe";
        }
    }

}
