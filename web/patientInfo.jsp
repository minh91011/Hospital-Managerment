<%-- 
    Document   : patientInfo
    Created on : Oct 5, 2022, 11:05:23 AM
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
        <title>Patient information</title>
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
           List<Prescription> lst = (List<Prescription>) request.getAttribute("lst");
           Patient x = (Patient) request.getAttribute("x");
           String room = (String) request.getAttribute("room");
           String gender; 
           if(x.isGender()) gender = "Nam";
           else gender = "Nu";
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
        <h2>Patient found</h2>
        <div class="formInsert">
            <ul>
                <li><h3>Pa_id: <%= x.getPa_id() %> </h3></li>
                <li><h3>FullName: <%= x.getFullName() %> </h3></li>
                <li><h3>BirthDay: <%= x.getBirthday() %></h3></li>
                <li><h3>Gender: <%= gender %> </h3></li>
                <li><h3>Address: <%= x.getAddress() %> </h3></li>   
                <li><h3>OutPatient: <%= x.isOutPatient() %> </h3></li>
                <li><h3>Room: <%= room %> </h3></li>         
                <li><h3>HealthInsurance: <%= x.isHealthInsurance() %> </h3></li>
                <li><h3>Doc_id: <%= x.getDoc_id() %> </h3></li>
            </ul>
        </div>
        <h2> Prescription  </h2>
        <p class="insert"><a href="insertPrescription?pa_id=<%=x.getPa_id()%>">Insert new Prescription</a></p>
        <table border="1">
            <tr>
                <td> Med_id </td>
                <td> Time </td>
            </tr>
            <%
              for(Prescription p : lst) {
            %>
            <tr>
                <td><%= p.getMed_id() %> </td>
                <td><%= p.getTime() %> </td>
            </tr>  
            <% } %>  
        </table>
    </div>
    <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>
    <p class="back"><a href="createBill?pa_id=<%=x.getPa_id() %>">  Create Bill</a></p>    




        <%} %>

</body>
</html>

