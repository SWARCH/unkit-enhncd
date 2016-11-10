/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.servlets;

import co.unkitsolutions.accessdata.dao.CustomerDAO;
import co.unkitsolutions.accessdata.dao.EmployeeDAO;
import co.unkitsolutions.accessdata.dao.UserDAO;
import co.unkitsolutions.accessdata.entity.Customer;
import co.unkitsolutions.accessdata.entity.Employee;
import co.unkitsolutions.accessdata.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static co.unkitsolutions.accessdata.entity.Customer.*;
import static co.unkitsolutions.accessdata.entity.Employee.*;
import co.unkitsolutions.businesslogic.controller.LoginLdapController;

/**
 *
 * @author mauricio
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        
        /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        }
        
    }

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.searchValidUser(usr, pwd);
        System.out.println("!!!!!!!!!!!!!!!!!!User:" + user);
        if (user != null) {
            CustomerDAO customerDAO = new CustomerDAO();
            EmployeeDAO employeeDAO = new EmployeeDAO();
            Employee employee = employeeDAO.searchById(user.getId());
            Customer customer = customerDAO.searchById(user.getId());
            // This is a fucked up way for redirect, but is sufficient for now!
            if (employee != null) {
                request.getSession().setAttribute("employee", employee);
                request.getSession().setAttribute("employeeGender", 
                        employee.getGender());
                request.getSession().setAttribute("employeeContractType", 
                        employee.getContractType());
                request.getSession().setAttribute("employeeName", 
                        employee.getName());
                if (employee.getRole().equals(MANAGER_ROLE)) {
                    request.getRequestDispatcher("/manager/indexManager.jsp")
                            .forward(request, response);
                } else if (employee.getRole().equals(MANUFACTURER_ROLE) || 
                        employee.getRole().equals(ASSEMBLER_ROLE)) {
                    request.getRequestDispatcher("/employee/indexEmployee.jsp")
                            .forward(request, response);
                }
            } else if(customer != null) {
                request.getSession().setAttribute("customer", customer);
                request.getSession().setAttribute("customerName", 
                        customer.getTradeName());
                if (customer.getType().equals(ASSEMBLER_TYPE)) {
                    request.getRequestDispatcher("/customer/assembler/"
                            + "indexAssembler.jsp")
                            .forward(request, response);
                } else if (customer.getType().equals(WHOLESALER_TYPE)) {
                    request.getRequestDispatcher("/customer/wholesaler/"
                            + "indexWholesaler.jsp")
                            .forward(request, response);
                }
                
                
            } else {
                request.setAttribute("error", 
                        "You're a user, but you are not assigned to a role");
                request.getRequestDispatcher("/login.jsp")
                        .forward(request, response);
                //request.getRequestDispatcher("/error.jsp")
                 //   .forward(request, response);
            }
        } else {
            request.setAttribute("error", "Unknown user, sign up first");
            request.getRequestDispatcher("/login.jsp")
                    .forward(request, response);
            //request.getRequestDispatcher("/error.jsp")
            //        .forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}