
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>insert Inpatient</title>
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
                <% if (role >= 2) { %><p><a href="listDoctor">List Doctors</a></p> <% } %>
            </div>             
            <div>
                <p><a href="listNurse">List Nurses</a></p>
                <p id="active"><a href="listRoom">List Rooms</a></p>
            </div>
            <div>
                <% if (role == 3) { %><p><a href="listUser.jsp"> View list of users </a></p> <% } %>
                <div class="logout">
                    <p><a href="logout"> Logout </a></p>
                </div>              
            </div>
        </div>
        <h2>Insert new inpatient</h2>
        <div class="formInsert">
            <form action="insertInPatient" method="POST">
                <ul>
                    <li><p>Patient's Id<input type="text" name="pa_id" value=""> </p></li>
                    <li><p>Room's Id<input type="text" name="room_id" value=""> </p></li>
                    <li><p class="okay"><input type="submit" value="insertInPatient"></p></li>
                </ul>
            </form>
        </div>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>





            <%} %>

    </body>
</html>
