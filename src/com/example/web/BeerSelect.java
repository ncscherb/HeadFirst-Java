package com.example.web;

import com.example.model.*;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeerSelect extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		BeerExpert beerExpert=new BeerExpert();
		
		response.setContentType("text/html");
		
		List<String> result=beerExpert.getBrands(request.getParameter("color"));
		
//		PrintWriter outPrintWriter= response.getWriter();
//		outPrintWriter.print("Beer Selection Advice<br/>");
//		
//		Iterator<String> iterator =result.iterator();
//		while(iterator.hasNext())
//		{
//			outPrintWriter.print("<br/>try:"+iterator.next());
//		
//		}
		
		request.setAttribute("styles",result);
		
		RequestDispatcher view= request.getRequestDispatcher("result.jsp");
		
		view.forward(request, response);
	}
}
