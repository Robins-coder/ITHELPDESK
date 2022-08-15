<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>

<html>

 <head>

      <meta charset="ISO-8859-1">

         <title>AdminPage</title>

            <link rel="stylesheet" type="text/css" href="css/AdminPage.css">

            <link rel="stylesheet" type="text/css" href="css/ClientPage.css">
            
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 

            <link rel="stylesheet" type="text/css" href="css/viewSupportRequestTable.css">

 </head>

<body>

 <% 
       
       response.setHeader("Cache-Control", "no-store");
    
       if(session.getAttribute("email")==null)
       {
    	   response.sendRedirect("login.jsp");
       }
       
  %>
   
   welcome Admin...<br> ${email} 
  
  
 <div class="client-Header"> 
  
             <div class="options">chatBox</div> 
             
             <div class="options" id="newSupportRequest">New Support Request</div>
             
             <div class="options" id="ViewSupportRequest">ViewSupportRequest</div>
   
             <div class="options">DeleteSupportRequest and updateSupportRequest</div> 
   
             <div class="options">Archieve request</div>
             
             <div class="options" id="listAllRequest">List all request</div>
             
             <div class="options" id="listMyrequest">List my request</div> 
   
             <div class="options">list trashed request</div> 
             
             <div class="options"> LOGOUT
                      
                   <form action="/LogOut" method="post">

                        <input type="submit" style="opacity: 0;height:100%;width: 100%;">

                   </form>

             </div>

</div>

            
<%--           <!-- Create Request (TicketId) -->
          <s:form action="/createRequest-admin">
          
                    <s:textfield name="Subject" label="SubjectDetail" ></s:textfield>
                  
                    <s:textfield name="Description" label="DescriptionDetail"></s:textfield>
                  
                    <s:submit value="submit" > </s:submit>          
          
          </s:form>
 --%> 
 
 
 
 <div id="myOptions">loading....</div> 
 
 <%-- CreateRequest--%>
 
<div>

         <form class="createRequestForm" id="createRequestForm" style="display: none;">

                <label>Subject</label> <input type="text" id="Subject" name="Subject" placeholder="Subject" required="required">  

                      <br><br>

                <label>Description</label><input type="text" id="Description" name="Description" placeholder="Description" required="required" style="height: 90px;width: 100px">

                     <br><br><br><br>

               <span  onclick="raiseRequest()"  style="margin-left:65px;margin-bottom:30px;border-radius:10px;">Submit</span>
         
         </form>

</div>




<!-- View All Type Of Support Request Table  except Close Status  -->
<div class="viewAllSupportRequestTable-Header">

         <table id="viewSupportRequestTable"   style="display: none;" >

               <thead>
                      <tr>
                          
                          <th>Ticket</th>
         
                          <th>Subject</th>
           
                          <th>Description</th>
           
                          <th>ClientMailID</th>
         
                          <th>Status</th>
         
                          
                          <th> CONFIRM </th>
                       
                       </tr>
                </thead>
   
                 <tbody>
                     
                     <!-- loaded data base data here !!!  -->
                
                 </tbody>
   
          </table>

</div>



<!-- View All Type Of Support Request Table  except Close Status  -->
<div class="viewSupportRequest-Header">

         <table id="viewSupportRequest"   style="display: none;" >

               <thead>
                      <tr>
                          
                          <th>Ticket</th>
         
                          <th>Subject</th>
           
                          <th>Description</th>
           
                          <th>Status</th>
           
                          <th>TechMailID</th>
           
                          
                          
                       
                       </tr>
                </thead>
   
                 <tbody>
                     
                     <!-- loaded data base data here !!!  -->
                
                 </tbody>
   
          </table>

</div>


<!-- The Modal -->
<div id="myModal" class="modals">
  <!-- Modal content -->
       <div class="modal-content" id="modal-content">
                <input id="ticketid" hidden >
                <input id="emailid" hidden>  
                <span class="confirm" onclick="confirmTicket()">CONFIRM</span>
                <span class="close">CANCEL</span>
        
       </div>

</div>




<div class="viewAllSupportRequestTable-Header">

         <table id="viewAllAdminPickRequest"   style="display: none;" >

               <thead>
                      <tr>
                          
                          <th>Ticket</th>
         
                          <th>Subject</th>
           
                          <th>Description</th>
           
                          <th>ClientMailID</th>
         
                          <th>Status</th>
         
                       
                       </tr>
                </thead>
   
                 <tbody>
                     
                     <!-- loaded data base data here !!!  -->
                
                 </tbody>
   
          </table>

</div>



<script >

const showSupportRequestForm = document.getElementById("newSupportRequest");

showSupportRequestForm.addEventListener("click", showSupportRequestforms);

    	  function showSupportRequestforms(){
		
		         var form=document.getElementById("createRequestForm");
		   
		          if (form.style.display === 'none') {
			         //  this SHOWS the form
			         form.style.display = 'block';
			      } else {
			         //  this HIDES the form
			         form.style.display = 'none';
			      }  
		   }


    	  
    	  
   function raiseRequest() 
   {
       var subject=document.getElementById("Subject").value;
		
	    var description=document.getElementById("Description").value;
		
	    
	    var email="${email}";
			
	    alert(email+" "+subject+" "+description);
	    
	      $.ajax({
	    	  
				url:'/AdminRaiseRequest',
				
				method:'POST',
			    
				data: {subject:subject,description:description,emailid:email},
			    
				success:function(response)
				{
					document.getElementById("Subject").value="";
					
				    document.getElementById("Description").value="";
			    	
				    alert(response);
				
				},
			    
			});	   
   }	  

   
   //listMyrequest

   const listMyrequestID = document.getElementById("listMyrequest");

   listMyrequestID.addEventListener("click", listMyrequest);

   
   function listMyrequest()
   {
	      let viewSupportRequestTable=document.getElementById("viewSupportRequestTable");
		 
	      viewSupportRequestTable.style.display="none";
		  
		  
		  let table=document.getElementById("viewSupportRequest");
		  
		  if(table.style.display==="none")
		  {
			  table.style.display="block";
		  }
		  else 
		  {
			  table.style.display="none";
		  }  
	   
	   
	     if(table.style.display="block")
	     {
	    	 var emailid="${email}";
	 	    
	 	    $.ajax({
	 	    	url:"/ViewAllRequestController",
	 	    	method:"POST",
	 	    	data:{emailid:emailid},
	 	    	dataType:'json',
	 	    	success:function(response)
	 	    	{
	 	    		  var row="";
	 	    		  
	 				  for(var i=0;i<response.length;i++)
	 				  {     
	 					    var obj=response[i];
	 				
	 					    
	 					    row+="<tr><td>"+obj.TicketID+"</td><td>"+obj.Subject+"</td><td>"+obj.Description+"</td><td>"+obj.Status+"</td><td>"+obj.SupportTechEmailId+"</td></tr>"
	 				  }
	                  
	 				  $("#viewSupportRequest tbody").html(row);
	 	    	}
	 	    
	 	    });
 	 
	     }
	   	   
   }
   

   //ViewSupportRequest

   const ViewSupportRequestID= document.getElementById("ViewSupportRequest");

   ViewSupportRequestID.addEventListener("click", ViewSupportRequestAction);
   
   
   function ViewSupportRequestAction()
   {
	   
	      let table=document.getElementById("viewSupportRequestTable");
		  
		  if(table.style.display==="none")
		  {
			  table.style.display="block";
		  }
		  else 
		  {
			  table.style.display="none";
		  }  
	   
	   
	     if(table.style.display="block")
	     {
	   
	   
        emailid="${email}";
        
        $.ajax({
               url:'/AllogatedSYSAdmin',
               method:"POST",
               data:{emailid:emailid},
               dataType:'json',
              
               success:function(response)
               {
         		  let row="";
 	    
         		  for(let i=0;i<response.length;i++)
 				  {     
 					    let obj=response[i];
 				        
 					    row+="<tr><td>"+obj.TicketID+"</td><td>"+obj.Subject+"</td><td>"+obj.Description+"</td><td>"+obj.ClientEmailID+"</td><td>"+obj.Status+"</td><td onclick='getTicketId(id,emailid);' id="+obj.TicketID+">CONFIRM</td></tr>"
 				  }
                  
 				  $("#viewSupportRequestTable tbody").html(row);
               }
        });
   }
   }
   
   
   function getTicketId(id,emailid)
   {
	       
	       document.getElementsByClassName("modals")[0].style.display="block";
      
	       document.getElementById("ticketid").value=id;	   
           document.getElementById("emailid").value=emailid;
           
   }
   
   
   function confirmTicket()
   {
	   
	   let ticketid=document.getElementById("ticketid").value;
	   let emailid=document.getElementById("emailid").value;
	   
	   alert(" "+ticketid+" "+emailid);

       $.ajax({
    	   url:'/Confirm',
    	   method:'POST',
    	   data:{ticketid:ticketid,emailid:emailid},
    	   success:function(response)
    	   {
    		   alert(response);
    	   }
       });
	   
	   
   }
   
   
   // CLOSE THE VIEW OPTION 
   var span = document.getElementsByClassName("close")[0];

     span.onclick = function() {
     	
     	var modal=document.getElementById("myModal");  
     	
     	modal.style.display = "none";
 	}
   
     
     
     //listAllRequest
     
   const listAllRequestID= document.getElementById("listAllRequest");

   listAllRequestID.addEventListener("click", listAllRequestAction);
        
     
   function   listAllRequestAction()
   {
	   
	      let viewSupportRequestTable=document.getElementById("viewSupportRequestTable");
		 
	      viewSupportRequestTable.style.display="none";
		  
	      
		  
		  let table=document.getElementById("viewAllAdminPickRequest");
		  
		  if(table.style.display==="none")
		  {
			  table.style.display="block";
		  }
		  else 
		  {
			  table.style.display="none";
		  }  
	   
	   
	     if(table.style.display="block")
	     {
	   
	    	 var  emailid="${email}";
	   	  
	    	   var row="";
	   	  
	   	       $.ajax({
	   		  
	   		        url:'/ViewAllAdminPickRequest',
	   		        
	   		        method:'POST',
	   		        
	   		        data:{emailid:emailid},
	   		        
	   		        dataType:'json',
	   		        
	   		        success:function(response)
	   		        {
	   			      alert(response);  


	         		  for(let i=0;i<response.length;i++)
	 				  {     
	 					    let obj=response[i];
	 				        
	 					    row+="<tr><td>"+obj.TicketID+"</td><td>"+obj.Subject+"</td><td>"+obj.Description+"</td><td>"+obj.ClientMail+"</td><td>"+obj.Status+"</td></tr>"
	 				  }

	   			      
		   		     $("#viewAllAdminPickRequest tbody").html(row);
	   		        },

	   	  });
	  
	  
	     }
	   
   }
       
   
</script>


</body>

</html>