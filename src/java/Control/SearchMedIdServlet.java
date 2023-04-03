package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import Model.Med;
import Model.MedDAO;
import java.util.ArrayList;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/searchMedId"})
public class SearchMedIdServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xMed_id = request.getParameter("med_id").trim();
        MedDAO u = new MedDAO();
        Med x = u.getMedId(xMed_id);
        List<Med> lst = new ArrayList<>();
        lst.add(x);
        if (x != null) {
            request.setAttribute("lst", lst);
        }
        request.setAttribute("med_id", xMed_id);
        request.getRequestDispatcher("listMedicine.jsp").forward(request, response);
    }


}

