package Control;

import Model.Med;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Patient;
import Model.PatientDAO;
import Model.Prescription;
import Model.InPatient;
import java.util.ArrayList;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchPatientId"})
public class SearchPatientIdServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xPa_id = request.getParameter("pa_id").trim();
        PatientDAO u = new PatientDAO();
        Patient x = u.getPatientId(xPa_id);
        List<Prescription> lst = u.getPrescriptionFromPatient(xPa_id);
        String room = u.getRoomFromPatient(xPa_id);
        if (x == null) {
            lst = null;
            request.setAttribute("lst", lst);
            request.setAttribute("pa_id", xPa_id);
            request.getRequestDispatcher("listPatient.jsp").forward(request, response);
        } else {
            request.setAttribute("lst", lst);
            request.setAttribute("room", room);
            request.setAttribute("x", x);
            request.getRequestDispatcher("patientInfo.jsp").forward(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xPa_id = request.getParameter("pa_id").trim();
        PatientDAO u = new PatientDAO();
        Patient x = u.getPatientId(xPa_id);
        List<Prescription> lst = u.getPrescriptionFromPatient(xPa_id);
        String room = u.getRoomFromPatient(xPa_id);
        if (x == null) {
            lst = null;
            request.setAttribute("lst", lst);
            request.setAttribute("pa_id", xPa_id);
            request.getRequestDispatcher("listPatient.jsp").forward(request, response);
        } else {
            request.setAttribute("lst", lst);
            request.setAttribute("room", room);
            request.setAttribute("x", x);
            request.getRequestDispatcher("patientInfo.jsp").forward(request, response);
        }
    }

}
