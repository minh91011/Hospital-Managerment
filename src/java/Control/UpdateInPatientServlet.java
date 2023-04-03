/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.InPatient;
import Model.InPatientDAO;
import Model.Room;
import Model.RoomDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/updateInPatient"})
public class UpdateInPatientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String pa_id = request.getParameter("pa_id");
        InPatientDAO u = new InPatientDAO();
        InPatient x = u.havePatientId(pa_id);
        if (x == null) {
            request.getRequestDispatcher("updateInPatient.jsp").include(request, response);
        } else {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateInPatient.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sPa_id,sRoom_id;
        sPa_id = request.getParameter("pa_id");
        sRoom_id = request.getParameter("room_id").trim();
        InPatientDAO u = new InPatientDAO();
        RoomDAO ur = new RoomDAO();
        Room r = ur.getRoom(sRoom_id);
        boolean isOk = true;
        if (r == null && "Invalid room id".equals(sRoom_id)) {
            sRoom_id = "Invalid room id";
            isOk = false;
        }
        InPatient x = new InPatient(sPa_id, sRoom_id);
        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateInPatient.jsp").forward(request, response);
            return;
        }

        u.update(sPa_id, sRoom_id);
        response.sendRedirect("listRoom.jsp");
    }
}
