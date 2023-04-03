package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Patient;
import Model.PatientDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/deletePatient"})
public class DeletePatientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pa_id = request.getParameter("id");
        PatientDAO u = new PatientDAO();
        u.deletePatient(pa_id);
        List<Patient> lst = u.getPatients();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listPatient.jsp").forward(request, response);
    }

}
