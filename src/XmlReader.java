/* Full credit to Aran Clauson */
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XmlReader {

    /* For_each node
     * This interface and for_each function iterator over the nodes in a node
     * list.
     */
    public interface Runnable_Node {
	public void run(Node n);
    }
  
    public static void for_each(NodeList list, Runnable_Node run) {
	for(int i = 0; i < list.getLength(); ++i) 
	    run.run(list.item(i));
    }

    /* For_each element
     * This interface and the following for_each function iterate over the
     * elements in a node list.
     */
    public interface Runnable_Element {
	public void run(Element n);
    }

    public static void for_each(NodeList list, Runnable_Element run) {
	for_each(list, (Node n) -> {
		if(n.getNodeType() == Node.ELEMENT_NODE)
		    run.run((Element) n);
	    });
    }

    /* Parse Document
     *
     * Reads, parses, and returns the root element of the indicated file.  
     */
    public static Element parse_doc(String filename) {
	Element root = null;

	try{
	    File inputFile = new File(filename);
         
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(inputFile);
      
	    doc.getDocumentElement().normalize();
	    root = doc.getDocumentElement();
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.exit(1);
	}
    
	return root;
    }

    /* Print Part
     *
     * Prints the contents of the XML Part element to the console. 
     */
    public static void printPart(Element part) {
	System.out.println(part.getAttribute("name") +
			   " (" +
			   part.getAttribute("level") +
			   ")");
	for_each(part.getElementsByTagName("line"),
		 (Element line) -> {
		     System.out.println("\"" +
					line.getTextContent() +
					"\"");
		 });
	System.out.println("");
    }
    

    /* Print Card
     *
     * Prints the contents of the XML Card element to the console. 
     */
    public static void printCard(Element card) {
	System.out.println(card.getAttribute("name"));
	for_each(card.getElementsByTagName("part"),
		 (Element part) -> printPart(part));
	System.out.println("");
    }
         

    /* Main
     *
     * Simplified main.  It is now just parse the file and print the cards.
     * Helper functions (above) do all of the real work. 
     */
    public static void main(String argv[], Board board) {
 
	Element doc = parse_doc("cards.xml");
	for_each(doc.getElementsByTagName("card"),
		 (Element card) -> makeCard(card));
    }

    public static Scene makeCard(Element card) {
	String cardName = card.getAttribute("name");
	ArrayList<String> partNames = new ArrayList<String>();
	ArrayList<Integer> levels = new ArrayList<Integer>();
	ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
	
	ArrayList<Role> roles = new ArrayList<Role>();
	
	for_each(card.getElementsByTagName("part"),
		 (Element part) -> partNames.add(getPartName(part)));
	for_each(card.getElementsByTagName("part"),
		 (Element part) -> levels.add(getPartLevel(part)));
	for_each(card.getElementsByTagName("part"),
		 (Element part) -> lines.add(getPartLine(part)));

	int num_roles = partNames.size();
        int i = 0;
	String temp_line = "";
	while(i < num_roles){
	    Role temp = new Role(levels.get(i), partNames.get(i), makeLine(lines.get(i)));
	    roles.add(temp);
	    i++;
	}
	Scene scene = new Scene(num_roles, cardName, roles);
	return scene;
    }

    public static String getPartName(Element part) {
	String name = part.getAttribute("name");
	return name;
    }

    public static int getPartLevel(Element part) {
	int name = Integer.parseInt(part.getAttribute("level"));
	return name;
    }

    public static ArrayList<String> getPartLine(Element part){
	ArrayList<String> lines = new ArrayList<String>();
	for_each(part.getElementsByTagName("line"),
		 (Element line) -> lines.add(line.getTextContent()));
	return lines;
    } 

    private static String makeLine(ArrayList<String> line){
	String new_line = "";
	int i = 0;
	while(i < line.size()){
	    new_line += line.get(i) + "\t";
	    i++;
	}
	return new_line;
    }
}

