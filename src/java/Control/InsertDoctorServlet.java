/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.Doctor;
import Model.DoctorDAO;
import java.util.List;

@WebServlet(urlPatterns = {"/insertDoctor"})
public class InsertDoctorServlet extends HttpServlet {

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
        if (x != null) {
            out.print("<h2> the doctor with id \'" + sDoc_id + "\' already exist </h2>");
            request.getRequestDispatcher("insertDoctor.jsp").include(request, response);
            return;
        }
        if (sDoc_id.length() ==0) {
            out.print("<h2> Doctor's id cannot be empty </h2>");
            request.getRequestDispatcher("insertDoctor.jsp").include(request, response);
            return;
        }
        if (sFullName.length() == 0) {
            out.print("<h2> Name cannot be empty </h2>");
            request.getRequestDispatcher("insertDoctor.jsp").include(request, response);
            return;
        }
        if (sAddress.length() == 0) {
            out.print("<h2> Address cannot be empty </h2>");
            request.getRequestDispatcher("insertDoctor.jsp").include(request, response);
            return;
        } 
        u.insert(sDoc_id, sFullName, sBirthday, sGender, sAddress);
        List<Doctor> lst = u.getDoctors();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listDoctor.jsp").forward(request, response);
    }
}
