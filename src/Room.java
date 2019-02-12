import java.util.ArrayList;

public class Room{

    private ArrayList<Room> neighbors = new ArrayList<Room>();
    private ArrayList<Role> roles = new ArrayList<Role>();
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
}
