import java.util.ArrayList;

/* The Board object is a singleton and it holds all the players, rooms, used/unused scenes,
   and number of players. It does not keep track of which player is in each room (Player object
   does this). After the game is setup, this object is passed to GameKeeper.java in order to
   properly run the game. */
public class Board{

    private int num_players;    
    private ArrayList<Player> player_list = new ArrayList<Player>();
    private ArrayList<Room> room_list = new ArrayList<Room>();
    private ArrayList<Scene> used_scenes = new ArrayList<Scene>();
    private ArrayList<Scene> unused_scenes = new ArrayList<Scene>();
    private int numWrappedScenes;
    
    Board(int numPlayers){
	num_players = numPlayers;
	numWrappedScenes = 0;
    }
    
    public void addPlayer(Player player){
	player_list.add(player);	
    }

    public void addRoom(Room room){
	room_list.add(room);
    }
 
    // 1. get scenes from unused_scenes and hydrate the sets with them
    // 2. move used scenes to used_scenes array by calling updateScenes
    public void hydrateSets(){
	int i = 0;
	while(i < room_list.size()){
	    if(!room_list.get(i).getName().equals("Casting Office") &&
	       !room_list.get(i).getName().equals("Trailers")){
	    room_list.get(i).placeScene(unused_scenes.get(i));
	    updateScenes(unused_scenes.get(i));
	    }
	    i++;
	}
    }

    // Removes scene from unused_scenes and adds it to used_scenes
    private void updateScenes(Scene scene){
	used_scenes.add(scene);
	unused_scenes.remove(scene);
    }

    // Used on game startup and new days
    public void addScene(Scene scene){
	unused_scenes.add(scene);
    }

    // pid number is 1 <= pid <= total_num_players
    public Player getPlayer(int pid){
	Player temp = player_list.get(0); 
	int i = 0;
	while(i < player_list.size()){
	    if(player_list.get(i).getPid() == pid){
		temp = player_list.get(i);
		break;
	    }
	    i++;
	}
	return temp;
    }

    public int getNumPlayers(){
	return num_players;
    }

    /* This function is so we can get the player_list size without actually returning
       the player list */
    public int getPlayerListSize(){
	return (player_list.size());
    }

    /* Call on game startup and on new days */
    public Room getTrailers(){
	Room temp = room_list.get(0);
	int i = 0;
	while(i < room_list.size()){
	    if(room_list.get(i).getName().equals("Trailers")){
		temp = room_list.get(i);
	    }
	    i++;
	}
	return temp;
    }

    // Returns the room specified
    public Room getRoom(String desired_room){
	Room temp = room_list.get(0);
	int i = 0;
	while(i < room_list.size()){
	    if(room_list.get(i).getName().equals(desired_room)){
		temp = room_list.get(i);
	    }
	    i++;
	}
	return temp;
    }

    public void wrapScene(){
	numWrappedScenes++;
    }

    public int numWrappedScenes(){
	return numWrappedScenes;
    }
}
