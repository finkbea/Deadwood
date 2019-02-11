import java.util.ArrayList;

public class Room{

    private ArrayList<Room> neighbors = new ArrayList<Room>();
    public String _name;
    
    Room(String name){
	_name = name;
	System.out.println("Making room called "+name);
    }
        
}
