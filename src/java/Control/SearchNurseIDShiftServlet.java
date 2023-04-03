/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Shift;
import Model.ShiftDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchNurseIDShift"})
public class SearchNurseIDShiftServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xNu_id = request.getParameter("searchID").trim();
        ShiftDAO u = new ShiftDAO();
        List<Shift> x = u.getNurseIDShift(xNu_id);
        request.setAttribute("lst", x);
        request.setAttribute("searchID", xNu_id);
        request.getRequestDispatcher("listShift.jsp").forward(request, response);
    }

}
