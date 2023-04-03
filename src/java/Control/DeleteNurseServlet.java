package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Nurse;
import Model.NurseDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/deleteNurse"})
public class DeleteNurseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nu_id = request.getParameter("id");
        NurseDAO u = new NurseDAO();
        u.deleteNurse(nu_id);
        List<Nurse> lst = u.getNurses();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listNurse.jsp").forward(request, response);
    }

}
