<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<body>
    <form action="result.jsp" method="GET">
    	<input type="hidden" name="submitted" value="true">
        <c:if test="${param.submitted && empty param.firstname}">
         	Please enter your Name
        </c:if>
        First Name: <input type="text" name="firstname"> <br/>
        <c:if test="${param.submitted && empty param.password}">
         	Please enter your password
        </c:if>
        Last Name: <input type="password" name="password" /><br/> 
        <input type="submit" value="Submit" />
    </form>
</body>
</html>