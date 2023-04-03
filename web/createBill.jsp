<%-- 
    Document   : createBill
    Created on : Oct 17, 2022, 8:57:48 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Bill" %>
<%@page import = "Model.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill</title>
    </head>
    <body>
                <%
           User u = (User) request.getSession().getAttribute("currUser");
           if(u==null){
        %>

        <h2> You cant access this page ! </h2>
        <% return;} 
        else {    
          Bill x = (Bill) request.getAttribute("bill");
        %> 
        <h2> <%= x.getPa_id() %> 's bill</h2>
        <h3>Pa_id: <%= x.getPa_id() %> </h3>
        <h3>Room charge: <%= x.getRoom_charge() %> </h3>
        <h3>Med charge: <%= x.getMed_charge() %></h3>
        <h3>Start date: <%= x.getStartDate() %> </h3>
        <h3>End date: <%= x.getEndDate() %> </h3>   
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <%if(u.getRole()==3){%><p><a href="index.jsp">Back to homepage</a></p><%}%>
        <%if(u.getRole()==2){%><p><a href="doctorPage.jsp">Back to homepage</a></p><%}%>
        <%if(u.getRole()==1){%><p><a href="nursePage.jsp">Back to homepage</a></p><%}%>


        <%} %>
    </body>
</html>
