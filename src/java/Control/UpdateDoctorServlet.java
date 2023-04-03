/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Doctor;
import Model.DoctorDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/updateDoctor"})
public class UpdateDoctorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xDoc_id = request.getParameter("doc_id");
        DoctorDAO u = new DoctorDAO();
        Doctor x = u.getDoctor(xDoc_id);
        if (x == null) {
            pr.println("<h2> A doctor is not found</h2>");
            request.getRequestDispatcher("updateDoctor.jsp").include(request, response);
        } else {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateDoctor.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sDoc_id, sFullName, sAddress;
        String sBirthday;
        String sGender;
        sDoc_id = request.getParameter("doc_id").trim();
        sFullName = request.getParameter("fullname").trim();
        sAddress = request.getParameter("address").trim();
        sBirthday = request.getParameter("birthday").trim();
        sGender = request.getParameter("gender").trim();
        DoctorDAO u = new DoctorDAO();
        Doctor x = u.getDoctor(sDoc_id);
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
            request.getRequestDispatcher("updateDoctor.jsp").forward(request, response);
            return;
        }

        u.update(sDoc_id, sFullName, sBirthday, sGender, sAddress);
        List<Doctor> lst = u.getDoctors();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listDoctor.jsp").forward(request, response);
    }
}
