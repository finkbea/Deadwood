/* Parsed in from XmlReader. Each scene is assigned roles. Getter methods are used to
   provide encapsulation from user. */
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Scene{

    public interface Listener{
	public void showScene(int sceneNum);
    }

    private List<Listener> listeners;
    private String _name;
    private ArrayList<Role> _roles;
    private int _budget;
    private String line;
    private int number;
    private String image;
    private int num_roles;
    
    Scene(String name, String l, int n, String i, ArrayList<Role> roles, int budget){
	listeners = new LinkedList<Listener>();
	_name = name;
	_roles = roles;
	_budget = budget;
	this.line=l;
	this.number =n;
	System.out.println(number);
	this.image=i;
	num_roles = roles.size();
    }

    public synchronized void addListener(Listener l){
	listeners.add(l);
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
}
