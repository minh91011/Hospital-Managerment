<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Nurse" %>
<%@page import = "Model.User" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>List of nurses</title>
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
         List<Nurse> lst = (List<Nurse>) request.getAttribute("lst");
        String searchName = (String) request.getAttribute("searchName");
        String searchId = (String) request.getAttribute("nu_id");
        if(searchName == null) searchName = "";
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
        <%
        if(lst == null){
        %>
        <h2>No nurse</h2>
        <%
        }else{
        %>  

        <h2> List of nurses </h2>
        <div class="search">
            <div class="searchName">
                <form action="searchNurseName" method="post">
                    <a class="textName">Search name:</a>
                    <input type="text" name="name" value="<%=searchName %>"/>
                    <input class="submitNameId" type="submit" value="search"/>
                </form>
            </div>
            <div class="searchId">
                <form action="searchNurseId" method="post">
                    <a class="textId">Search ID:</a>
                    <input type="text" name="nu_id" value="<%=searchId %>"/>
                    <input class="submitNameId" type="submit" value="search"/>
                </form>
            </div>
        </div>
        <table border="1">
            <tr>
                <td> Nu_id </td>
                <td> FullName </td>
                <td> BirthDay </td>
                <td> gender </td>
                <td> address </td>
            </tr>
            <%
              for(Nurse x : lst) {
              String gender;
                if(x.isGender()) gender = "Nam";
                else gender = "Nu";
            %>
            <tr>
                <td><%= x.getNu_id() %> </td>
                <td><%= x.getFullName() %> </td>
                <td><%= x.getBirthDay() %> </td>
                <td><%= gender %> </td>
                <td><%= x.getAddress() %> </td>
                <td><a href="deleteNurse?id=<%=x.getNu_id() %>">  Delete </a> </td>
                 <% if (role == 3) { %><td><a href="updateNurse?nu_id=<%=x.getNu_id() %>">  Update </a> </td><% } %>
                <td><a href="searchNurseId?nu_id=<%=x.getNu_id() %>">  Info </a> </td>
            </tr>  
            <% } 
            }
            %>  
        </table>     
        <p class="insert"><a href="insertNurse.jsp"> Insert a new nurse here</a></p>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>

        <%}%>
    </body>
</html>

