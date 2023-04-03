package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import Model.Doctor;
import Model.DoctorDAO;
import Model.Patient;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchDoctorId"})
public class SearchDoctorIdServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xDoc_id = request.getParameter("doc_id").trim();
        DoctorDAO u = new DoctorDAO();
        Doctor x = u.getDoctor(xDoc_id);
        List<Patient> lst = u.getPatientsFromDoctor(xDoc_id);
        if (x == null) {
            lst = null;
            request.setAttribute("lst", lst);
            request.setAttribute("doc_id", xDoc_id);
            request.getRequestDispatcher("listDoctor.jsp").forward(request, response);
        } else {
            request.setAttribute("lst", lst);
            request.setAttribute("x", x);
            request.getRequestDispatcher("doctorInfo.jsp").forward(request, response);
        }

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xDoc_id = request.getParameter("doc_id").trim();
        DoctorDAO u = new DoctorDAO();
        Doctor x = u.getDoctor(xDoc_id);
        List<Patient> lst = u.getPatientsFromDoctor(xDoc_id);
        if (x == null) {
            lst = null;
            request.setAttribute("lst", lst);
            request.setAttribute("doc_id", xDoc_id);
            request.getRequestDispatcher("listDoctor.jsp").forward(request, response);
        } else {
            request.setAttribute("lst", lst);
            request.setAttribute("x", x);
            request.getRequestDispatcher("doctorInfo.jsp").forward(request, response);
        }

    }

}
