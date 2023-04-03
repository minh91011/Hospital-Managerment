package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.*;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/listRoom"})
public class ListRoomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        RoomDAO u = new RoomDAO();
        List<Room> lst = u.getRooms();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listRoom.jsp").forward(request, response);

    }
}

