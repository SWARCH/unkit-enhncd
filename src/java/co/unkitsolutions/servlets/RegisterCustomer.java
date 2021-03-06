/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.servlets;

import co.unkitsolutions.businesslogic.controller.CustomerController;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lorenags
 */
@WebServlet(name = "RegisterCustomer", urlPatterns = {"/RegisterCustomer"})
public class RegisterCustomer extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;

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
            /* out.println("<!DOCTYPE html>");
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Servlet RegisterCustomer</title>");            
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Servlet RegisterCustomer at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String usr = request.getParameter("user");
        String tradeName = request.getParameter("tradeName");
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String password = request.getParameter("password");
        String passwordC = request.getParameter("passwordC");

        CustomerController customer = new CustomerController();
        String message = customer.registerCustomer(usr, tradeName, Integer.parseInt(id), type, password, passwordC);

        if (message.equals("Su cuenta se creó exitosamente")) {
            request.getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("error", message);
            request.getRequestDispatcher("/registerCustomer.jsp")
                    .forward(request, response);
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
