package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import Model.Room;
import Model.RoomDAO;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/deleteRoom"})
public class DeleteRoomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String room_id = request.getParameter("id");
        RoomDAO u = new RoomDAO();
        u.deleteRoom(room_id);
        List<Room> lst = u.getRooms();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listRoom.jsp").forward(request, response);
    }

}
