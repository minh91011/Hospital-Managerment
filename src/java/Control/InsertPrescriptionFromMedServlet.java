/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Patient;
import Model.PatientDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.Prescription;
import Model.PrescriptionDAO;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/insertPrescriptionFromMed"})
public class InsertPrescriptionFromMedServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String sPa_id, sMed_id, sTime;
        sPa_id = request.getParameter("pa_id");
        sMed_id = request.getParameter("med_id").trim();
        sTime = request.getParameter("time");
        PrescriptionDAO u = new PrescriptionDAO();
        u.insert(sPa_id, sMed_id, sTime);

        request.setAttribute("pa_id", sPa_id);
        request.getRequestDispatcher("insertPrescription.jsp").forward(request, response);

    }

}
