/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.User;
import Model.UserDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        UserDAO u = new UserDAO();
        User x = u.getUser(name, pass);
        request.setAttribute("x", x);
        request.getRequestDispatcher("updateUser.jsp").forward(request, response);

    }

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
        boolean isOk = true;
        if (pass.length() == 0 || "Invalid password".equals(pass)) {
            x.setPass("Invalid password");
            isOk = false;
        }

        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateUser.jsp").forward(request, response);
            return;
        }

        u.update(name, pass, Integer.parseInt(sRole));
        List<User> lst = u.getUsers();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listUser.jsp").forward(request, response);
    }
}
