package Control;

import Model.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter pr = response.getWriter();
     Cookie [] a = request.getCookies();
     String xValue = MyLib.searchCookie(a, "currUser");
     if(xValue==null || xValue.trim().equals("")) {
        pr.print("<h3> No data in cookie! </h3>");
        request.getRequestDispatcher("login.html").include(request, response);
        return;
      }
     String [] b = xValue.split("[|]+");
     String xName = b[0];
     String xPass = b[1];
     UserDAO u = new UserDAO();
     User x = u.getUser(xName, xPass);
     request.getSession().setAttribute("currUser", x);
     String logResult = "";
     if(x==null) { 
       logResult = "Sorry, username and/or password are/is invalid!";  
      }
      else {
       logResult = "Login is successful!";  
       } 
     pr.print(logResult);  
     request.getRequestDispatcher("/index.jsp").include(request, response);  
  }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter pr = response.getWriter();
     String xName,xPass; Object xRemMe;
     xName = request.getParameter("name");
     xPass = request.getParameter("pass");
     xRemMe = request.getParameter("remMe");
     User x = null;
     UserDAO t = new UserDAO();
     x = t.getUser(xName, xPass);
     request.getSession().setAttribute("currUser", x);
     String logResult = "";
     if(x==null) { 
       logResult = "Sorry, username and/or password are/is invalid!";  
      }
      else {
       logResult = "Login is successful!";  
       if(xRemMe != null) {
         String namePass = xName.trim() + "|" + xPass.trim();
         Cookie y = new Cookie("currUser",namePass);
         y.setMaxAge(60*60*24); // 1 day
         response.addCookie(y);
       } 
     }
     pr.print(logResult);  
     request.getRequestDispatcher("/index.jsp").include(request, response);  
  }

}
