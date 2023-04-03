/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Model.Med;
import Model.MedDAO;
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/insertMed"})
public class InsertMedServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sMed_id, sName, sNSX, sAvailable, sPrice, sHIC;
        int available = 0;
        float price = 0, HIC = 0;
        sMed_id = request.getParameter("med_id").trim();
        sName = request.getParameter("name").trim();
        sNSX = request.getParameter("nsx").trim();
        sAvailable = request.getParameter("available").trim();
        sPrice = request.getParameter("price").trim();
        sHIC = request.getParameter("hic").trim();
        MedDAO u = new MedDAO();
        Med x = u.getMedId(sMed_id);
        if(x!=null){
            out.print("<h2> The medicine with id \'"+sMed_id+"\' is already exist ! </h2>");
            request.getRequestDispatcher("insertMedicine.jsp").include(request, response);
            return;
        }
        try {
            available = Integer.parseInt(sAvailable);
        } catch (Exception e) {
            out.print("<h2> Incorrect available, must be an int </h2>");
            request.getRequestDispatcher("insertMedicine.jsp").include(request, response);
            return;
        }
        try {
            price = Float.parseFloat(sPrice);
        } catch (Exception e) {
            out.print("<h2> Incorrect price, must be an float </h2>");
            request.getRequestDispatcher("insertMedicine.jsp").include(request, response);
            return;
        }
        
        try {
            HIC = Float.parseFloat(sHIC);
        } catch (Exception e) {
            out.print("<h2> Incorrect health insurance coverage, must be an float </h2>");
            request.getRequestDispatcher("insertMedicine.jsp").include(request, response);
            return;
        }

        u.insert(sMed_id, sName, sNSX, available, price, HIC);
        List<Med> lst = u.getMeds();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listMedicine.jsp").forward(request, response);
    }
}
