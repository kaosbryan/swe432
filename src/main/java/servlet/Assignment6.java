import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;


@WebServlet(name = "assigment6", urlPatterns = "/Assignment6")
public class Assignment6 extends HttpServlet {
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("");
		out.println("<head>");
		out.println("<title>SWE 432 Review Form</title>");
		out.println("<link rel=stylesheet href=\"../../432-style.css\" type=\"text/css\">");
		out.println("<style> body {background-color:#ddf8ff} </style>");
		
		out.println("<script>");
		out.println("function ClearStatus ()");
		out.println("{");
		out.println("   status = \"\";");
		out.println("}");
		out.println("function PromptBuilding ()");
		out.println("{");
		out.println("   status = \"Building name\";");
		out.println("}");
		out.println("function PromptFloor ()");
		out.println("{");
		out.println("   status = \"Floor number\";");
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
		out.println("   var FloorField = document.RegisterForm.FloorField;");
		out.println("   if (!IsNumeric (FloorField.value))");
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Floor level must be a positive integer.\";");
		out.println("   }");
		out.println("   else if (!IsPos (FloorField.value))");
		out.println("      {");
		out.println("         NumErr++;");
		out.println("         ErrMsg += \"\\n\" + NumErr + \") Floor level must be positive.\";");
		out.println("      }");
		out.println("else if (FloorField.value == \"\")");
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Missing floor level.\";");
		out.println("   }");
		out.println("   var BuildingField = document.RegisterForm.BuildingField;");
		out.println("   if (IsInt (BuildingField.value))");
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Please put a building name instead of numbers.\";");
		out.println("   }");
		out.println("   if (BuildingField.value == \"\")");
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Missing building name.\";");
		out.println("   }");
		out.println("   var checkRadioClean = document.querySelector( 'input[name=\"clean\"]:checked');"); 
		out.println("   var checkRadioTraffic = document.querySelector( 'input[name=\"traffic\"]:checked');"); 
		out.println("   if(checkRadioClean == null)"); 
		out.println("   {");
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Select a clean level.\";");
		out.println("   }");       
		out.println("   if(checkRadioTraffic == null) {"); 
		out.println("      NumErr++;");
		out.println("      ErrMsg += \"\\n\" + NumErr + \") Select a traffic level.\";");
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
		out.println("<h1 align=\"center\" >SWE 432 Bryan Zheng</h1>");
		out.println("<hr/>");
		out.println("<center>");
		out.println("<h1 align=\"center\">Bathroom Review form</h1>");
		out.println("<form method=\"post\" action=\" Assignment6\" name=\"RegisterForm\" onSubmit=\"return (CheckRegistration())\">");
		out.println("<table>");
		     
		out.println("<tr>");
		out.println("<td>Building:");
		out.println("<td><input type=\"text\" name=\"BuildingField\" onFocus = \"PromptBuilding()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
		out.println("<br>");
		out.println("<tr>");
		out.println("<td>Floor:");
		out.println("<td><input type=\"text\" name=\"FloorField\" onFocus = \"PromptFloor()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
 
		out.println("<tr>");
		out.println("<td><p>Please select clean level:</p><br>");
		out.println("<td><input type=\"radio\" name=\"clean\" value=\"very clean\"> very clean");
		out.println("<td><input type=\"radio\" name=\"clean\" value=\"clean\"> clean");
		out.println("<td><input type=\"radio\" name=\"clean\" value=\"dirty\"> dirty");
		out.println("<td><input type=\"radio\" name=\"clean\" value=\"very dirty\"> very dirty");
		out.println("</tr>");
		out.println("<br>");
 
 
		out.println("<tr>");
		out.println("<td><p>Please select traffic level:</p><br>");
		out.println("<td><input type=\"radio\" name=\"traffic\" value=\"very busy\"> very busy");
		out.println("<td><input type=\"radio\" name=\"traffic\" value=\"busy\"> busy");
		out.println("<td><input type=\"radio\" name=\"traffic\" value=\"quiet\"> quiet");
		out.println("<td><input type=\"radio\" name=\"traffic\" value=\"very quiet\"> very quiet");
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
		out.print("</head>\n");
		out.print("<body>\n");
		out.print("<center><h2>Bryan Zheng  ------- Bathroom Review Form</h2></center>\n");
		out.print("<hr>\n");
		String bF = request.getParameter("BuildingField");
		String fF = request.getParameter("FloorField");
		String cF = request.getParameter("clean");
		String tF = request.getParameter("traffic");
		out.print("The building is ");
		out.print(bF);
		out.print(" on Floor ");
		out.print(fF);
		out.print(". ");
		out.println("This bathroom is");
		out.print(cF);
		out.print(" and ");
		out.print(tF);
		out.print(".");
		out.print("\n");
		out.print("</body>\n");
		out.print("</html>\n");
		out.close();
		out.close ();
	}
}
