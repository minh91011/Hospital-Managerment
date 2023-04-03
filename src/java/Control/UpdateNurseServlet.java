/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Nurse;
import Model.NurseDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/updateNurse"})
public class UpdateNurseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xNu_id = request.getParameter("nu_id");
        NurseDAO u = new NurseDAO();
        Nurse x = u.getNurse(xNu_id);
        if (x == null) {
            pr.println("<h2> A nurse is not found</h2>");
            request.getRequestDispatcher("updateNurse.jsp").include(request, response);
        } else {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateNurse.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sNu_id, sFullName, sAddress;
        String sBirthday;
        String sGender;
        sNu_id = request.getParameter("nu_id").trim();
        sFullName = request.getParameter("fullname").trim();
        sAddress = request.getParameter("address").trim();
        sBirthday = request.getParameter("birthday").trim();
        sGender = request.getParameter("gender").trim();
        NurseDAO u = new NurseDAO();
        Nurse x = u.getNurse(sNu_id);
        boolean isOk = true;
        if (sFullName.length() == 0 || "Invalid name".equals(sFullName)) {
            x.setFullName("Invalid name");
            isOk = false;
        }
        if (sAddress.length() == 0 || "Invalid address".equals(sAddress)) {
            x.setAddress("Invalid address");
            isOk = false;
        }

        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateNurse.jsp").forward(request, response);
            return;
        }

        u.update(sNu_id, sFullName, sBirthday, sGender, sAddress);
        List<Nurse> lst = u.getNurses();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listNurse.jsp").forward(request, response);
    }
}
