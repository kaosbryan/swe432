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
        String para = "";
        out.print("<html>\n<head>\n\n");
        out.print("<title>SWE 432 Bryan Zheng</title>\n");
        out.print("</head>\n");
        out.print("<body>\n");
        out.print("<center><h2>Bryan Zheng  ------- Bathroom Review Form</h2></center>\n");
        out.print("<hr>\n");
        while (paraNames.hasMoreElements()) {  
            para = (String)paraNames.nextElement();
            if (!para.equalsIgnoreCase("submit"))
            {
                out.print("  <tr>");
                out.print("    <td style=\"width: 20%\" width=\"20%\"><b>" + para + "</b></td>");

                String[] values = req.getParameterValues(para);

                if (values != null && !values[0].equals(""))
                out.print("    <td>" + values[0] + "</td></tr>");
                else
                out.print("    <td>&nbsp;</td></tr>");

                for (int i = 1; i < values.length; i++)
                {
                    if (!values[i].equals(""))
                    {
                    out.print("  <tr>");
                    out.print("    <td style=\"width: 20%\" width=\"20%\">&nbsp;</td>");
                    out.print("    <td>" + values[i] + "</td></tr>\n");
                    }
                }
            }
        }
        out.print("</body>\n");
        out.print("</html>\n");
        out.close();
    }
}
