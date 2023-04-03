/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.User;
import Model.UserDAO;
import java.util.List;

@WebServlet(urlPatterns = {"/insertUser"})
public class InsertUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name, pass, sRole;
        name = request.getParameter("name").trim();
        pass = request.getParameter("pass").trim();
        sRole = request.getParameter("role");
        UserDAO u = new UserDAO();
        User x = u.getUser(name, pass);
        if (x != null) {
            out.print("<h2> User with username \'" + name + "\' already exist </h2>");
            request.getRequestDispatcher("insertUser.jsp").include(request, response);
            return;
        }
        if (pass.length() == 0) {
            out.print("<h2> password cannot be empty </h2>");
            request.getRequestDispatcher("insertUser.jsp").include(request, response);
            return;
        }
        u.insert(name, pass, Integer.parseInt(sRole));
        List<User> lst = u.getUsers();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listUser.jsp").forward(request, response);
    }
}
