
public class Deadwood{

    public static void main(String args[]){
	if(args.length != 1){
	    System.out.println("Please specify number of players");
	}
	else{
	    int num_players = Integer.parseInt(args[0]);
	    setup_game(num_players);
	}
    }

    private static void setup_game(int num_players){
	Board board = new Board(num_players);
	int i = 0;
	while(i < num_players){
	    Player new_player = new Player(i+1);
	    board.addPlayer(new_player);
	    i++;
	}
    }

}
