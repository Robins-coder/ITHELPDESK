<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Request</title>
</head>
<body>

<% 
       
       response.setHeader("Cache-Control", "no-store");
    
       if(session.getAttribute("email")==null)
       {
    	   response.sendRedirect("login.jsp");
       }
       
%>
    

Client Page ...<br> ${email} 
   
<div>

<form action="/createRequest" method="post">


<label>Subject</label> <input type="text"  name="Subject" placeholder="Subject" required="required">  

<label>Description</label><input type="text" name="Description" placeholder="Description" required="required">

<input id="submit" type="submit" >

</form>

</div>



</body>
</html>