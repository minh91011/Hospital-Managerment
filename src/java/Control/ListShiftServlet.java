package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Shift;
import Model.ShiftDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/listShift"})
public class ListShiftServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        ShiftDAO u = new ShiftDAO();
        List<Shift> lst = u.getShifts();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listShift.jsp").forward(request, response);

    }
}
