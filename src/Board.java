import java.util.ArrayList;
public class Board{

    int num_players;
    
    public ArrayList<Player> player_list = new ArrayList<Player>();

    Board(int numPlayers){
	num_players = numPlayers;
    }

    
    public void addPlayer(Player player){
	player_list.add(player);	
    }

}
