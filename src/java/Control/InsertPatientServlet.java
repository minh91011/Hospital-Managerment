/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Doctor;
import Model.DoctorDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.Patient;
import Model.PatientDAO;
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/insertPatient"})
public class InsertPatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sPa_id, sDoc_id, sFullName, sAddress;
        String sBirthday;
        String sGender, sOutPatient, sHealthInsurance;
        sPa_id = request.getParameter("pa_id").trim();
        sDoc_id = request.getParameter("doc_id").trim();
        sFullName = request.getParameter("fullname").trim();
        sAddress = request.getParameter("address").trim();
        sBirthday = request.getParameter("birthday").trim();
        sGender = request.getParameter("gender").trim();
        sOutPatient = request.getParameter("outpatient").trim();
        sHealthInsurance = request.getParameter("hi");
        PatientDAO u = new PatientDAO();
        DoctorDAO docU = new DoctorDAO();
        Patient x = u.getPatientId(sPa_id);
        Doctor doc = docU.getDoctor(sDoc_id);
        if (x != null) {
            out.print("<h2> the patient with id \'" + sPa_id + "\' already exist");
            request.getRequestDispatcher("insertPatient.jsp").include(request, response);
            return;
        }
        if (doc == null) {
            out.print("<h2> the doctor with id \'" + sDoc_id + "\' not exist");
            request.getRequestDispatcher("insertPatient.jsp").include(request, response);
            return;
        }
        if (sPa_id.length() ==0) {
            out.print("<h2> Patient's id cannot be empty");
            request.getRequestDispatcher("insertPatient.jsp").include(request, response);
            return;
        }
        if (sFullName.length() == 0) {
            out.print("<h2> Name cannot be empty");
            request.getRequestDispatcher("insertPatient.jsp").include(request, response);
            return;
        }
        if (sAddress.length() == 0) {
            out.print("<h2> Address cannot be empty");
            request.getRequestDispatcher("insertPatient.jsp").include(request, response);
            return;
        } 
        u.insert(sPa_id, sFullName, sBirthday, sGender, sAddress, sOutPatient, sHealthInsurance, sDoc_id);
        List<Patient> lst = u.getPatients();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listPatient.jsp").forward(request, response);
    }
}
