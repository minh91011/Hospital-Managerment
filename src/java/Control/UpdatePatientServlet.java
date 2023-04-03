/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Doctor;
import Model.DoctorDAO;
import Model.Patient;
import Model.PatientDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.Date;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/updatePatient"})
public class UpdatePatientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xPa_id = request.getParameter("pa_id");
        PatientDAO u = new PatientDAO();
        Patient x = u.getPatientId(xPa_id);
        if (x == null) {
            pr.println("<h2> A patient is not found</h2>");
            request.getRequestDispatcher("updatePatient.jsp").include(request, response);
        } else {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updatePatient.jsp").forward(request, response);
        }

    }

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
        boolean isOk = true;
        PatientDAO u = new PatientDAO();
        DoctorDAO docU = new DoctorDAO();
        Patient x = u.getPatientId(sPa_id);
        Doctor doc = docU.getDoctor(sDoc_id);
        if (doc == null || "Doc_id not exist".equals(sDoc_id)) {
            x.setDoc_id("Doc_id not exist");
            isOk = false;
        }
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
            request.getRequestDispatcher("updatePatient.jsp").forward(request, response);
            return;
        }

        u.update(sPa_id, sFullName, sBirthday, sGender, sAddress, sOutPatient, sHealthInsurance, sDoc_id);
        List<Patient> lst = u.getPatients();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listPatient.jsp").forward(request, response);
    }
}
