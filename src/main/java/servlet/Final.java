import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;


@WebServlet(name = "Final", urlPatterns = "/Final")
public class Final extends HttpServlet {
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("");
		out.println("<head>");
		out.println("<title>[SWE 432] Final EXAM</title>");
		out.println("<link rel=stylesheet href=\"../../432-style.css\" type=\"text/css\">");
		out.println("<style> body {background-color:#ddf8ff} </style>");
		
		out.println("<script>");
		out.println("function ClearStatus ()");
		out.println("{");
		out.println("   status = \"\";");
		out.println("}");
		out.println("function Promptboolean ()");
		out.println("{");
		out.println("   status = \"boolean\";");
		out.println("}");
		
		
		
		out.println("function CheckRegistration()");
		out.println("{");
		out.println("   var ErrMsg = \"\";");
		out.println("   var NumErr = 0;");
		out.println("   var boolean = document.RegisterForm.boolean;");
		out.println("   if (boolean.value == \"\")");
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Missing boolean expression.\";");
		out.println("   }");
		
		
		out.println("   if (NumErr > 0)");
		out.println("   {");
		out.println("      alert (\"Please fix the following fields and submit again\" + ErrMsg);");
		out.println("      return (false);");
		out.println("   }");
		out.println("   else");
		out.println("   {");
		out.println("      return (true);");
		out.println("   }");
		out.println("}");
		out.println("</script>");
		
		out.println("</head>");
		out.println("");
		out.println("<body>");
		out.println("<h1 align=\"center\" >[SWE 432] Bryan Zheng</h1>");
		out.println("<hr/>");
		out.println("<center>");
		out.println("<h1 align=\"center\">Final Exam</h1>");
		out.println("<form method=\"post\" action=\" Final\" name=\"RegisterForm\" onSubmit=\"return (CheckRegistration())\">");
		out.println("<table>");
		     
		out.println("<tr>");
		out.println("<td>Enter Boolean Expression:");
		out.println("<td><input type=\"text\" name=\"boolean\" onFocus = \"Promptboolean()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
		out.println("<br>");
		out.println("<tr>");
		
		out.println("<br>");
		out.println("<br>");
		out.println("<tr><td colspan=2 align=center><input type=\"submit\" name=\"submit\" value=\"Submit\"></tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");

		out.println("</body>");
		out.println("</html>"); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>\n<head>\n\n");
		out.print("<title>SWE 432 Bryan Zheng</title>\n");
		out.print("<style>");
		out.print("table, th, td {");
		out.print("border: 1px solid black;");
		out.print("}");
		out.print("</style>");
		
		out.print("</head>\n");
		out.print("<body>\n");
		out.print("<center><h2>[SWE 432] Bryan Zheng</h2></center>\n");
		out.print("<center><h3>Final Exam</h3></center>\n");
		out.print("<hr>\n");
		String b1 = request.getParameter("boolean");
		String[]a = b1.split(" ");
		/*
		for (int i = 0; i < a.length; i++) {
			if (i == 1) {
				out.println(a[i]);	
			}
		}
		*/
		int error = 0;
		if (a.length % 2 == 0) {
			out.println("invalid boolean expresssion");
			error += 1;
		}
		if (a[1].equals("&") || a[1].equals("&&") || a[1].equals("AND") || a[1].equals("and")) {
			a[1] = "and";
		}
		if (a[1].equals("|") || a[1].equals("||") || a[1].equals("OR") || a[1].equals("or")) {
			a[1] = "or";
		}
		if (!a[1].equals("and") && !a[1].equals("or")) {
			out.println("invalid boolean operater");
			error += 1;
		}
		if (a.length == 5) {
			if (a[3].equals("&") || a[3].equals("&&") || a[3].equals("AND") || a[3].equals("and")) {
				a[3] = "and";
			}
			if (a[3].equals("|") || a[3].equals("||") || a[3].equals("OR") || a[3].equals("or")) {
				a[3] = "or";
			}
			if (!a[3].equals("and") && !a[3].equals("or")) {
				out.println("invalid boolean operater");
				error += 1;
			}
		}
		if (a.length == 3 && error == 0) {
			if (a[1].equals("or")) {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + a[0] + "</th>");
				out.print("<th>" + a[2] + "</th>");
				out.print("<th>" + " or output" + "</th>");
				out.print("</tr>");
				
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>"); 
			}
			if (a[1].equals("and")) {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + a[0] + "</th>");
				out.print("<th>" + a[1] + "</th>");
				out.print("<th>" + "and output" + "</th>");
				out.print("</tr>");
				
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    out.print("</table>");
			}	
		}
		if (a.length == 5 && error == 0) {
			if (a[1].equals("and") && a[3].equals("and")) {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + a[0] + "</th>");
				out.print("<th>" + a[2] + "</th>");
				out.print("<th>" + a[4] + "</th>");
				out.print("<th> boolean output </th>");
				out.print("</tr>");
				
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    out.print("</table>");
			}
			if (a[1].equals("or") && a[3].equals("or")) {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + a[0] + "</th>");
				out.print("<th>" + a[2] + "</th>");
				out.print("<th>" + a[4] + "</th>");
				out.print("<th>" + "boolean output" + "</th>");
				out.print("</tr>");
				
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    out.print("</table>");
			}
			if (a[1].equals("or") && a[3].equals("and")){
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + a[0] + "</th>");
				out.print("<th>" + a[2] + "</th>");
				out.print("<th>" + a[4] + "</th>");
				out.print("<th>" + "boolean output" + "</th>");
				out.print("</tr>");
				
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    out.print("</table>");
			}
			if (a[1].equals("and") && a[3].equals("or")){
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + a[0] + "</th>");
				out.print("<th>" + a[2] + "</th>");
				out.print("<th>" + a[4] + "</th>");
				out.print("<th>" + "boolean output" + "</th>");
				out.print("</tr>");
				
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>1</td>");
			    out.print("<td>1</td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("<td>0</td>");
			    out.print("</tr>");
			    out.print("</table>");
			}
		}
		out.print("</p>");
		out.print("</body>\n");
		out.print("</html>\n");
		out.close();
	}
}