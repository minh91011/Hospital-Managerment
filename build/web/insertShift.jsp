<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.Date" %>
<%@page import = "java.util.*" %>
<%@page import = "Model.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>Insert new shift</title>
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
        <h2>Insert new shift</h2>
        <div class="formInsert">
            <form action="insertShift" method="POST">
                <ul>
                    <li><p>Nu_Id<input type="text" name="nu_id" value=""> </p></li>
                    <li><p>Room_id<input type="text" name="room_id" value=""> </p></li>
                    <li><p>Date <input type="date" name="date" value="<%=sDate%>" min="<%=sDate%>"> </p></li>
                    <li><p>Gender 
                            <input type="radio" name="shift" value="M" checked> <label >Morning</label>
                            <input type="radio"  name="shift" value="A"> <label>Afternoon</label>
                            <input type="radio" name="shift" value="E" checked> <label >Evening</label>
                            <input type="radio"  name="shift" value="N"> <label>Night</label>
                        </p></li>
                    <li><p class="okay"><input type="submit" value="insertShift"></p></li>
                </ul>    
            </form>
        </div>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>
            
            <%}%>
    </body>
</html>
