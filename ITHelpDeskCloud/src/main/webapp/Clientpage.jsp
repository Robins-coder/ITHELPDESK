<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ClientPage</title>
<link rel="stylesheet" type="text/css" href="css/ClientPage.css">
<link rel="stylesheet" type="text/css" href="css/viewSupportRequestTable.css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

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

<%-- Client Options --%>  

<div class="client-Header"> 
   
   <div class="k">ChatBox</div>
   
   <div class="k" id="newSupportRequest">New Support request</div>
   
   <div class="k" id="viewSupportRequestfield">view Support request</div>
   
   <!-- <div class="k">Update support request</div> -->
   
   <div class="k" id="listMyAllRequest">List my request</div>

             <div class="k">LOGOUT   

                   <form action="/LogOut" method="post">

                        <input type="submit" style="opacity: 0;height:100%;width: 100%;">

                   </form>

             </div>  
</div>
   
<%-- Client Options End  --%>
   
<div id="myOptions">loading....</div> 
 
 <%-- CreateRequest--%>
 
<div>

         <form action="/createRequest" method="post" class="createRequestForm" id="createRequestForm" hidden>

                <label>Subject</label> <input type="text"  name="Subject" placeholder="Subject" required="required">  

                      <br><br>

                <label>Description</label><input type="text" name="Description" placeholder="Description" required="required" style="height: 90px;width: 100px">

                     <br><br><br><br>

               <input id="submit" type="submit" style="margin-left:65px;margin-bottom:30px;border-radius:10px;">

         </form>

</div>

<%-- CreateRequest End--%>


<!-- View Support Request Table  -->
<div class="viewSupportRequestTable-Header">

         <table id="viewSupportRequestTable"   hidden >

               <thead>
                      <tr>
                          <th>Ticket</th>
         
                          <th>Subject</th>
           
                          <th>Description</th>
           
                          <th style="width: 10%">View</th>
           
                          <th style="width: 10%">Update</th>
                       </tr>
                </thead>
   
                 <tbody>
                     
                     <!-- loaded data base data here !!!  -->
                
                 </tbody>
   
          </table>

</div>



<!-- View All Type Of Support Request Table  except Close Status  -->
<div class="viewAllSupportRequestTable-Header">

         <table id="viewAllSupportRequestTable"   style="display: none;" >

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
<div id="myModal" class="modal" style="display: block;">

  <!-- Modal content -->
       <div class="modal-content" id="modal-content">
  
                <span class="close">X</span>
        
                 <p>Some text in the Modal..</p>

       </div>

</div>




<!-- Update Individual Ticket -->

<div class="Updatemodal" hidden>
    
    <div class="createRequestForm" >

              <label>Subject</label> <input type="text"  id="SubjectUpdate" name="Subject" placeholder="Subject" required="required">  

                     <br><br>

              <label>Description</label><input type="text" id="DescriptionUpdate" name="Description" placeholder="Description" required="required" style="height: 90px;width: 100px">

                    <br><br><br><br>

              <input id="TicketId" hidden>

                      <span  onclick="updateTicket()"  style="margin-left:65px;margin-bottom:30px;border-radius:10px;">UPDATE</span>

                      <span class="CancelUpdate">CANCEL</span>
    </div>

</div>


<!-- Scripts write in below -->

<script type="text/javascript">

//newSupportRequestForm

const element = document.getElementById("newSupportRequest");

element.addEventListener("click", newSupportRequest);


function newSupportRequest() {
	   
	    var table=document.getElementById("viewSupportRequestTable");
	    
	    table.style.display="none";

	    document.getElementById("viewAllSupportRequestTable").style.display="none";
	    
	   var form=document.getElementById("createRequestForm");
	   
	    if (form.style.display === 'none') {
		    //  this SHOWS the form
		    form.style.display = 'block';
		  } else {
		    //  this HIDES the form
		    form.style.display = 'none';
		  }  
 }

  
  //VIEW THE FULL DETAILS OF TICKETS
  $(document).ready(function(){
	   
	  $('#viewSupportRequestfield').click(function(){
		 
		  var createsupportRequest=document.getElementById("createRequestForm");
		 
		  createsupportRequest.style.display="none";
		  
		  document.getElementById("viewAllSupportRequestTable").style.display="none";
		  
		  var table=document.getElementById("viewSupportRequestTable");
		  
		  if(table.style.display==="none")
		  {
			  table.style.display="block";
		  }
		  else
		  {
			  table.style.display="none";
		  }
		  
		  if(table.style.display==="block")
		  {
			  var row="";
		
			  $.ajax({
				  
				  url:'/ViewSupportRequest',
				
				  method:'POST',
				  
				  dataType: "json",
				  
				  success:function(response)
				  {   
					  for(var i=0;i<response.length;i++)
					  {     
						    var obj=response[i];
					
						    var TicketID=obj.TicketID;
							
						    row+="<tr><td>"+obj.TicketID+"</td><td>"+obj.Subject+"</td><td>"+obj.Description+"</td><td onclick='viewTicketID(id)' id="+ TicketID + ">VIEW</td><td onclick='editTicketID(id)' id="+ TicketID + ">EDIT</td></tr>"
					  }
	                 
					  $("#viewSupportRequestTable tbody").html(row);
				  }
			  });
	  
		  }
		 		  
	  });
	  
  });
 
  
    //UpdateForm-1
   //GET SUBJECT AND DESCRIPTION DETAILS  TO PUT IN UPDATE-FORM
  function editTicketID(id)
  {

	    var Updatemodal=document.getElementsByClassName("Updatemodal")[0];  
    	
	    Updatemodal.style.display = "block";

    	
    	//@ Re-Use ViewSupRequestFulDetailController
    	$.ajax({
   		 
  		  url:'/ViewSupRequestFulDetailController',
  		  
  		  method:'POST',
  		  
  		  data: {TicketIds:id},
  		  
  		  dataType:'json',
  		  
  		  success:function(data)
  		  {
  				document.getElementById("SubjectUpdate").value=data[0].Subject;
  		  
  				document.getElementById("DescriptionUpdate").value=data[0].Description;
  		        
  				document.getElementById("TicketId").value=id;
  		  },
  		  
  	    });

  }
  
      //UpdateForm-2
     //UPDATE TICKETID 
     
     function updateTicket()
      {
    	  var Subject=document.getElementById("SubjectUpdate").value.trim();
    	  
    	  var Description=document.getElementById("DescriptionUpdate").value.trim();;
          
    	  var TicketID=document.getElementById("TicketId").value;
    	  
          alert(TicketID);
    	  
    	  if( Subject.length== 0 || Description.length==0 )
    	  {
    		  alert(" Field is Empty !!!");
    	  }
    	  else
    	  {
    		  $.ajax({
    			  
    			  url:'/UpdateTicketDetailsController',
    		
    			  method:'POST',
    			  
    			  data:{Subject:Subject,Description:Description,TicketID:TicketID},
    			  
    			  success:function(response)
    			  {   
    				    document.getElementById("SubjectUpdate").value="";
    		    	
    				    document.getElementById("DescriptionUpdate").value="";
    		          
    				    document.getElementById("TicketId").value="";
    		          
    		      	    var Updatemodal=document.getElementsByClassName("Updatemodal")[0];  
    		        	
    		      	    Updatemodal.style.display = "none";
    		          
    		    	   alert(response);
    		          
    		          
    			  }
    		  });
    	  }
    	  
      }
     
  
  //GET-TICKETID TO VIEW INDIVIDUAL TICKETS FULL DETAILS
  function viewTicketID(id)
  {  
	  $.ajax({
		 
		  url:'/ViewSupRequestFulDetailController',
	
		  method:'POST',
		  
		  data: {TicketIds:id},
		  
		  dataType:'json',
		  
		  success:function(data)
		  {
				 var row="<p> <br> SUBJECT : "+data[0].Subject+" <br> DESCRIPTION : "+data[0].Description+" <br> STATUS : "+data[0].Status+" <br> TECHNICIAN : "+ data[0].Technician+"</p>";
			     
				 var modal = document.getElementById("myModal");
				 
				 modal.style.display = "block";

				 $("#modal-content p ").html(row);
			  
		  },
		  
	  });
	
  }
  
 
  
  // CLOSE THE VIEW OPTION 
  var span = document.getElementsByClassName("close")[0];

    span.onclick = function() {
    	
    	var modal=document.getElementById("myModal");  
    	
    	modal.style.display = "none";
	}

    
    //CANCEL THE UPDATE OF TICKET 
    var cancelUpdate = document.getElementsByClassName("CancelUpdate")[0];

    cancelUpdate.onclick = function() {
   
    	var Updatemodal=document.getElementsByClassName("Updatemodal")[0];  
    	
    	Updatemodal.style.display = "none";
	}
    
    
    
    $(document).ready(function(){
    	
    	$('#listMyAllRequest').click(function(){
        
    		document.getElementById("createRequestForm").style.display="none";
   			
    		document.getElementById("viewSupportRequestTable").style.display="none";
    		
    		var table=document.getElementById("viewAllSupportRequestTable");
            
    		
    		if(table.style.display==="none")
    		{   
    			table.style.display="block";
    		}
    		else if(table.style.display==="block")
    		{
    			table.style.display="none";
    		}
    		
    		if(table.style.display=="block")
    		{
    			var email="${email}";
        		
        		$.ajax({
                
        			 url:'/ViewAllRequestController',
                	
        			 method:'POST',
                	 
        			 data:{emailid:email},
                	 
        			 dataType:'json',
                	 
        			 success:function(response)
                	  {
                           var row="";
        				  for(var i=0;i<response.length;i++)
    					  {     
    						    var obj=response[i];
    					
    						    row+="<tr><td>"+obj.TicketID+"</td><td>"+obj.Subject+"</td><td>"+obj.Description+"</td><td>"+obj.Status+"</td><td>"+obj.SupportTechEmailId+"</td></tr>"
    					  }
    	                 
    					  $("#viewAllSupportRequestTable tbody").html(row);
        				 
                	  }
                      
        			 
                  });	
    		}
    		
    	});
    });
    
</script> 


</body>
</html>