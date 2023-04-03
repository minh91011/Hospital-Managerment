<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>List of rooms</title>
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
        RoomDAO ur = new RoomDAO();
            
        List<Room> lst = ur.getRooms();    
        String searchId = (String) request.getAttribute("room_id");
        if(searchId == null) searchId = "";
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

        <%
        if(lst == null){
        %>
        <h2>No room</h2>
        <%
        }else{
        %>  
        <h2> List of rooms </h2>
        <div class="search">
            <div class="searchId">
                <form action="searchRoomId" method="post">
                    <a class="textId">Search ID:</a>
                    <input type="text" name="room_id" value="<%=searchId %>"/>
                    <input class="submitNameId" type="submit" value="search"/>
                </form>
            </div>
        </div>
        <div>
            <table border="1">
                <tr>
                    <td> Room_id </td>
                    <td> Type </td>
                    <td> Available </td>
                    <td> PricePerDay </td>
                </tr>
                <%
                  for(Room x : lst) {
                %>
                <tr>
                    <td><%= x.getId() %> </td>
                    <td><%= x.getType() %> </td>
                    <td><%= x.getAvailable() %> </td>
                    <td><%= x.getPricePerDay() %> </td>
                    <td><a href="deleteRoom?id=<%=x.getId() %>">  Delete </a> </td>
                     <% if (role == 3) { %><td><a href="updateRoom?room_id=<%=x.getId() %>">  Update </a> </td><%}%>
                </tr>  
                <% } 
                }
                %>  
            </table>
        </div>
        <p class="insert"><a href="insertRoom.jsp"> Insert a new room here</a></p>


        <%
            InPatientDAO up = new InPatientDAO();
            
            List<InPatient> lstRo = up.getInPatients();
       
        if(lstRo == null){
        %>
        <h2>No room</h2>
        <%
        }else{
        %>  

        <h2> List of InPatients </h2>
        <div>
            <table border="1">
                <tr>
                    <td> Pa_id</td>
                    <td> Room_id </td>
                </tr>
                <%
                  for(InPatient i : lstRo) {
                %>
                <tr>
                    <td><%= i.getPa_id() %> </td>
                    <td><%= i.getRoom_id() %> </td>
                    <% if (role == 3) { %><td><a href="updateInPatient?pa_id=<%=i.getPa_id() %>">  Update </a> </td><%}%>
                </tr>  
                <% } 
                }
                %>  
            </table> 
        </div>
        <p class="insert"><a href="insertInPatient.jsp"> Insert a new inpatient here</a></p>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>


            <%} %>
    </body>
</html>

