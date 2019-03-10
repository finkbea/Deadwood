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

    private Controller controller;
    private JFrame mainFrame;
    private PlayerResources r;
    private SceneResources s;
    private ShotCounterResources sc;
    private RoomView rView;
    private SidePanel sidePanel;
    private BottomLeftPanel bottomLeftPanel;
    private ArrayList<PlayerView> playerViewList;
    private ArrayList<SceneView> sceneViewList;
    private static Executor UI_Executor;
    private static Executor Game_Executor;

    // Creates the whole board with all necessary panels and views
    private Deadwood(Board board) throws IOException{
	controller = new Controller(board);
	setupPlayerViews(board, board.getNumPlayers());
	setupSceneViews(board);

	mainFrame = new JFrame();

	mainFrame.setTitle("Deadwood");
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setLayout(null);

	createSceneCardPanels(mainFrame, board);
	CreateShotCountersPanels.main(mainFrame, sc);
	BottomPanel bp = new BottomPanel(mainFrame, controller);
	sidePanel = new SidePanel(mainFrame, board.getPlayers());
	bottomLeftPanel = new BottomLeftPanel(mainFrame, board);

	board.addListener(bottomLeftPanel);

	JPanel boardpanel = makeBoardPanel();
	// Adds playerViews as listeners to players
	for(int i = 0; i < playerViewList.size(); i++){
	    boardpanel.add(playerViewList.get(i), 0);
	    board.getPlayer(i).addListener(sidePanel);
	}
  board.getPlayer(board.getPlayerListSize()).addListener(sidePanel);


	mainFrame.add(sidePanel);
	mainFrame.add(bottomLeftPanel);
	mainFrame.add(boardpanel);
	mainFrame.pack();
	mainFrame.setSize(1400, 1100);

	mainFrame.setVisible(true);
	mainFrame.setResizable(false);

	// Requests focus for all playerViews
	for(int i = 0; i < playerViewList.size(); i++){
	    playerViewList.get(i).requestFocus();
	}
  for (int j =0; j<sceneViewList.size(); j++){
    boardpanel.add(sceneViewList.get(j), 0);
    sceneViewList.get(j).requestFocus();
  }
    }

    // Initializes all scene views and sets icons
    private void setupSceneViews(Board board){
	s = SceneResources.getInstance();
	sceneViewList = new ArrayList<SceneView>();
	SceneView sv;
	int i = 1;
	while(i < 41){
	    sv = new SceneView(s, i);
	    board.getAllScenes().get(i-1).addListener(sv);
	    sceneViewList.add(sv);
	    i++;
	}
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

    // Creates bottom left corner panel
    private void createBottomLeftPanel(JFrame mainFrame) throws IOException{
	JPanel bottomRightPanel = new JPanel();
	bottomRightPanel.setBounds(0, 900, 200, 200);
	bottomRightPanel.setBackground(Color.decode("#79CEDC"));
	mainFrame.add(bottomRightPanel);
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
		room.setBounds(x, y-5, 205, 120);
		room.setOpaque(false);
		BufferedImage image = ImageIO.read(new File("resources/cards/card_back.png"));
		JLabel label = new JLabel(new ImageIcon(image));
		label.setBounds(0, 0, 205, 115);
		room.add(label);		
		//room.setBackground(Color.decode("#FFCE00"));
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

	    GameKeeper.startGame(board);
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
