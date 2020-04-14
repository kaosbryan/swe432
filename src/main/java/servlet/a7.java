package servlet;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "a7", urlPatterns = {"/a7"})
public class a7 extends HttpServlet{
  @Override
   protected void doPost (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException{
        Enumeration paraNames = req.getParameterNames();
        PrintWriter out = res.getWriter();
        String element = "";
		out.print("<html>\n<head>\n\n");
		out.print("<title>SWE 432 Bryan Zheng</title>\n");
		out.print("</head>\n");
		out.print("<body>\n");
		out.print("<center><h2>Bryan Zheng  ------- Bathroom Review Form</h2></center>\n");
		out.print("<hr>\n");
		while (paraNames.hasMoreElements()) {
		    element = (String)paraNames.nextElement();
		    out.print(element);
		}
    }
}
