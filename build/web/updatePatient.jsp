<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Patient" %>
<%@page import = "Model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/list.css"/>
        <title>Update Patient</title>
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
         Patient x = (Patient) request.getAttribute("x");
         if(x==null) return;
        %>    
        <h2>Update new patient</h2>
        <div class="formInsert">
            <form action="updatePatient" method="POST">
                <input type="hidden" name="updateID" value="<%=x.getPa_id()%>">
                <ul>

                    <li><p>Id<input type="text" name="pa_id" value="<%=x.getPa_id()%>" readonly> </p></li>
                    <li><p>FullName<input type="text" name="fullname" value="<%=x.getFullName()%>"> </p></li>
                    <li><p>Birthday <input type="date" name="birthday" value="0001-12-30"> </p></li>
                    <li><p>Gender 
                            <input type="radio" name="gender" value="1" checked> <label >Male</label>
                            <input type="radio"  name="gender" value="0"> <label>Female</label>
                        </p></li>

                    <li><p>Address<input type="text" name="address" value="<%=x.getAddress()%>"> </p></li>
                    <li><p>OutPatient
                            <input type="radio" name="outpatient" value="1" checked> <label >Yes</label>
                            <input type="radio"  name="outpatient" value="0"> <label>No</label>
                        </p></li>
                    <li><p>HealthInsurance
                            <input type="radio" name="hi" value="1" checked> <label >Yes</label>
                            <input type="radio"  name="hi" value="0"> <label>No</label>
                        </p></li>
                    <li><p>Doc_id<input type="text" name="doc_id" value="<%=x.getDoc_id()%>"> </p></li>
                    <li><p><input type="submit" value="updatePatient"></p></li>
                </ul>
            </form>
        </div>
        <p class="back"><button onclick='window.history.go(-1);'>Back to previous page</button>





            <%} %>
    </body>
</html>