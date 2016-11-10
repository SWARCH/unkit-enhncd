package co.unkitsolutions.businesslogic.controller;

import co.unkitsolutions.accessdata.dao.CustomerDAO;
import co.unkitsolutions.accessdata.dao.EmployeeDAO;
import co.unkitsolutions.accessdata.dao.UserDAO;
import static co.unkitsolutions.accessdata.entity.Customer.*;
import static co.unkitsolutions.accessdata.entity.Employee.*;
import java.io.Serializable;

/**
 * A class that encapsulates the role authentication for UNKIT system.
 * @author mauricio
 */
public class RoleAuthenticator implements Serializable {
    private static final long serialVersionUID = 1L;
    public final String INDEX_MANAGER_PATH    = "/manager/indexManager.jsp";
    public final String INDEX_EMPLOYEE_PATH   = "/employee/indexEmployee.jsp";
    public final String INDEX_ASSEMBLER_PATH  = "/customer/assembler/indexAssembler.jsp";
    public final String INDEX_WHOLESALER_PATH = "/customer/wholesaler/indexWholesaler.jsp";
    
    private UserDAO userDAO = new UserDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private String attribute;

    public RoleAuthenticator() {
        
    }
    
    
}
