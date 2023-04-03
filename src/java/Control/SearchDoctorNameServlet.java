package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Doctor;
import Model.DoctorDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchDoctorName"})
public class SearchDoctorNameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xName = request.getParameter("name").trim();
        DoctorDAO u = new DoctorDAO();
        List<Doctor> lst = u.getDoctorsName(xName);
        if (!lst.isEmpty()) {
            request.setAttribute("lst", lst);
        }
        request.setAttribute("searchName", xName);
        request.getRequestDispatcher("listDoctor.jsp").forward(request, response);

    }

}
