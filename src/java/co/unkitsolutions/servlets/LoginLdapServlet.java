package co.unkitsolutions.servlets;

import co.unkitsolutions.businesslogic.controller.LoginLdapController;
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
public class LoginLdapServlet extends HttpServlet implements Serializable {
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
             out.println("<title>Servlet LoginLdapServlet</title>");
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Servlet LoginLdapServlet at " + request.getContextPath() + "</h1>");
             out.println("</body>");
             out.println("</html>");  */
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
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");

        LoginLdapController loginLdap = new LoginLdapController();

        String message = loginLdap.login(usr, pwd);

        request.setAttribute("error", message);
        request.getRequestDispatcher("/loginLdap.jsp")
                .forward(request, response);
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
