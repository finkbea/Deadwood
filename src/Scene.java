/* Parsed in from XmlReader. Each scene is assigned roles. Getter methods are used to
   provide encapsulation from user. */
import java.util.ArrayList;

public class Scene{

    /* Need to add scene number(?) */ 
    
    private int _numRoles;
    private String _name;
    private ArrayList<Role> _roles;
    private int _budget;    
    
    Scene(int numRoles, String name, ArrayList<Role> roles, int budget){     
	_numRoles = numRoles;
	_name = name;
	_roles = roles;
	_budget = budget;
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
