package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Patient;
import Model.PatientDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchPatientName"})
public class SearchPatientNameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xName = request.getParameter("name").trim();
        PatientDAO u = new PatientDAO();
        List<Patient> lst = u.getPatientsName(xName);
        if (!lst.isEmpty()) {
            request.setAttribute("lst", lst);
        }
        request.setAttribute("searchName", xName);
        request.getRequestDispatcher("listPatient.jsp").forward(request, response);

    }

}
