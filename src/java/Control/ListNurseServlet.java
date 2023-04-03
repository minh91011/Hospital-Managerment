package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.*;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/listNurse"})
public class ListNurseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        NurseDAO u = new NurseDAO();
        List<Nurse> lst = u.getNurses();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listNurse.jsp").forward(request, response);

    }
}

