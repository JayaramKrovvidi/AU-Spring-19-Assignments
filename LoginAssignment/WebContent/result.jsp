<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<title>Using GET and POST Method to Read Form Data</title>
</head>
<body>
    <h1>Using GET Method to Read Form Data</h1>
    <ul>
        <li><p>
                <b>Name:</b>
                <%=request.getParameter("firstname")%>
            </p></li>
    </ul>
    	<c:set var = "password" scope = "session" value = "${request.getParameter('password')}"/>
    	<c:if test="${ password.equals('hello')}">
    		<p>Password correct/><p>
    	</c:if>
    	
    <%
         Integer accesses = (Integer)application.getAttribute("logins");
         if( accesses ==null || accesses == 0 ) {
           	out.println("Welcome to my website!");
           	accesses = 1;
         } 
         else {
            out.println("Welcome back to my website!");
	        accesses += 1;
         }
         application.setAttribute("logins", accesses);
      %>
      <center>
         <p>Total number of visits: <%= accesses%></p>
      </center>
</body>
 </html>