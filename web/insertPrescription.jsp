<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.Date" %>
<%@page import = "java.util.*" %>
<%@page import = "Model.Med" %>
<%@page import = "Model.MedDAO" %>
<%@page import = "Model.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>Insert new prescription</title>
    </head>
    <body>
        <%
            User u = (User) request.getSession().getAttribute("currUser");
            if(u==null){
        %>
        <h2> You cant access this page ! </h2>
        <% return;} 
        else {
            int role = u.getRole();
            MedDAO um = new MedDAO();
            List<Med> lst = um.getMeds();
            String pa_id = (String) request.getAttribute("pa_id");
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);  
            String sDate = date.toString();
        %>
        <div class="hospital">
            <img src="https://png.pngtree.com/thumb_back/fw800/back_our/20190621/ourmid/pngtree-cartoon-medical-banner-poster-image_184431.jpg">
        </div>
        <div class="option">
            <div>
                <p><a href="listMedicine">List medicines </a></p>
                <p id="active"><a href="listPatient">List Patients </a></p> 
            </div>
            <div>
                <p><a href="listShift">List shifts</a></p>
                <% if (role >= 2) { %><p><a href="listDoctor">List Doctors</a></p> <% } %>
            </div>             
            <div>
                <p><a href="listNurse">List Nurses</a></p>
                <p><a href="listRoom">List Rooms</a></p>
            </div>
            <div>
                <% if (role == 3) { %><p><a href="listUser.jsp"> View list of users </a></p> <% } %>
                <div class="logout">
                    <p><a href="logout"> Logout </a></p>
                </div>              
            </div>
        </div>



        <h2>Insert new prescription</h2>\
        <div class="formInsert">
            <form action="insertPrescription" method="POST">
                <ul>
                    <li><p>Pa_id<input type="text" name="pa_id" value="<%=pa_id%>" readonly> </p></li>
                    <li><p>Med_id<input type="text" name="med_id" value=""> </p></li>
                    <li><p>Date <input type="date" name="time" value="<%=sDate%>" min="<%=sDate%>"> </p></li>
                    <li><p class="okay"><input type="submit" value="insertPrescription"></p></li>
                </ul>                
            </form>
        </div>
        <%
          if(lst == null){
        %>
        <h2>No medicine</h2>
        <%
        }else{
        %>
        <h2> List of medicine(s) </h2>
        <div>
            <table border="1">
                <tr>
                    <td> Med_id </td>
                    <td> Name </td>
                    <td> NSX </td>
                    <td> available </td>
                    <td> price </td>
                    <td> HealthInsuranceCoverage </td>
                </tr>
                <%
                  for(Med x : lst) {
                %>
                <tr>
                    <td><%= x.getMed_id() %> </td>
                    <td><%= x.getName() %> </td>
                    <td><%= x.getNSX() %> </td>
                    <td><%= x.getAvailable() %> </td>
                    <td><%= x.getPrice() %> </td>
                    <td><%= x.getHICoverage() %> </td>
                    <td><a href="insertPrescriptionFromMed?med_id=<%=x.getMed_id()%>&pa_id=<%=pa_id%>&time=<%=sDate%>">insert</a></td>
                </tr>  
                <% }
                }   
                %>  
            </table>   
        </div>

        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>   
        <p class="back"><a href="searchPatientId?pa_id=<%=pa_id %>">  Back to patient's info</a></p>
            <%}%>
    </body>
</html>
