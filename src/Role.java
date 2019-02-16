
public class Role{

    private int _rank;
    private String _name;
    private String _line;
    
    Role(int rank, String name, String line){
	_rank = rank;
	_name = name;
	_line = line;
	System.out.println("Creating Role named "+name+" with rank "+rank+" and the line: "+line);
    }

    public String getName(){
	return _name;
    }

    public String getLine(){
	return _line;
    }
}
