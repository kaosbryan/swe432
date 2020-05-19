import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;


@WebServlet(name = "finalExam", urlPatterns = "/finalExam")
public class finalExam extends HttpServlet {
		
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
		out.println("function PromptbooleanName1 ()");
		out.println("{");
		out.println("   status = \"booleanName1\";");
		out.println("}");
		
		out.println("function PromptbooleanName2 ()");
		out.println("{");
		out.println("   status = \"booleanName2\";");
		out.println("}");
		
		out.println("function PromptbooleanName3 ()");
		out.println("{");
		out.println("   status = \"booleanName3\";");
		out.println("}");
		
		out.println("function PromptbooleanName4 ()");
		out.println("{");
		out.println("   status = \"booleanName4\";");
		out.println("}");
		
		out.println("");
		out.println("function IsInt (string)");
		out.println("{");
		out.println("   var val = parseInt (string);");
		out.println("   return (val > 0);");
		out.println("}");
		out.println("");
		out.println("function IsPos (string)");
		out.println("{");
		out.println("   var val = parseInt (string);");
		out.println("   return (val > 0);");
		out.println("}");
		out.println("function IsNumeric (FieldValue)");
		out.println("{");
		out.println("   var FieldLen = FieldValue.length;");
		out.println("   if (FieldLen == 0)");
		out.println("   {");
		out.println("      return (false);");
		out.println("   }");
		out.println("   for (var i=0; i<FieldLen; i++)");
		out.println("   {");
		out.println("      if (isNaN (parseInt (FieldValue.charAt (i))))");
		out.println("      {");
		out.println("         return (false);");
		out.println("      }");
		out.println("   }");
		out.println("   return (true);");
		out.println("}");
		
		out.println("function CheckRegistration()");
		out.println("{");
		out.println("   var ErrMsg = \"\";");
		out.println("   var NumErr = 0;");
		out.println("   var booleanName1 = document.RegisterForm.booleanName1;");
		out.println("   if (booleanName1.value == \"\")");
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Missing variable name1.\";");
		out.println("   }");
		
		out.println("   var booleanName2 = document.RegisterForm.booleanName2;");
		out.println("   if (booleanName2.value == \"\")");
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Missing variable name2.\";");
		out.println("   }");
		
		out.println("   var operater = document.querySelector( 'input[name=\"operater\"]:checked');"); 
		out.println("   if(operater == null)"); 
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Please select an boolean operater.\";");
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
		out.println("<form method=\"post\" action=\" finalExam\" name=\"RegisterForm\" onSubmit=\"return (CheckRegistration())\">");
		out.println("<table>");
		     
		out.println("<tr>");
		out.println("<td>Boolean variable name1:");
		out.println("<td><input type=\"text\" name=\"booleanName1\" onFocus = \"PromptbooleanName1()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
		out.println("<br>");
		out.println("<tr>");
		
		out.println("<tr>");
		out.println("<td>Boolean variable name2:");
		out.println("<td><input type=\"text\" name=\"booleanName2\" onFocus = \"PromptbooleanName2()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
		out.println("<br>");
		out.println("<tr>");
 
		out.println("<tr>");
		out.println("<td>Boolean variable name3 or leave empty if there is no third variable:");
		out.println("<td><input type=\"text\" name=\"booleanName3\" onFocus = \"PromptbooleanName3()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
		out.println("<br>");
		out.println("<tr>");
		
		out.println("<tr>");
		out.println("<td>Boolean variable name4 or leave empty if there is no fourth variable:");
		out.println("<td><input type=\"text\" name=\"booleanName4\" onFocus = \"PromptbooleanName4()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
		out.println("<br>");
		out.println("<tr>");

		out.println("<tr>");
		out.println("<td><p>Which logical operater do you want to use?</p><br>");
		out.println("<td><input type=\"radio\" name=\"operater\" value=\"and\"> and");
		out.println("<td><input type=\"radio\" name=\"operater\" value=\"or\"> or");
		out.println("</tr>");
		
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
		String b1 = request.getParameter("booleanName1");
		String b2 = request.getParameter("booleanName2");
		String b3 = request.getParameter("booleanName3");
		String b4 = request.getParameter("booleanName4");
		String op = request.getParameter("operater");

		if (op.contentEquals("or")) {
			if (b3.contentEquals("") && b4.contentEquals("")) {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + b1 + "</th>");
				out.print("<th>" + b2 + "</th>");
				out.print("<th>" + op + " output" + "</th>");
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
			else if (b4.contentEquals("")) {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + b1 + "</th>");
				out.print("<th>" + b2 + "</th>");
				out.print("<th>" + b3 + "</th>");
				out.print("<th>" + op + " output" + "</th>");
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
			else {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + b1 + "</th>");
				out.print("<th>" + b2 + "</th>");
				out.print("<th>" + b3 + "</th>");
				out.print("<th>" + b4 + "</th>");
				out.print("<th>" + op + " output" + "</th>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
			    out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
			    out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
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
				out.print("<td>0</td>");
				out.print("</tr>");
				out.print("</table>");
			}
			
		}
		if (op.contentEquals("and")) {
			if (b3.contentEquals("") && b4.contentEquals("")) {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + b1 + "</th>");
				out.print("<th>" + b2 + "</th>");
				out.print("<th>" + op + " output" + "</th>");
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
			else if (b4.contentEquals("")) {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + b1 + "</th>");
				out.print("<th>" + b2 + "</th>");
				out.print("<th>" + b3 + "</th>");
				out.print("<th>" + op + " output" + "</th>");
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
			else {
				out.print("<table style=\"width:50%\">");
				out.print("<tr>");
				out.print("<th>" + b1 + "</th>");
				out.print("<th>" + b2 + "</th>");
				out.print("<th>" + b3 + "</th>");
				out.print("<th>" + b4 + "</th>");
				out.print("<th>" + op + " output" + "</th>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
			    out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
			    out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("<td>1</td>");
				out.print("<td>0</td>");
				out.print("<td>0</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>0</td>");
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