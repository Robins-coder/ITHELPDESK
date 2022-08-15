package com.Servlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.Business.Logic.ViewSupRequestFulDetail;

@WebServlet("/ViewSupRequestFulDetailController")
public class ViewSupRequestFulDetailController extends HttpServlet{

	private static final long serialVersionUID = 1L;

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	 String TicketID=req.getParameter("TicketIds");
    	 
    	 System.out.println("TicketID : "+TicketID);
     
    	 ViewSupRequestFulDetail detail=new  ViewSupRequestFulDetail();
    	 
         JSONArray array=detail.ViewSupRequestFulDetail(TicketID);	 
         
         resp.getWriter().print(array);
    	 
     }	
	
	
}
