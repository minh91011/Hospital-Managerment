package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Doctor;
import Model.DoctorDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/deleteDoctor"})
public class DeleteDoctorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String doc_id = request.getParameter("id");
        DoctorDAO u = new DoctorDAO();
        u.deleteDoctor(doc_id);
        List<Doctor> lst = u.getDoctors();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listDoctor.jsp").forward(request, response);
    }

}
