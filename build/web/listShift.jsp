<%-- 
    Document   : listShift
    Created on : Oct 3, 2022, 11:12:33 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Shift" %>
<%@page import="Model.ShiftDAO" %>
<%@page import="Model.User" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>List of Nurse(s)' shifts </title>        

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
        List<Shift> lst = (List<Shift>) request.getAttribute("lst");
        String searchID = (String) request.getAttribute("searchID");
        if(searchID == null) searchID = "";
        %>
        <h2>Minh Son Hospital</h2>
        <div class="hospital">
            <img src="https://png.pngtree.com/thumb_back/fw800/back_our/20190621/ourmid/pngtree-cartoon-medical-banner-poster-image_184431.jpg">
        </div>
        <div class="option">
            <div>
                <p><a href="listMedicine">List medicines </a></p>
                <p><a href="listPatient">List Patients </a></p> 
            </div>
            <div>
                <p id="active"><a href="listShift">List shifts</a></p>
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
        <h2> List of shifts </h2>
        <div class="search">
            <div class="searchId">
                <form action="searchNurseIDShift" method="post">
                    <a class="textId">Search nurse's ID:</a>
                    <input type="text" name="searchID" value="<%= searchID %>"/>
                    <input class="submitNameId" type="submit" value="search"/>
                </form>
            </div>
        </div>
        <div>
            <table border="1">
                <tr>
                    <td> Nu_id </td>
                    <td> Room_id </td>
                    <td> Date </td>
                    <td> Shift </td>
                </tr>
                <%
                  for(Shift x : lst) {
                %>
                <tr>
                    <td><%= x.getNu_id() %> </td>
                    <td><%= x.getRoom_id() %> </td>
                    <td><%= x.getDate() %> </td>
                    <td><%= x.getShift() %> </td>
                </tr>  
                <% } %>  
            </table>     
        </div>
        <p class="insert"><a href="insertShift.jsp"> Insert a new shift here</a></p>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>

            <%} %>


    </body>
</html>
