import java.util.ArrayList;
public class Board{

    int num_players;    
    private ArrayList<Player> player_list = new ArrayList<Player>();
    private ArrayList<Room> room_list = new ArrayList<Room>();
    
    Board(int numPlayers){
	num_players = numPlayers;
    }

    
    public void addPlayer(Player player){
	player_list.add(player);	
    }

    public void addRoom(Room room){
	room_list.add(room);
    }

}
