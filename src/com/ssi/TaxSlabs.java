package com.ssi;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TaxSlabs")
public class TaxSlabs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/vnd.ms-excel");
		
		String file="d:/data/TaxRates.xlsx";
		FileInputStream fis=new FileInputStream(file);
		int n=fis.available();
		byte b[]=new byte[n];
		fis.read(b);
		fis.close();
		
		ServletOutputStream out=response.getOutputStream();
		out.write(b);
		out.close();
		
	}

}
