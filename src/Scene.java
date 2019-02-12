import java.util.ArrayList;

public class Scene{

    /* Need to add budget, scene number(?) */ 
    
    private int _numRoles;
    private String _name;
    private ArrayList<Role> _roles;
    //private String _description;
    //private int _sceneNum;
    //private int _budget;
    
    Scene(int numRoles, String name, ArrayList<Role> roles){     
	_numRoles = numRoles;
	_name = name;
	_roles = roles;
	System.out.println(name + " with # of roles as "+numRoles);
    }

    //add getter methods
}
