import java.io.PrintWriter;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;


@WebServlet(name = "assigment8", urlPatterns = "/Assignment8")
public class Assignment8 extends HttpServlet {
		
	  static String OperationAdd = "Add";
	  
	  static enum Data {BUILDING, FLOOR, CLEAN, TRAFFIC, ENTRY, ENTRIES};
	  
	  static String RESOURCE_FILE = "entries.xml";
	  
	  public class Entry {
	    String building;
	    String floor;
	    String clean;
	    String traffic;
	  }

	  List<Entry> entries;

	  public class EntryManager {
	    private String filePath = null;
	    private XMLEventFactory eventFactory = null;
	    private XMLEvent LINE_END = null;
	    private XMLEvent LINE_TAB = null;
	    private XMLEvent ENTRIES_START = null;
	    private XMLEvent ENTRIES_END = null;
	    private XMLEvent ENTRY_START = null;
	    private XMLEvent ENTRY_END = null;


	    public EntryManager(){
	      eventFactory = XMLEventFactory.newInstance();
	      LINE_END = eventFactory.createDTD("\n");
	      LINE_TAB = eventFactory.createDTD("\t");

	      ENTRIES_START = eventFactory.createStartElement(
	        "","", Data.ENTRIES.name());
	      ENTRIES_END = eventFactory.createEndElement(
	        "", "", Data.ENTRIES.name());
	      ENTRY_START = eventFactory.createStartElement(
	        "","", Data.ENTRY.name());
	      ENTRY_END =eventFactory.createEndElement(
	        "", "", Data.ENTRY.name());
	    }
	    public void setFilePath(String filePath) {
	      this.filePath = filePath;
	    }

	    public List<Entry> save(String building, String floor, String clean, String traffic)
	      throws FileNotFoundException, XMLStreamException{
	      List<Entry> entries = getAll();
	      Entry newEntry = new Entry();
	      newEntry.building = building;
	      newEntry.floor = floor;
	      newEntry.clean = clean;
	      newEntry.traffic = traffic;
	      entries.add(newEntry);

	      XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	      XMLEventWriter eventWriter = outputFactory
	              .createXMLEventWriter(new FileOutputStream(filePath));

	      eventWriter.add(eventFactory.createStartDocument());
	      eventWriter.add(LINE_END);

	      eventWriter.add(ENTRIES_START);
	      eventWriter.add(LINE_END);

	      for(Entry entry: entries){
	        addEntry(eventWriter, entry.building, entry.floor, entry.clean, entry.traffic);
	      }

	      eventWriter.add(ENTRIES_END);
	      eventWriter.add(LINE_END);

	      eventWriter.add(eventFactory.createEndDocument());
	      eventWriter.close();
	      return entries;
	    }

	    private void addEntry(XMLEventWriter eventWriter, String building,
	            String floor, String clean, String traffic) throws XMLStreamException {
	        eventWriter.add(ENTRY_START);
	        eventWriter.add(LINE_END);
	        createNode(eventWriter, Data.BUILDING.name(), building);
	        createNode(eventWriter, Data.FLOOR.name(), floor);
	        createNode(eventWriter, Data.CLEAN.name(), clean);
	        createNode(eventWriter, Data.TRAFFIC.name(), traffic);
	        eventWriter.add(ENTRY_END);
	        eventWriter.add(LINE_END);

	    }

	    private void createNode(XMLEventWriter eventWriter, String name,
	          String value) throws XMLStreamException {
	      StartElement sElement = eventFactory.createStartElement("", "", name);
	      eventWriter.add(LINE_TAB);
	      eventWriter.add(sElement);

	      Characters characters = eventFactory.createCharacters(value);
	      eventWriter.add(characters);

	      EndElement eElement = eventFactory.createEndElement("", "", name);
	      eventWriter.add(eElement);
	      eventWriter.add(LINE_END);

	    }

	    private List<Entry> getAll(){
	      List entries = new ArrayList();

	      try{

	        File file = new File(filePath);
	        if(!file.exists()){
	          return entries;
	        }

	        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	        InputStream in = new FileInputStream(file);
	        XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

	        Entry entry = null;
	        while (eventReader.hasNext()) {
	          // <ENTRIES> not needed for the example
	          XMLEvent event = eventReader.nextEvent();

	          if (event.isStartElement()) {
	              StartElement startElement = event.asStartElement();
	              if (startElement.getName().getLocalPart()
	                .equals(Data.ENTRY.name())) {
	                  entry = new Entry();
	              }

	              if (event.isStartElement()) {
	                  if (event.asStartElement().getName().getLocalPart()
	                          .equals(Data.BUILDING.name())) {
	                      event = eventReader.nextEvent();
	                      entry.building =event.asCharacters().getData();
	                      continue;
	                  }
	              }
	              if (event.asStartElement().getName().getLocalPart()
	                      .equals(Data.FLOOR.name())) {
	                  event = eventReader.nextEvent();
	                  entry.floor = event.asCharacters().getData();
	                  continue;
	              }
	              if (event.asStartElement().getName().getLocalPart()
	                      .equals(Data.CLEAN.name())) {
	                  event = eventReader.nextEvent();
	                  entry.clean = event.asCharacters().getData();
	                  continue;
	              }
	              if (event.asStartElement().getName().getLocalPart()
	                      .equals(Data.TRAFFIC.name())) {
	                  event = eventReader.nextEvent();
	                  entry.traffic = event.asCharacters().getData();
	                  continue;
	              }
	          }

	          if (event.isEndElement()) {
	              EndElement endElement = event.asEndElement();
	              if (endElement.getName().getLocalPart()
	              .equals(Data.ENTRY.name())) {
	                  entries.add(entry);
	              }
	          }

	        }

	      }catch (FileNotFoundException e) {
	        e.printStackTrace();
	      }catch (XMLStreamException e) {
	        e.printStackTrace();
	      }catch(IOException ioException){
	        ioException.printStackTrace();
	      }

	      return entries;
	    }

	  public String getAllAsHTMLTable(List<Entry> entries){
	    StringBuilder htmlOut = new StringBuilder("<table>");
	    htmlOut.append("<tr><th>Building</th><th>Floor</th><th>Cleanliness</th><th>Traffic</th></tr>");
	    if(entries == null || entries.size() == 0){
	      htmlOut.append("<tr><td>No entries yet.</td></tr>");
	    }else{
	      for(Entry entry: entries){
	         htmlOut.append("<tr><td>"+entry.building+"</td><td>"+entry.floor+
	        		 "</td><td>" + entry.clean  +"</td><td>" + entry.traffic + "</td></tr>");
	      }
	    }
	    htmlOut.append("</table>");
	    return htmlOut.toString();
	  }

	 
	  }
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
		out.println("<td><input type=\"text\" name=\"" + Data.BUILDING.name() + "\" onFocus = \"PromptBuilding()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
		out.println("<br>");
		out.println("<tr>");
		out.println("<td>Floor:");
		out.println("<td><input type=\"text\" name=\"" + Data.FLOOR.name() + "\" onFocus = \"PromptFloor()\" onBlur  = \"ClearStatus()\">");
		out.println("</tr>");
 
		out.println("<tr>");
		out.println("<td><p>Please select clean level:</p><br>");
		out.println("<td><input type=\"radio\" name=\"" + Data.CLEAN.name() + "\" value=\"very clean\"> very clean");
		out.println("<td><input type=\"radio\" name=\"" + Data.CLEAN.name() + "\" value=\"clean\"> clean");
		out.println("<td><input type=\"radio\" name=\"" + Data.CLEAN.name() + "\" value=\"dirty\"> dirty");
		out.println("<td><input type=\"radio\" name=\"" + Data.CLEAN.name() + "\" value=\"very dirty\"> very dirty");
		out.println("</tr>");
		out.println("<br>");
 
 
		out.println("<tr>");
		out.println("<td><p>Please select traffic level:</p><br>");
		out.println("<td><input type=\"radio\" name=\"" + Data.TRAFFIC.name() + "\" value=\"very busy\"> very busy");
		out.println("<td><input type=\"radio\" name=\"" + Data.TRAFFIC.name() + "\" value=\"busy\"> busy");
		out.println("<td><input type=\"radio\" name=\"" + Data.TRAFFIC.name() + "\" value=\"quiet\"> quiet");
		out.println("<td><input type=\"radio\" name=\"" + Data.TRAFFIC.name() + "\" value=\"very quiet\"> very quiet");
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
		
		String bF = request.getParameter(Data.BUILDING.name());
	    String fF = request.getParameter(Data.FLOOR.name());
	    String cF = request.getParameter(Data.CLEAN.name());
	    String tF = request.getParameter(Data.TRAFFIC.name());
		
	    EntryManager entryManager = new EntryManager();
	    entryManager.setFilePath(RESOURCE_FILE);
	    List<Entry> newEntries= null;
	    try{
	      newEntries=entryManager.save(bF, fF, cF, tF);
	    }catch(FileNotFoundException e){
	      e.printStackTrace();
	    }
	    catch(XMLStreamException e){
	      e.printStackTrace();
	    }
	
	    out.println("<body>");
	    out.println("<p>");
	    out.println("");
	    out.println("</p>");
	    out.println("");
	    out.println(entryManager.getAllAsHTMLTable(newEntries));
	    out.println("");
	    out.println("</body>");
		out.print("</html>\n");
		out.close();
		out.close ();
	}
}
