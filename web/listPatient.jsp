<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>List of patients</title>
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
            List<Patient> lst = (List<Patient>) request.getAttribute("lst");
            String searchName = (String) request.getAttribute("searchName");
            String searchId = (String) request.getAttribute("pa_id");
            PatientDAO up = new PatientDAO();
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
        <%
        if(lst == null){
        %>
        <h2>No patient</h2>
        <%
        }else{
        %>  

        <h2> List of patients </h2>
        <div class="search">
            <div class="searchName">
                <form action="searchPatientName" method="post">
                    <a class="textName">Search name:</a>
                    <input type="text" name="name" value="<%=searchName %>"/>
                    <input class="submitNameId" type="submit" value="search"/>
                </form>
            </div>
            <div class="searchId">
                <form action="searchPatientId" method="post">
                    <a class="textId">Search ID:</a>
                    <input type="text" name="pa_id" value="<%=searchId %>"/>
                    <input class="submitNameId" type="submit" value="search"/>
                </form>
            </div>
        </div>
                    <div>
        <table border="1">
            <tr>
                <td> Pa_id </td>
                <td> FullName </td>
                <td> BirthDay </td>
                <td> gender </td>
                <td> address </td>
                <td> outPatient </td>
                <td> Room </td>
                <td> HealthInsurance </td>
                <td> Doc_id </td>
            </tr>
            <%
              for(Patient x : lst) {
              String p = up.getRoomFromPatient(x.getPa_id());
              String gender;
                if(x.isGender()) gender = "Nam";
                else gender = "Nu";
            %>
            <tr>
                <td><%= x.getPa_id() %> </td>
                <td><%= x.getFullName() %> </td>
                <td><%= x.getBirthday() %> </td>
                <td><%= gender %> </td>
                <td><%= x.getAddress() %> </td>
                <td><%= x.isOutPatient() %> </td>
                <td><%= p %></td>
                <td><%= x.isHealthInsurance() %> </td>
                <td><%= x.getDoc_id() %> </td>
                <td><a href="deletePatient?id=<%=x.getPa_id() %>">  Delete </a> </td>
                 <% if (role == 3) { %><td><a href="updatePatient?pa_id=<%=x.getPa_id() %>">  Update </a> </td><%}%>
                <td><a href="searchPatientId?pa_id=<%=x.getPa_id() %>">  Info </a> </td>
            </tr>  
            <% } 
            }
            %>  
        </table>   
                    </div>
        <p class="insert"><a href="insertPatient.jsp"> Insert a new patient here</a></p>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>


        <%} %>

    </body>
</html>

