package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Nurse;
import Model.NurseDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchNurseName"})
public class SearchNurseNameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xName = request.getParameter("name").trim();
        NurseDAO u = new NurseDAO();
        List<Nurse> lst = u.getNursesName(xName);
        if (!lst.isEmpty()) {
            request.setAttribute("lst", lst);
        }
        request.setAttribute("searchName", xName);
        request.getRequestDispatcher("listNurse.jsp").forward(request, response);

    }

}
