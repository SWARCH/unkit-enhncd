/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.servlets;

import co.unkitsolutions.businesslogic.controller.PartController;
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
public class AddPartServlet extends HttpServlet implements Serializable {

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
             out.println("<title>Servlet AddPartServlet</title>");            
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Servlet AddPartServlet at " + request.getContextPath() + "</h1>");
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
        System.out.println("ESTOY EN DOGET________________________ADD PART SERVLET");

        int idPart = Integer.parseInt(request.getParameter("idPart"));
        System.out.println("idPart = " + idPart);

        PartController partController = new PartController();

        if (partController.deletePart(idPart) == true) {
            request.setAttribute("error", "La parte de referencia " + idPart + " se ha eliminado correctamente");
            request.getRequestDispatcher("/manager/mgmtProducts/updatePart.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("error", "Ocurrió un error, verifique la información");
            request.getRequestDispatcher("/manager/mgmtProducts/updatePart.jsp")
                    .forward(request, response);
        }
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

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String cost = request.getParameter("cost");
        String units = request.getParameter("units");

        PartController part = new PartController();

        int idPart = part.updatePart(name, description, cost, units);

        if (idPart != 0) {
            request.setAttribute("error", "Se agregó la parte exitosamente, el número de referencia es:" + idPart);
            request.getRequestDispatcher("/manager/mgmtProducts/addPart.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("error", "Ocurrió un error, verifique la información");
            request.getRequestDispatcher("/manager/mgmtProducts/addPart.jsp")
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
