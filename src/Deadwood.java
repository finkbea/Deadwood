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
    private RoomView rView;
    private ArrayList<PlayerView> playerViewList;
    private static Executor UI_Executor;
    private static Executor Game_Executor;

    private class MyMouseListener implements MouseListener{
	public void mouseClicked(MouseEvent event){
	    System.out.println("clicked bottom panel");
	}
	public void mouseExited(MouseEvent event) {
	    System.out.println("exited bottom panel");
	}
	public void mouseEntered(MouseEvent event) {
	    UI_Executor.execute(() ->
			     System.out.println("entered bottom panel"));
	}
	public void mousePressed(MouseEvent event) {
	    System.out.println("pressed bottom panel");
	}
	public void mouseReleased(MouseEvent event) {
	    System.out.println("released bottom panel");
	}
    }

    // Creates the whole board with all necessary panels
    private Deadwood(Board board) throws IOException{	
	setupPlayerViews(board, board.getNumPlayers());	

	mainFrame = new JFrame();
	mainFrame.setTitle("Deadwood");
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setLayout(null);

	createSceneCardPanels(mainFrame, board);
	CreateShotCountersPanels.main(mainFrame);
	createRolePanels(mainFrame, board);
	createSidePanel(mainFrame, board);
	createBottomPanel(mainFrame);
	createBottomLeftPanel(mainFrame);
	CreateBlankAreaPanels.main(mainFrame);

	JPanel boardpanel = makeBoardPanel();
	for(int i = 0; i < playerViewList.size(); i++){
	    boardpanel.add(playerViewList.get(i), 0);
	}
	
	mainFrame.add(boardpanel);
	mainFrame.pack();
	mainFrame.setSize(1400, 1050);

	mainFrame.setVisible(true);
	mainFrame.setResizable(false);

	for(int i = 0; i < playerViewList.size(); i++){
	    playerViewList.get(i).requestFocus();
	}
	playerViewList.get(0).changeUpgrade(board.getPlayer(0));
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
    
    //goint to rewrite the second part, each line will be a Jlabel
    private void createSidePanel(JFrame mainFrame, Board board) throws IOException {
	JPanel sidePanel = new JPanel();
	sidePanel.setLayout(null);
	sidePanel.setBounds(0, 0, 200, 900);
	Color[] backGroundColor = new Color[]{Color.black, Color.blue, Color.orange, Color.green, Color.red, Color.yellow, Color.magenta, Color.pink, Color.cyan};
	sidePanel.setBackground(backGroundColor[board.getCurrentPlayerID()]);

  JLabel statPanel = new JLabel("Stat Panel:");
  statPanel.setBounds(20,0,160,30);
  statPanel.setForeground(Color.white);
  sidePanel.add(statPanel);
	//JLabel playerStats;
	for (int i =1; i<board.getNumPlayers()+1; i++){
	    JLabel name = new JLabel("Player: "+board.getPlayer(i).getPid()+"");
      name.setBounds(20,-70+(100*i),160,15);
      name.setForeground(backGroundColor[i]);

      JLabel score = new JLabel("Score: "+board.getPlayer(i).getScore());
      score.setBounds(20,-55+(100*i),160,15);
      score.setForeground(backGroundColor[i]);

      JLabel rank = new JLabel("Rank: "+board.getPlayer(i).getRank()+"");
      rank.setBounds(20,-40+(100*i),160,15);
      rank.setForeground(backGroundColor[i]);

      JLabel dollars = new JLabel("Dollars: "+board.getPlayer(i).getDollars());
      dollars.setBounds(20,-25+(100*i),160,15);
      dollars.setForeground(backGroundColor[i]);

      JLabel credits = new JLabel("Credits: "+board.getPlayer(i).getCredits());
      credits.setBounds(20,-10+(100*i),160,15);
      credits.setForeground(backGroundColor[i]);

      JLabel rehearse = new JLabel("Times Rehearsed: "+board.getPlayer(i).getRehearseTokens());
      rehearse.setBounds(20,5+(100*i),160,15);
      rehearse.setForeground(backGroundColor[i]);
	    sidePanel.add(name);
      sidePanel.add(score);
      sidePanel.add(rank);
      sidePanel.add(dollars);
      sidePanel.add(credits);
      sidePanel.add(rehearse);
	}
	mainFrame.add(sidePanel);
    }

    // Creates bottom panel
    private void createBottomPanel(JFrame mainFrame) throws IOException{
	JPanel bottomPanel = new JPanel();
	bottomPanel.setBounds(200, 900, 1200, 150);
	bottomPanel.setBackground(Color.blue);
	bottomPanel.addMouseListener(new MyMouseListener());
	mainFrame.add(bottomPanel);
    }

    // Creates bottom left corner panel
    private void createBottomLeftPanel(JFrame mainFrame) throws IOException{
	JPanel bottomRightPanel = new JPanel();
	bottomRightPanel.setBounds(0, 900, 200, 150);
	bottomRightPanel.setBackground(Color.green);
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
