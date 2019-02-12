import java.util.*;

public class GameKeeper{

    public static void startGame(Board board){
	System.out.println("Get ready to rumble! Starting game!");
	int turn;
	resetPlayers(board);
	
	hydrateSets(board);
	turn = 1;
	while(turn <= board.getNumPlayers()){
	    listener(board, turn);
	    turn++;
	}
    }

    private static void hydrateSets(Board board){
	board.hydrateSets();
    }
    
    private static int updateTurn(int turn){
	return(turn+1);
    }

    private static void listener(Board board, int turn){
	String command="";
	Scanner sc;
	int turnEnd = 0;
	while(turnEnd == 0){
	    sc = new Scanner(System.in);
	    command = sc.next();
	    turnEnd = (inputAdmin(command, turn, board));	    
	    //System.out.println(command);
	}
    }

    private static int inputAdmin(String command, int turn, Board board){
	int turnEnd = 0;
	if(command.equals("end")){
	    turnEnd = 1;
	}
	else if(command.equals("who")){
	    Player temp = board.getPlayer(turn);
	    System.out.println("Player "+turn+": ($"+temp.getDollars()+", "+temp.getCredits()+
			       "cr)");
	    System.out.println("also need to add compatibility if the current player is working on any parts");
	}
	else if(command.equals("where")){
	    Player temp = board.getPlayer(turn);
	    System.out.println("do where stuff here");
	}

	return(turnEnd);
    }

    private static void resetPlayers(Board board){
	int pnum = 1;
	int i = 0;
	while(i < board.getPlayerListSize()){
	    board.getPlayer(pnum).updateRoom(board.getCastingOffice());
	    pnum++;
	    i++;
	}
    }

}
