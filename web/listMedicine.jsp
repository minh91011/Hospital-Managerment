<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Med" %>
<%@page import = "Model.User" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>List of medicines</title>
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
        List<Med> lst = (List<Med>) request.getAttribute("lst");
        String searchName = (String) request.getAttribute("searchName");
        String searchId = (String) request.getAttribute("med_id");
        if(searchName == null) searchName = "";
        if(searchId == null) searchId = "";
        %>     
        <h2>Minh Son Hospital</h2>
        <div class="hospital">
            <img src="https://png.pngtree.com/thumb_back/fw800/back_our/20190621/ourmid/pngtree-cartoon-medical-banner-poster-image_184431.jpg">
        </div>
        <div class="option">
            <div>
                <p id="active"><a href="listMedicine">List medicines </a></p>
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
                <% if (role == 3) { %><p><a href="listUser.jsp"> View list of users </a></p> <% } %>
                <div class="logout">
                    <p><a href="logout"> Logout </a></p>
                </div>              
            </div>
        </div>
        <%
            if(lst == null){
        %>
        <h2>No medicine</h2>
        <%
        }else{
        %>
        <h2> List of medicine(s) </h2>
        <div class="search">
            <div class="searchName">
                <form action="searchMedName" method="post">
                    <a class="textName">Search name:</a>
                    <input type="text" name="name" value="<%=searchName %>"/>
                    <input class="submitNameId" type="submit" value="search"/>
                </form>
            </div>
            <div class="searchId">
                <form action="searchMedId" method="post">
                    <a class="textId">Search ID:</a>
                    <input type="text" name="med_id" value="<%=searchId %>"/>
                    <input class="submitNameId" type="submit" value="search"/>
                </form>
            </div>
        </div>
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
                    <td><a href="deleteMed?med_id=<%=x.getMed_id() %>">  Delete </a> </td>
                    <% if (role == 3) { %><td><a href="updateMed?med_id=<%=x.getMed_id() %>">  Update </a> </td><% } %>
                </tr>  
                <% }
                }   
                %>  
            </table>   
        </div>  
        <p class="insert"><a href="insertMedicine.jsp"> Insert a new Medicine here</a></p>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>


            <%} %>
    </body>
</html>

