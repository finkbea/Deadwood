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

    private Deadwood() throws IOException{
	rView= new RoomView();

	mainFrame = new JFrame();
	mainFrame.setTitle("Deadwood");
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setLayout(null);

	createSceneCardPanels(mainFrame);
	
	mainFrame.pack();
	mainFrame.setSize(1400, 1050);
	
	mainFrame.setVisible(true);
	mainFrame.setResizable(false);
	
    }

    private static void createSceneCardPanels(JFrame mainFrame) throws IOException{
	JPanel boardpanel = new JPanel();
	BufferedImage image = ImageIO.read(new File("board.jpg"));
	JLabel label = new JLabel(new ImageIcon(image));
	boardpanel.add(label);
	boardpanel.setBounds(200, 0, 1200, 900);
	
	JPanel panel2 = new JPanel();
	panel2.setBounds(220, 70, 205, 115);

	JPanel jailScene = new JPanel();
	jailScene.setBounds(480, 30, 205, 115);

	JPanel mainStreetScene = new JPanel();
	mainStreetScene.setBounds(1170, 30, 205, 115);

	JPanel hotelScene = new JPanel();
	hotelScene.setBounds(1169, 740, 205, 115);
	
	JPanel churchScene = new JPanel();
	churchScene.setBounds(823, 734, 205, 115);

	JPanel saloonScene = new JPanel();
	saloonScene.setBounds(832, 280, 205, 115);

	JPanel bankScene = new JPanel();
	bankScene.setBounds(823, 475, 205, 115);

	JPanel ranchScene = new JPanel();
	ranchScene.setBounds(452, 478, 205, 115);

	JPanel generalStoreScene = new JPanel();
	generalStoreScene.setBounds(570, 282, 205, 115);

	JPanel secretHideoutScene = new JPanel();
	secretHideoutScene.setBounds(227, 732, 205, 115);

	mainFrame.add(secretHideoutScene);
	mainFrame.add(generalStoreScene);
	mainFrame.add(ranchScene);
	mainFrame.add(bankScene);
	mainFrame.add(saloonScene);
	mainFrame.add(churchScene);
	mainFrame.add(hotelScene);
	mainFrame.add(mainStreetScene);
	mainFrame.add(jailScene);
	mainFrame.add(panel2);
	mainFrame.add(boardpanel);
    }
    
    /* A gateway to start the program. Captures number of players and instantiates the singleton 
       Board object that is passed around through the rest of the classes. */
    public static void main(String args[]){
	try{
	    Deadwood dw = new Deadwood();
	}
	catch(IOException e){
	    e.printStackTrace();
	}
	if(args.length != 1 || Integer.parseInt(args[0]) < 2 || Integer.parseInt(args[0]) > 8){
	    System.out.println("Please specify a correct number of players");
	}
	else{
	    int num_players = Integer.parseInt(args[0]);
	    Board board = new Board(num_players);
	    setupGame(num_players, board);
	    setupScenes(args, board);
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
