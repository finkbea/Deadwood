import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*;
import java.awt.BorderLayout;

public class Deadwood{

    private JFrame mainFrame;
    private RoomView rView;
    private PlayerView pView;

    private Deadwood(Board board) throws IOException{
	//rView= new RoomView();
	pView = new PlayerView();

	mainFrame = new JFrame();
	mainFrame.setTitle("Deadwood");
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setLayout(null);

	createSceneCardPanels(mainFrame, board);
	createShotCountersPanels(mainFrame, board);
	createRolePanels(mainFrame, board);
	createSidePanel(mainFrame);
	createBottomPanel(mainFrame);
	createBottomLeftPanel(mainFrame);
	
	mainFrame.add(pView);
	pView.changeUpgrade(board.getPlayer(1));
	pView.changeUpgrade(board.getPlayer(2));

	JPanel boardpanel = makeBoardPanel();

	mainFrame.add(boardpanel);
	mainFrame.pack();
	mainFrame.setSize(1400, 1050);

	
	mainFrame.setVisible(true);
	mainFrame.setResizable(false);
	pView.requestFocus();

    }

    private static void createSidePanel(JFrame mainFrame) throws IOException{
	JPanel sidePanel = new JPanel();
	sidePanel.setBounds(0, 0, 200, 900);
	sidePanel.setBackground(Color.red);
	mainFrame.add(sidePanel);
    }

    private static void createBottomPanel(JFrame mainFrame) throws IOException{
	JPanel bottomPanel = new JPanel();
	bottomPanel.setBounds(200, 900, 1200, 150);
	bottomPanel.setBackground(Color.blue);
	mainFrame.add(bottomPanel);
    }

    private static void createBottomLeftPanel(JFrame mainFrame) throws IOException{
	JPanel bottomRightPanel = new JPanel();
	bottomRightPanel.setBounds(0, 900, 200, 150);
	bottomRightPanel.setBackground(Color.green);
	mainFrame.add(bottomRightPanel);
    }
    
    // Creates all role panels on the rooms
    private static void createRolePanels(JFrame mainFrame, Board board) throws IOException{
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
		mainFrame.add(role);
		j++;
	    }
	    i++;
	}
    }

    // Creates all the shot counter location panels
    private static void createShotCountersPanels(JFrame mainFrame, Board board) throws IOException{

	JPanel shotCounter1 = new JPanel();
	shotCounter1.setBounds(236, 11, 47, 47);
	mainFrame.add(shotCounter1);

	JPanel shotCounter2 = new JPanel();
	shotCounter2.setBounds(289, 11, 47, 47);
	mainFrame.add(shotCounter2);

	JPanel shotCounter3 = new JPanel();
	shotCounter3.setBounds(341, 11, 47, 47);
	mainFrame.add(shotCounter3);

	JPanel shotCounter4 = new JPanel();
	shotCounter4.setBounds(442, 764, 47, 47);
	mainFrame.add(shotCounter4);

	JPanel shotCounter5 = new JPanel();
	shotCounter5.setBounds(499, 764, 47, 47);
	mainFrame.add(shotCounter5);

	JPanel shotCounter6 = new JPanel();
	shotCounter6.setBounds(554, 764, 47, 47);
	mainFrame.add(shotCounter6);

	JPanel shotCounter7 = new JPanel();
	shotCounter7.setBounds(823, 675, 47, 47);
	mainFrame.add(shotCounter7);

	JPanel shotCounter8 = new JPanel();
	shotCounter8.setBounds(882, 675, 47, 47);
	mainFrame.add(shotCounter8);

	JPanel shotCounter9 = new JPanel();
	shotCounter9.setBounds(1205, 683, 47, 47);
	mainFrame.add(shotCounter9);

	JPanel shotCounter10 = new JPanel();
	shotCounter10.setBounds(1258, 683, 47, 47);
	mainFrame.add(shotCounter10);

	JPanel shotCounter11 = new JPanel();
	shotCounter11.setBounds(1311, 683, 47, 47);
	mainFrame.add(shotCounter11);

	JPanel shotCounter12 = new JPanel();
	shotCounter12.setBounds(1112, 23, 47, 47);
	mainFrame.add(shotCounter12);

	JPanel shotCounter13 = new JPanel();
	shotCounter13.setBounds(1058, 23, 47, 47);
	mainFrame.add(shotCounter13);

	JPanel shotCounter14 = new JPanel();
	shotCounter14.setBounds(1004, 23, 47, 47);
  shotCounter14.setBackground(Color.red);
	mainFrame.add(shotCounter14);

	JPanel shotCounter15 = new JPanel();
	shotCounter15.setBounds(642, 156, 47, 47);
	mainFrame.add(shotCounter15);

	JPanel shotCounter16 = new JPanel();
	shotCounter16.setBounds(513, 277, 47, 47);
	mainFrame.add(shotCounter16);

	JPanel shotCounter17 = new JPanel();
	shotCounter17.setBounds(513, 330, 47, 47);
	mainFrame.add(shotCounter17);

	JPanel shotCounter18 = new JPanel();
	shotCounter18.setBounds(672, 473, 47, 47);
	mainFrame.add(shotCounter18);

	JPanel shotCounter19 = new JPanel();
	shotCounter19.setBounds(725, 473, 47, 47);
	mainFrame.add(shotCounter19);

	JPanel shotCounter20 = new JPanel();
	shotCounter20.setBounds(1040, 549, 47, 47);
	mainFrame.add(shotCounter20);

	JPanel shotCounter21 = new JPanel();
	shotCounter21.setBounds(826, 216, 47, 47);
	mainFrame.add(shotCounter21);

	JPanel shotCounter22 = new JPanel();
	shotCounter22.setBounds(879, 216, 47, 47);
	mainFrame.add(shotCounter22);
    }

    // Makes the panel that displays the Deadwood game background
    private static JPanel makeBoardPanel() throws IOException{
	JPanel boardpanel = new JPanel();
	BufferedImage image = ImageIO.read(new File("resources/board.jpg"));
	JLabel label = new JLabel(new ImageIcon(image));
	boardpanel.add(label);
	boardpanel.setBounds(200, 0, 1200, 900);

	return boardpanel;
    }

    // Creates the x,y corrdinated panels for each scene and adds them to mainFrame
    private static void createSceneCardPanels(JFrame mainFrame, Board board) throws IOException{
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
		createSceneRolePanels(room_list.get(i), room);
		mainFrame.add(room);
	    }
	    i++;
	}
    }

    // Adds the scene role panels to each scene
    private static void createSceneRolePanels(Room room, JPanel room_panel){
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
