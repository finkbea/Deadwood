/* Used for main roles and side roles. Keeps track of rank, name, line, and being worked or not. */
public class Role{

    private int _rank;
    private String _name;
    private String _line;
    private int being_worked; //0 for no, 1 for yes
    
    Role(int rank, String name, String line){
	_rank = rank;
	_name = name;
	_line = line;
	being_worked = 0;
	System.out.println("Creating Role named "+name+" with rank "+rank+" and the line: "+line);
    }

    public String getName(){
	return _name;
    }

    public String getLine(){
	return _line;
    }

    public int getRank(){
	return _rank;
    }

    public int isBeingWorked(){
	return being_worked;
    }

    public void workRole(){
	being_worked = 1;
    }
}
