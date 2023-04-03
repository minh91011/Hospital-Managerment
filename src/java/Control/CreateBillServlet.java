
package Control;

import Model.Bill;
import Model.BillDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/createBill"})
public class CreateBillServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String sPa_id = request.getParameter("pa_id");
        BillDAO u = new BillDAO();
        u.createBill(sPa_id);
        Bill x = u.takeBill(sPa_id);
        request.setAttribute("bill", x);
        request.getRequestDispatcher("createBill.jsp").forward(request, response);
    }

}