/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Med;
import Model.MedDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
//import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/updateMed"})
public class UpdateMedicineServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xId = request.getParameter("med_id");
        MedDAO u = new MedDAO();
        Med x = u.getMedId(xId);

        request.setAttribute("x", x);
        request.getRequestDispatcher("updateMedicine.jsp").forward(request, response);

    }

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
        boolean isOk = true;

        if (sName.length() == 0 || "Invalid name".equals(sName)) {
            x.setName("Invalid name");
            isOk = false;
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
        if (sPrice == null || sPrice.trim().length() == 0) {
            price = 0;
        } else {
            try {
                price = Float.parseFloat(sPrice);
            } catch (Exception e) {
                isOk = false;
            }
        }
        if (sHIC == null || sHIC.trim().length() == 0) {
            HIC = 0;
        } else {
            try {
                HIC = Float.parseFloat(sHIC);
            } catch (Exception e) {
                isOk = false;
            }
        }

        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("updateMedicine.jsp").forward(request, response);
            return;
        }

        u.update(sMed_id, sName, sNSX, available, price, HIC);

        List<Med> lst = u.getMeds();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("listMedicine.jsp").forward(request, response);
    }
}
