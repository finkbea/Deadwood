import java.util.ArrayList;

public class Scene{

    /* Need to add scene number(?) */ 
    
    private int _numRoles;
    private String _name;
    private ArrayList<Role> _roles;
    private int _budget;
    //private String _description;
    //private int _sceneNum;
    
    
    Scene(int numRoles, String name, ArrayList<Role> roles, int budget){     
	_numRoles = numRoles;
	_name = name;
	_roles = roles;
	_budget = budget;
	System.out.println(name + " with # of roles as "+numRoles);
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
