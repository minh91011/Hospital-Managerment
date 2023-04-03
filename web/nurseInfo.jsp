<%-- 
    Document   : nurseInfo
    Created on : Oct 3, 2022, 10:56:09 AM
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
        <title>Nurse information</title>
    </head>
    <body>
        <%
           User u = (User) request.getSession().getAttribute("currUser");
           if(u==null){
        %>

        <h2> You cant access this page ! </h2>
        <% return;} 
        else {    
            List<Shift> lst = (List<Shift>) request.getAttribute("lst");
            Nurse x = (Nurse) request.getAttribute("x");
            String gender;
            if(x.isGender()) gender = "Nam";
            else gender = "Nu";
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
                <% if (role >= 2) { %><p><a href="listDoctor">List Doctors</a></p> <% } %>
            </div>             
            <div>
                <p id="active"><a href="listNurse">List Nurses</a></p>
                <p><a href="listRoom">List Rooms</a></p>
            </div>
            <div>
                <% if (role == 3) { %><p><a href="listUser.jsp"> View list of users </a></p> <% } %>
                <div class="logout">
                    <p><a href="logout"> Logout </a></p>
                </div>              
            </div>
        </div>    
        <h2>Nurse found</h2>
        <div class="formInsert">
            <ul>
                <li><h3>Nu_id: <%= x.getNu_id() %> </h3></li>
                <li><h3>FullName: <%= x.getFullName() %> </h3></li>
                <li><h3>BirthDay: <%= x.getBirthDay() %></h3></li>
                <li><h3>Gender: <%= gender %> </h3></li>
                <li><h3>Address: <%= x.getAddress() %> </h3></li>
            </ul>
        </div>
        <h2> Shifts:  </h2>
        <div>
        <table border="1">
            <tr>
                <td> Room_id </td>
                <td> Date </td>
                <td> Shift </td>
            </tr>
            <%
              for(Shift s : lst) {
            %>
            <tr>
                <td><%= s.getRoom_id() %> </td>
                <td><%= s.getDate() %> </td>
                <td><%= s.getShift() %> </td>
            </tr>  
            <% } %>  
        </table>
        </div>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>




   
        <%} %>
    </body>
</html>