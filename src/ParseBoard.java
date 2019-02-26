import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class ParseBoard {

  /* For_each node
   * This interface and for_each function iterator over the nodes in a node
   * list.
   */
   //constructor, creates a public Element xmlFile that pareses the board

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

  //constructor, takes in the board and parses through the board.xml document to add rooms
  public ParseBoard(Board board) {
    Element doc = parse_doc("board.xml");
    for_each(doc.getElementsByTagName("set"),
             (Element set) -> board.addRoom(createRoom(set)));
    /*for_each(doc.getElementsByTagName("office"),
             (Element office) -> board.addOffice(createOffice(office)));
    for_each(doc.getElementsByTagName("trailer"),
             (Element trailer) -> board.addTrailer(createTrailer(trailer)));*/
  }

  //helper method, once I am inside neighbor I just have to pull the name and return it, at which point it is added to my ArrayList of neighbors
  public static String getNeighbors(Element neighbor){
    String name = neighbor.getAttribute("name");
    return name;
  }

  //functions about the same as getNeighbors, once im inside take I just pull the numbers and add them to my ArrayList of takes (granted I only care about the first one)
  public static String getTakes(Element take){
    String takes = take.getAttribute("number");
    return takes;
  }
  /*Exact same as the createRole method from ParseCard
  */
  public static Role createRole(Element part) {
    String name = part.getAttribute("name");
    int level = Integer.parseInt(part.getAttribute("level"));
    String line="";
    ArrayList<String> lineHelper = new ArrayList<String>();
    for_each(part.getElementsByTagName("line"),
             (Element line2) -> {
                lineHelper.add(line2.getTextContent()+" ");
             });
    for (int i =0; i<lineHelper.size(); i++){
      line+=lineHelper.get(i);
    }
    ArrayList<Integer> areaList = new ArrayList<Integer>();
    for_each(part.getElementsByTagName("area"),
             (Element area) -> {
               areaList.add(Integer.parseInt(area.getAttribute("x")));
               areaList.add(Integer.parseInt(area.getAttribute("y")));
               areaList.add(Integer.parseInt(area.getAttribute("h")));
               areaList.add(Integer.parseInt(area.getAttribute("w")));
             });
    Role role = new Role(level, areaList, name, line);
    return role ;
  }

  /* creates the sets, Very similar to my methods in ParseCard, I find the variables I need for my set, the name which is easy to get, the shots or "takes" which I have to use a helper method for,
  the parts, which is done using the createRole method from ParseCard, and lastly the neighbors, I choose to just store them as an ArrayList of Strings that just contains their names
  for the time being, once     this.sets=this.rooms;I have all that I just construct the set and return it to the constructor where it is added to the boards ArrayList of rooms.
  */
  public static Room createRoom(Element set) {
    String name = set.getAttribute("name");
    ArrayList<String> takesHelper = new ArrayList<String>();
    for_each(set.getElementsByTagName("take"),
              (Element take) -> {
                takesHelper.add(getTakes(take));
              });
    int takes = Integer.parseInt(takesHelper.get(0));
    ArrayList<Role> list = new ArrayList<Role>();
    for_each(set.getElementsByTagName("part"),
             (Element part) -> {
               list.add(createRole(part));
             });
    ArrayList<String> neighbors = new ArrayList<String>();
    for_each(set.getElementsByTagName("neighbor"),
             (Element neighbor) -> {
                neighbors.add(getNeighbors(neighbor));
              });
    ArrayList<Integer> areaList = new ArrayList<Integer>();
    for_each(set.getElementsByTagName("area"),
             (Element area) -> {
               areaList.add(Integer.parseInt(area.getAttribute("x")));
               areaList.add(Integer.parseInt(area.getAttribute("y")));
               areaList.add(Integer.parseInt(area.getAttribute("h")));
               areaList.add(Integer.parseInt(area.getAttribute("w")));
             });
    Room realSet = new Room(name, takes, list, neighbors, areaList);
    return realSet;
  }

  //creates the trailer, copied and pasted from createRoom, the trailer only has neighbors and no other parameters so it calls getNeighbors to find those and does nothing else
  /*public static Trailer createTrailer(Element trailer){
    ArrayList<String> neighbors = new ArrayList<String>();
    for_each(trailer.getElementsByTagName("neighbor"),
             (Element neighbor) -> {
                neighbors.add(getNeighbors(neighbor));
              });
    Trailer realTrailer = new Trailer(neighbors);
    return realTrailer;
  }*/

  /*creates the casting office, its the same as the method to create the trailer because I decided to hardcode the upgrade prices
  */
  /*public static CastingOffice createOffice(Element office){
    ArrayList<String> neighbors = new ArrayList<String>();
    for_each(office.getElementsByTagName("neighbor"),
             (Element neighbor) -> {
                neighbors.add(getNeighbors(neighbor));
              });
    CastingOffice realOffice = new CastingOffice(neighbors);
    return realOffice;
  }*/
}
