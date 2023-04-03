/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.Nurse;
import Model.NurseDAO;
import java.util.List;

@WebServlet(urlPatterns = {"/insertNurse"})
public class InsertNurseServlet extends HttpServlet {

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
        if (x != null) {
            out.print("<h2> the nurse with id \'" + sNu_id + "\' already exist");
            request.getRequestDispatcher("insertNurse.jsp").include(request, response);
            return;
        }
        if (sNu_id.length() ==0) {
            out.print("<h2> Nurse's id cannot be empty");
            request.getRequestDispatcher("insertNurse.jsp").include(request, response);
            return;
        }
        if (sFullName.length() == 0) {
            out.print("<h2> Name cannot be empty");
            request.getRequestDispatcher("insertNurse.jsp").include(request, response);
            return;
        }
        if (sAddress.length() == 0) {
            out.print("<h2> Address cannot be empty");
            request.getRequestDispatcher("insertNurse.jsp").include(request, response);
            return;
        } 
        u.insert(sNu_id, sFullName, sBirthday, sGender, sAddress);
        List<Nurse> lst = u.getNurses();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listNurse.jsp").forward(request, response);
    }
}
