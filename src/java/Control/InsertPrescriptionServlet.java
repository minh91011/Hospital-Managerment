/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Med;
import Model.MedDAO;
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

@WebServlet(urlPatterns = {"/insertPrescription"})
public class InsertPrescriptionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sPa_id, sMed_id, sTime;
        sPa_id = request.getParameter("pa_id");
        sMed_id = request.getParameter("med_id").trim();
        sTime = request.getParameter("time");
        PrescriptionDAO u = new PrescriptionDAO();
        PatientDAO up = new PatientDAO();

        
        MedDAO nu = new MedDAO();
        Med m = nu.getMedId(sMed_id);
        if (m == null) {
            out.print("<h2> the medicine with id \'" + sMed_id + "\' not exist");
            request.getRequestDispatcher("insertPrescription.jsp").include(request, response);
            return;
        }
        if (sMed_id.length() == 0) {
            out.print("<h2> Medicine 's id cannot be empty");
            request.getRequestDispatcher("insertPrescription.jsp").include(request, response);
            return;
        }
        u.insert(sPa_id, sMed_id, sTime);
        List<Prescription> lst = up.getPrescriptionFromPatient(sPa_id);
        String room = up.getRoomFromPatient(sPa_id);
        Patient x = up.getPatientId(sPa_id);
        request.setAttribute("lst", lst);
        request.setAttribute("x", x);
        request.setAttribute("room", room);
        request.getRequestDispatcher("patientInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String pa_id = request.getParameter("pa_id");
        request.setAttribute("pa_id", pa_id);
        request.getRequestDispatcher("insertPrescription.jsp").forward(request, response);

    }

}
