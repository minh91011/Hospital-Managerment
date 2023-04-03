/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Room;
import Model.RoomDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/updateRoom"})
public class UpdateRoomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xId = request.getParameter("room_id");
        RoomDAO u = new RoomDAO();
        Room x = u.getRoom(xId);
        if (x == null) {
            pr.println("<h2> A room is not found</h2>");
            request.getRequestDispatcher("updateRoom.jsp").include(request, response);
        } else {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateRoom.jsp").forward(request, response);
        }

    }

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
        boolean isOk = true;
        if (sPricePerDay == null || sPricePerDay.trim().length() == 0) {
            pricePerDay = 0;
        } else {
            try {
                pricePerDay = Float.parseFloat(sPricePerDay.trim());
            } catch (Exception e) {
                isOk = false;
            }
        }
        
        if (sAvailable == null || sAvailable.trim().length() == 0) {
            available = 0;
        } else {
            try {
                available = Integer.parseInt(sAvailable);
            } catch (Exception e) {
                isOk = false;
            }
        }

        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateRoom.jsp").forward(request, response);
            return;
        }

        u.update(sId, sType, available, pricePerDay);
        List<Room> lst = u.getRooms();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listRoom.jsp").forward(request, response);
    }
}
