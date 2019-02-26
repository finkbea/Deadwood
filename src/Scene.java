/* Parsed in from XmlReader. Each scene is assigned roles. Getter methods are used to
   provide encapsulation from user. */
import java.util.ArrayList;

public class Scene{

    /* Need to add scene number(?) */

    private String _name;
    private ArrayList<Role> _roles;
    private int _budget;
    private String line;
    private int number;
    private String image;

    Scene(String name, String l, int n, String i, ArrayList<Role> roles, int budget){
	_name = name;
	_roles = roles;
	_budget = budget;
  this.line=l;
  this.number =n;
  this.image=i;
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
}
