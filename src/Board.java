import java.util.ArrayList;

public class Board{

    private int num_players;    
    private ArrayList<Player> player_list = new ArrayList<Player>();
    private ArrayList<Room> room_list = new ArrayList<Room>();
    private ArrayList<Scene> used_scenes = new ArrayList<Scene>();
    private ArrayList<Scene> unused_scenes = new ArrayList<Scene>();

    
    Board(int numPlayers){
	num_players = numPlayers;
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

    private void updateScenes(Scene scene){
	used_scenes.add(scene);
	unused_scenes.remove(scene);
    }

    public void addScene(Scene scene){
	unused_scenes.add(scene);
	System.out.println("added scene: "+scene.getName());
    }

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

    public int getPlayerListSize(){
	return (player_list.size());
    }

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
}
