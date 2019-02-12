
public class Player{

    private int pid;
    private int dollars;
    private int credits;
    private int rank;
    private Room _room;
    
    Player(int p_id){
	pid = p_id;
	dollars = 0;
	credits = 0;
	rank = 1;
	System.out.println("Created player with pid of "+p_id);
    }

    public int getPid(){
	return pid;
    }

    public int getDollars(){
	return dollars;
    }

    public int getCredits(){
	return credits;
    }

    public int getRank(){
	return rank;
    }

    public void updateRoom(Room room){
	_room = room;
    }
    
}
