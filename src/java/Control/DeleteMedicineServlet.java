package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Med;
import Model.MedDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/deleteMed"})
public class DeleteMedicineServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String med_id = request.getParameter("med_id");
        MedDAO u = new MedDAO();
        u.deleteMedicine(med_id);
        List<Med> lst = u.getMeds();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listMedicine.jsp").forward(request, response);
    }

}
