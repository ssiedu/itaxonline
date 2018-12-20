package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TaxProcessor
 */
@WebServlet("/TaxProcessor")
public class TaxProcessor extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//reads the request
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		
		//process the request
		int income=Integer.parseInt(s1);
		int age=Integer.parseInt(s2);
		int rebate=0, nettax=0;
		int tax=0;
		if(income>=500000){
			tax=income*20/100;
		}else{
			tax=income*10/100;
		}
		
		if(age>=60){
			rebate=tax*10/100;
		}
		nettax=tax-rebate;
		
		//provides the response
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Thanks For Visiting Us</h3>");
		out.println("<table border=2>");
		out.println("<tr>");
		out.println("<td>Income</td>");
		out.println("<td>"+income+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Rebate</td>");
		out.println("<td>"+rebate+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Net-Tax</td>");
		out.println("<td>"+nettax+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<marquee>Pay Your Taxes Before 31st March</marquee>");
		out.println("<h4><a href=index.jsp>Home</a></h4>");
		out.println("</body>");
		out.println("</html>");
		
		
		out.close();
		
	}

}
