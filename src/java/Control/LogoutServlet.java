package Control;

import Model.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter pr = response.getWriter();
     Cookie y = new Cookie("currUser","");
     y.setMaxAge(0); 
     response.addCookie(y);
     request.getSession().setAttribute("currUser", null);
     pr.print("You have been loggod out!");  
     request.getRequestDispatcher("main.html").include(request, response);  
  }

}
