<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>

<link rel="stylesheet" type="text/css" href="css/login.css">

<script type="text/javascript" src="jquery/jquery.js"></script>

</head>

<body>
<div class="loginpage">

<form action="/login" method="Post">

   <br>

   <label class="feild">EmailId</label> <input class="feild" type="email" name="email" id="email" required="required"><br><br>

   <label class="feild">Password</label> <input  class="feild" type="password" name="pass"  id="pass" required="required"><br><br>

   <input id="submit" type="submit" >

 </form>

</div>


<script type="text/javascript" >

$(document).ready(function(){
	
	$('#sdubmit').click(function(){

		var emailid=$('#email').val();
		var pass=$('#pass').val();
		
		if(emailid=="" || pass=="")
		{
			alert(" Please put all the data from login-form");
		}
		else
		{
			 $.ajax({
				 
				 url:'/login',
				 type:'POST',
				 data:{email:emailid,pass:pass},
				 success:function(response)
				 {
					 alert(" response "+response)
				 }
				 
			 });
		}

	});
	
});	         


</script>


</body>

</html>
