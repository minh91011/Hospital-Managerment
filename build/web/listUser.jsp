<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.UserDAO" %>
<%@page import = "Model.User" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>List of users</title>
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
        UserDAO uu = new UserDAO(); 
        List<User> lst = uu.getUsers();
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
                <p><a href="listRoom">List Rooms</a></p>
            </div>
            <div>
                <% if (role == 3) { %><p id="active"><a href="listUser.jsp"> View list of users </a></p> <% } %>
                <div class="logout">
                    <p><a href="logout"> Logout </a></p>
                </div>              
            </div>
        </div>
        <h2> List of users </h2>
        <div>
            <table border="1">
                <tr>
                    <td> Name </td>
                    <td> Pass </td>
                    <td> Role </td>
                </tr>
                <%
                  for(User x: lst) {
                %>
                <tr>
                    <td><%= x.getName() %> </td>
                    <td><%= x.getPass() %> </td>
                    <td><%= x.getRole() %> </td>
                    <td><a href="deleteUser?name=<%=x.getName() %>">  Delete </a> </td>
                    <td><a href="updateUser?name=<%=x.getName() %>&pass=<%=x.getPass()%>">  Update </a> </td>
                </tr>  
                <% } %>  
            </table>     
        </div>
        <p class="insert"><a href="insertUser.jsp"> Insert a new user here</a></p>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>

            <%} %>
    </body>
</html>
