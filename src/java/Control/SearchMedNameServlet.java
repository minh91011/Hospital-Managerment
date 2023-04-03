package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Med;
import Model.MedDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchMedName"})
public class SearchMedNameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xName = request.getParameter("name").trim();
        MedDAO u = new MedDAO();
        List<Med> lst = u.getMedsName(xName);
        if(!lst.isEmpty()){
            request.setAttribute("lst", lst );
        }
        request.setAttribute("searchName", xName);
        request.getRequestDispatcher("listMedicine.jsp").forward(request, response);

    }

}
