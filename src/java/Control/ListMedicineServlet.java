package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.*;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/listMedicine"})
public class ListMedicineServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        MedDAO u = new MedDAO();
        List<Med> lst = u.getMeds();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listMedicine.jsp").forward(request, response);

    }
}

