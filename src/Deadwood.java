import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*;
import java.awt.BorderLayout;
import java.util.concurrent.*;

public class Deadwood{

    private JFrame mainFrame;
    private PlayerResources r;
    private SceneResources s;
    private ShotCounterResources sc;
    private RoomView rView;
    private SidePanel sidePanel;
    private BottomLeftPanel bottomLeftPanel;
    private ArrayList<PlayerView> playerViewList;
    private static Executor UI_Executor;
    private static Executor Game_Executor;

    // Creates the whole board with all necessary panels
    private Deadwood(Board board) throws IOException{
	setupPlayerViews(board, board.getNumPlayers());
	setupSceneViews(board);
  mainFrame = new JFrame();

	mainFrame.setTitle("Deadwood");
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setLayout(null);

	createSceneCardPanels(mainFrame, board);
	CreateShotCountersPanels.main(mainFrame, sc);
	createRolePanels(mainFrame, board);
	createBottomPanel(mainFrame);
	CreateBlankAreaPanels.main(mainFrame);

  sidePanel = new SidePanel(mainFrame, board.getPlayers());
  bottomLeftPanel = new BottomLeftPanel(mainFrame, board);

  board.addListener(bottomLeftPanel);

	JPanel boardpanel = makeBoardPanel();
	for(int i = 0; i < playerViewList.size(); i++){
	    boardpanel.add(playerViewList.get(i), 0);
      board.getPlayer(i).addListener(sidePanel);
	}
  mainFrame.add(sidePanel);
  mainFrame.add(bottomLeftPanel);
	mainFrame.add(boardpanel);
	mainFrame.pack();
	mainFrame.setSize(1400, 1100);

	mainFrame.setVisible(true);
	mainFrame.setResizable(false);

	for(int i = 0; i < playerViewList.size(); i++){
	    playerViewList.get(i).requestFocus();
	}
    }

    // Initializes all scene views and sets icons
    private void setupSceneViews(Board board){
	s = SceneResources.getInstance();
    }

    // Initializes all player views and sets their icon
    private void setupPlayerViews(Board board, int numPlayers){
	r = PlayerResources.getInstance();
	playerViewList = new ArrayList<PlayerView>();
	PlayerView pv;
	int i = 1;
	while(i < numPlayers){
	    pv = new PlayerView(r, i);
	    board.getPlayer(i).addListener(pv);
	    playerViewList.add(pv);
	    i++;
	}
	pv = new PlayerView(r, i);
	board.getPlayer(i).addListener(pv);
	playerViewList.add(pv);
    }

    // Creates bottom panel with buttons
    private void createBottomPanel(JFrame mainFrame) throws IOException{
	BottomPanel bp = new BottomPanel(mainFrame);
    }

    // Creates bottom left corner panel
    private void createBottomLeftPanel(JFrame mainFrame) throws IOException{
	JPanel bottomRightPanel = new JPanel();
	bottomRightPanel.setBounds(0, 900, 200, 200);
	bottomRightPanel.setBackground(Color.decode("#79CEDC"));
	mainFrame.add(bottomRightPanel);
    }

    // Creates all role panels on the rooms
    private void createRolePanels(JFrame mainFrame, Board board) throws IOException{
	ArrayList<Room> room_list = board.getRoomList();
	ArrayList<Role> roles;
	int x;
	int y;
	JPanel role;
	int i = 0;
	while(i < room_list.size()){
	    int j = 0;
	    roles = room_list.get(i).getRoles();
	    while(j < roles.size()){
		x = roles.get(j).getArea().get(0) + 200;
		y = roles.get(j).getArea().get(1);
		role = new JPanel();
		role.setBounds(x, y, 46, 46);
		role.setBackground(Color.red);
		mainFrame.add(role);
		j++;
	    }
	    i++;
	}
    }

    // Makes the panel that displays the Deadwood game background
    private JPanel makeBoardPanel() throws IOException{
	JPanel boardpanel = new JPanel(null);
	BufferedImage image = ImageIO.read(new File("resources/board.jpg"));
	JLabel label = new JLabel(new ImageIcon(image));
	label.setBounds(0, 0, 1200, 900);
	boardpanel.add(label);
	boardpanel.setBounds(200, 0, 1200, 900);

	return boardpanel;
    }

    // Creates the x,y corrdinated panels for each scene and adds them to mainFrame
    private void createSceneCardPanels(JFrame mainFrame, Board board) throws IOException{
	ArrayList<Room> room_list = board.getRoomList();
	int x;
	int y;
	JPanel room;
	int i = 0;
	while(i < room_list.size()){
	    if(!room_list.get(i).getName().equals("Trailers") &&
	       !room_list.get(i).getName().equals("Casting Office")){
		x = room_list.get(i).getArea().get(0) + 200;
		y = room_list.get(i).getArea().get(1);
		room = new JPanel();
		room.setBounds(x, y, 205, 115);
		room.setBackground(Color.green);
		createSceneRolePanels(room_list.get(i), room);
		mainFrame.add(room);
	    }
	    i++;
	}
    }

    // Adds the scene role panels to each scene
    private void createSceneRolePanels(Room room, JPanel room_panel){
	JPanel sceneRole;
	int x;
	int y;
	Scene scene = room.getScene();
	if(scene != null){
	    ArrayList<Role> roles = scene.getRoles();
	    int num_roles = scene.getNumRoles();
	    int i = 0;
	    while(i < roles.size()){
		x = roles.get(i).getArea().get(0) + 200;
		y = roles.get(i).getArea().get(1);
		sceneRole = new JPanel();
		sceneRole.setBounds(x, y, 40, 40);
		room_panel.add(sceneRole);
		i++;
	    }
	}
    }


    /* A gateway to start the program. Captures number of players and instantiates the singleton
       Board object that is passed around through the rest of the classes. */
    public static void main(String args[]){
	if(args.length != 1 || Integer.parseInt(args[0]) < 2 || Integer.parseInt(args[0]) > 8){
	    System.out.println("Please specify a correct number of players");
	}
	else{
	    int num_players = Integer.parseInt(args[0]);
	    Board board = new Board(num_players);
	    setupGame(num_players, board);
	    setupScenes(args, board);
	    try{
		Deadwood dw = new Deadwood(board);
	    }
	    catch(IOException e){
		e.printStackTrace();
	    }
	    UI_Executor = Executors.newSingleThreadExecutor();
	    Game_Executor = Executors.newSingleThreadExecutor();

	    Game_Executor.execute(() -> GameKeeper.startGame(board));
	}
    }

    // Adds players to Board object and calls setupRooms()
    private static void setupGame(int num_players, Board board){
	int i = 0;
	while(i < num_players){ //Adding players to board object
	    Player new_player = new Player(i+1);
	    board.addPlayer(new_player);
	    i++;
	}
	setupRooms(board);
    }

    /* Creates all room objects, adds them to board object, and
       also creates the room neighbors relationships for each
       room. Hard coded, not read through XMLReader */
    private static void setupRooms(Board board){
	ParseBoard parsableBoard = new ParseBoard(board);
	board.addNeighbors();
    }

    /* Calls XmlReader to add scenes to Board unused_scenes arraylist to be used
       when hydrating sets*/
    private static void setupScenes(String[] args, Board board){
	ParseCard parsableCard = new ParseCard(board);
    }
}
