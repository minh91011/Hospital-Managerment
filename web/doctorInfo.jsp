<%-- 
    Document   : doctorInfo
    Created on : Sep 30, 2022, 10:48:16 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>Doctor information</title>
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
        %>
        <div class="hospital">
            <img src="https://png.pngtree.com/thumb_back/fw800/back_our/20190621/ourmid/pngtree-cartoon-medical-banner-poster-image_184431.jpg">
        </div>
        <div class="option">
            <div>
                <p><a href="listMedicine">List medicines </a></p>
                <p><a href="listPatient">List Patients </a></p> 
            </div>
            <div>
                <p><a href="listShift">List shifts</a></p>
                <% if (role >= 2) { %><p id="active"><a href="listDoctor">List Doctors</a></p> <% } %>
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
        <%
            List<Patient> lst = (List<Patient>) request.getAttribute("lst");
            Doctor x = (Doctor) request.getAttribute("x");
            String gender;
            if(x.isGender()) gender = "Nam";
            else gender = "Nu";
        %>    
        <h2>Doctor found</h2>
        <div class="formInsert">
            <ul>
                <li><h3>Doc_id: <%= x.getDoc_id() %> </h3></li>
                <li><h3>FullName: <%= x.getFullName() %> </h3></li>
                <li><h3>BirthDay: <%= x.getBirthDay() %></h3></li>
                <li><h3>Gender: <%= gender %> </h3></li>
                <li><h3>Address: <%= x.getAddress() %> </h3></li>
            </ul>
        </div>
        <h2> Patients:  </h2>
        <div>
            <table border="1">
                <tr>
                    <td> Pa_id </td>
                    <td> FullName </td>
                    <td> BirthDay </td>
                    <td> gender </td>
                    <td> address </td>
                    <td> outPatient </td>
                    <td> HealthInsurance </td>
                </tr>
                <%
                  for(Patient p : lst) {
                  String pGender;
                    if(p.isGender()) pGender = "Nam";
                    else pGender = "Nu";
                %>
                <tr>
                    <td><%= p.getPa_id() %> </td>
                    <td><%= p.getFullName() %> </td>
                    <td><%= p.getBirthday() %> </td>
                    <td><%= pGender %> </td>
                    <td><%= p.getAddress() %> </td>
                    <td><%= p.isOutPatient() %> </td>
                    <td><%= p.isHealthInsurance() %> </td>
                </tr>  
                <% } %>  
            </table>
        </div>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>





            <%} %>
    </body>
</html>
