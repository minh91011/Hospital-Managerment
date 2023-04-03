package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import Model.NurseDAO;
import Model.Nurse;
import Model.Shift;
import Model.ShiftDAO;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchNurseId"})
public class SearchNurseIdServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xNu_id = request.getParameter("nu_id");
        ShiftDAO s = new ShiftDAO();
        NurseDAO u = new NurseDAO();
        Nurse x = u.getNurse(xNu_id);
        if (x == null) {
            out.print("<h2> The nurse with id \"" + xNu_id + "\" does not exist !");
            request.getRequestDispatcher("nurseInfo.html").include(request, response);
        } else {
            List<Shift> lst = s.getNurseIDShift(xNu_id);
            request.setAttribute("x", x);
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("nurseInfo.jsp").forward(request, response);
        }

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xNu_id = request.getParameter("nu_id");
        ShiftDAO s = new ShiftDAO();
        NurseDAO u = new NurseDAO();
        Nurse x = u.getNurse(xNu_id);
        if (x == null) {
            out.print("<h2> The nurse with id \"" + xNu_id + "\" does not exist !");
            request.getRequestDispatcher("nurseInfo.html").include(request, response);
        } else {
            List<Shift> lst = s.getNurseIDShift(xNu_id);
            request.setAttribute("x", x);
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("nurseInfo.jsp").forward(request, response);
        }

    }

}