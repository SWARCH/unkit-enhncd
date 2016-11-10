package co.unkitsolutions.servlets;

import co.unkitsolutions.accessdata.dao.PartDAO;
import co.unkitsolutions.accessdata.entity.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mauricio
 */
@WebServlet(name = "PosAddPart", urlPatterns = {"/posAddPart"})
public class PosAddPart extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer q;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PosAddPart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PosAddPart at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        System.out.println("Enter pos add");
        PartDAO partDAO = new PartDAO();
        List<Part> partsToBuy = (ArrayList<Part>) request.getSession().getAttribute("partsToBuy");
        List<Part> allParts = partDAO.searchAll();
        
        System.out.println("partsToBuy " + partsToBuy);
        System.out.println("allParts " + allParts);
        
        int index = Integer.parseInt(request.getParameter("index"));
        System.out.println("index = " + index);
        Part buyedPart = allParts.get(index);
        
        if (!partsToBuy.contains(buyedPart))
            partsToBuy.add(buyedPart);
        System.out.println("partsToBuy" + partsToBuy);
        buyedPart.setUnits(buyedPart.getUnits() - 1); // To correct later
        request.getRequestDispatcher("/customer/assembler/partsShop.jsp")
                .forward(request, response);
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
        q = Integer.parseInt(request.getParameter("quantity"));
        
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
