package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.User;
import Model.UserDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/deleteUser"})
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String doc_id = request.getParameter("name");
        UserDAO u = new UserDAO();
        u.deleteUser(doc_id);
        List<User> lst = u.getUsers();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listUser.jsp").forward(request, response);
    }

}
