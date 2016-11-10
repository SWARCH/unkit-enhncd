/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.servlets;

import co.unkitsolutions.businesslogic.controller.VehicleController;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lorenags
 */
public class AddVehicleServlet extends HttpServlet implements Serializable {
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
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddVehicleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddVehicleServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        String tradeMark = request.getParameter("tradeMark");
        String model = request.getParameter("model");
        String description = request.getParameter("description");
        String color = request.getParameter("color");
        String cost = request.getParameter("cost");
        String units = request.getParameter("units");
        
        VehicleController vehicle= new VehicleController();
                
        int idVehicle = vehicle.addVehicle(tradeMark,model,description,color,cost,units);
        
        if (idVehicle != 0){
            request.setAttribute("error", "Se agregó el vehículo exitosamente, el número de referencia es:" + idVehicle);
            request.getRequestDispatcher("/manager/mgmtProducts/addVehicle.jsp")
                    .forward(request, response);
        }else{
            request.setAttribute("error", "Ocurrió un error, verifique la información");
            request.getRequestDispatcher("/manager/mgmtProducts/addVehicle.jsp")
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
