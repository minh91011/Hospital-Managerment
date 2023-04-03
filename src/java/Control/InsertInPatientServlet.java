/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.InPatientDAO;
import Model.Patient;
import Model.PatientDAO;

@WebServlet(urlPatterns = {"/insertInPatient"})
public class InsertInPatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sPa_id, sRoom_id;
        sPa_id = request.getParameter("pa_id").trim();
        sRoom_id = request.getParameter("room_id").trim();
        InPatientDAO u = new InPatientDAO();
        u.insert(sPa_id, sRoom_id);
        
        response.sendRedirect("listRoom.jsp");
    }

}
