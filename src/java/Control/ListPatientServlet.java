package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.*;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/listPatient"})
public class ListPatientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        PatientDAO u = new PatientDAO();
        List<Patient> lst = u.getPatients();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listPatient.jsp").forward(request, response);

    }
}

