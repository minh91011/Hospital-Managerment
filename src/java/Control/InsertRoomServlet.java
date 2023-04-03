/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.Room;
import Model.RoomDAO;
import java.util.List;

@WebServlet(urlPatterns = {"/insertRoom"})
public class InsertRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sId, sType, sAvailable, sPricePerDay;
        int available = 0;
        float pricePerDay = 0;
        sId = request.getParameter("room_id").trim();
        sType = request.getParameter("type").trim();
        sAvailable = request.getParameter("available").trim();
        sPricePerDay = request.getParameter("priceperday").trim();
        RoomDAO u = new RoomDAO();
        Room x = u.getRoom(sId);
        if (x != null) {
            out.print("<h2> the room with id \'" + sId + "\' already exist </h2>");
            request.getRequestDispatcher("insertRoom.jsp").include(request, response);
            return;
        }
        
        try {
            available = Integer.parseInt(sAvailable);
        } catch (Exception e) {
            out.print("<h2> Incorrect available, must be an int </h2>");
            request.getRequestDispatcher("insertRoom.jsp").include(request, response);
            return;
        }
        try {
            pricePerDay = Float.parseFloat(sPricePerDay);
        } catch (Exception e) {
            out.print("<h2> Incorrect pricePerDay, must be an float </h2>");
            request.getRequestDispatcher("insertRoom.jsp").include(request, response);
            return;
        }

        u.insert(sId, sType, available, pricePerDay);
        List<Room> lst = u.getRooms();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listRoom.jsp").forward(request, response);
    }
}
