/* Parsed in from XmlReader. Each scene is assigned roles. Getter methods are used to
   provide encapsulation from user. */
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Scene implements Room.Listener{

  public interface Listener{
      public void showScene(Scene s);
      public void closeScene(Scene s);
  }

    private List<Listener> listeners;
    private String _name;
    private ArrayList<Role> _roles;
    private int _budget;
    private String line;
    private int number;
    private String image;
    private int num_roles;
    private ArrayList<Integer> area;
    private Room _room;
    
    Scene(String name, String l, int n, String i, ArrayList<Role> roles, int budget){
	listeners = new LinkedList<Listener>();
	_name = name;
	_roles = roles;
	_budget = budget;
	this.line=l;
	this.number =n;
	this.image=i;
	num_roles = roles.size();
	_room = null;
    }
    
    public synchronized void addListener(Listener l){
      listeners.add(l);
    }
    private synchronized void enterListener(){
      for (Listener l : listeners){
        l.showScene(this);
      }
    }
    private synchronized void overListener(){
      for (Listener l : listeners){
        l.closeScene(this);
      }
    }

    public String getName(){
	return _name;
    }

    public int getNumberOfRoles(){
	return (_roles.size());
    }

    public ArrayList<Role> getRoles(){
	return _roles;
    }

    public int getBudget(){
	return _budget;
    }

    public int getNumRoles(){
	return num_roles;
    }

    public int getNumber(){
      return this.number;
    }

    public ArrayList<Integer> getArea(){
      return this.area;
    }


    //Room.Listener
    public void enter(ArrayList<Integer> n){
	System.out.println("llll");
	this.area=n;
      enterListener();
    }
    public void over(){
      overListener();
    }    
    public void incrementShots(int n){
    }
    
}
