
public class Player{

    private int pid;
    private int dollars;
    private int credits;
    private int rank;
    
    Player(int p_id){
	pid = p_id;
	dollars = 0;
	credits = 0;
	rank = 1;
	System.out.println("Created player with pid of "+p_id);
    }

}
