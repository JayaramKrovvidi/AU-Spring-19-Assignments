<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
	<h3>Login Form</h3>  
	<%  
	String profile_msg=(String)request.getAttribute("profile_msg");  
	if(profile_msg!=null){  
	out.print(profile_msg);  
	}  
	String login_msg=(String)request.getAttribute("login_msg");  
	if(login_msg!=null){  
	out.print(login_msg);  
	}  
	 %>  
	 <br/>  
	<form action="/Spring-RestController/rest/employee/create" method="post" model-attribute="employee">  
		Id:<input type="text" name="id"/><br/><br/>  
		Name:<input type="text" name="name"/><br/><br/>  
		<input type="submit" value="Submit"/>"  
	</form>  
</body>
</html>