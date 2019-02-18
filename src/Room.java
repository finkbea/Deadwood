/* Each room has an instance of the Room class. Each room and its roles, neighbors, and shotcounters
   are hard-coded in from Deadwood.java. Scene is added in accordingly on start game and hydrateSet() */
import java.util.ArrayList;

public class Room{

    private ArrayList<Room> neighbors = new ArrayList<Room>();
    private ArrayList<Role> roles = new ArrayList<Role>();
    private Scene _scene;
    public String _name;
    public int shotCounters;
    
    Room(String name, int shots){
	_name = name;
	shotCounters = shots;
	System.out.println("Making room called "+name + " with " + shots + " shot counters.");
    }

    public void addRole(int rank, String name, String line){
	Role role = new Role(rank, name, line);
	roles.add(role);
    }

    public String getName(){
	return _name;
    }

    public void addNeighbor(Room room){
	neighbors.add(room);
    }

    public void placeScene(Scene scene){
	_scene = scene;
	System.out.println("Placing scene on room "+_name);
    }

    public Scene getScene(){
	return _scene;
    }

    public int getNumberOfRoles(){
	return (roles.size());
    }

    public ArrayList<Role> getRoles(){
	return roles;
    }

    // Parses all neighbors in the neighbors arraylist and returns 0 (no) or 1 (yes) if neighbor or not
    public int isNeighbor(Room room){
	Room temproom = neighbors.get(0);
	int i = 0;
	int is_neighbor = 0;
	while(i < neighbors.size()){
	    if(neighbors.get(i).getName().equals(room.getName())){
		is_neighbor = 1;
	    }
	    else{
		temproom = neighbors.get(i);
	    }
	    i++;
	}
	return is_neighbor;
    }

    public void removeShot(){
	shotCounters--;
    }

    public int getShotCounters(){
	return shotCounters;
    }

    public void wrapScene(){
	_scene = null;
    }
}
