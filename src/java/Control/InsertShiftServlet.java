/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Nurse;
import Model.NurseDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.Shift;
import Model.ShiftDAO;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/insertShift"})
public class InsertShiftServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sNu_id, sRoom_id, sDate ,sShift;
        sNu_id = request.getParameter("nu_id").trim();
        sRoom_id = request.getParameter("room_id").trim();
        sDate = request.getParameter("date");
        sShift = request.getParameter("shift");
        ShiftDAO u = new ShiftDAO();
        NurseDAO nu = new NurseDAO();
        Nurse x = nu.getNurse(sNu_id);
        if (x == null) {
            out.print("<h2> the nurse with id \'" + sNu_id + "\' not exist");
            request.getRequestDispatcher("insertShift.jsp").include(request, response);
            return;
        }
        if (sNu_id.length() ==0) {
            out.print("<h2> Nurse 's id cannot be empty");
            request.getRequestDispatcher("insertShift.jsp").include(request, response);
            return;
        }
        if (sRoom_id.length() == 0) {
            out.print("<h2> Room 's id cannot be empty");
            request.getRequestDispatcher("insertShift.jsp").include(request, response);
            return;
        }
        u.insert(sNu_id, sRoom_id, sDate, sShift);
        List<Shift> lst = u.getShifts();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listShift.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        request.getRequestDispatcher("insertShift.jsp").forward(request, response);
        

    }
    
    
}
