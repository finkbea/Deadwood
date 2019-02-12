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

    public void hydrateSets(){
	// 1. get scenes from unused_scenes and hydrate the sets with them
	// 2. move used scenes to used_scenes array by calling updateScenes
    }

    private void updateScenes(Scene scene){
	used_scenes.add(scene);
	unused_scenes.remove(scene);
    }

    public void addScene(Scene scene){
	unused_scenes.add(scene);
	System.out.println("added scene: "+scene.getName());
    }
}
