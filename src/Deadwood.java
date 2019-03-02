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
	BufferedImage image2 = ImageIO.read(new File("01.png"));
	JLabel label2 = new JLabel(new ImageIcon(image2));
	panel2.add(label2);	
	panel2.setBounds(220, 70, 205, 115);

	JPanel panel3 = new JPanel();
	BufferedImage image3 = ImageIO.read(new File("02.png"));
	JLabel label3 = new JLabel(new ImageIcon(image3));
	panel3.add(label3);	
	panel3.setBounds(480, 30, 205, 115);

	JPanel panel4 = new JPanel();
	BufferedImage image4 = ImageIO.read(new File("03.png"));
	JLabel label4 = new JLabel(new ImageIcon(image4));
	panel4.add(label4);	
	panel4.setBounds(1170, 30, 205, 115);

	JPanel panel5 = new JPanel();
	BufferedImage image5 = ImageIO.read(new File("04.png"));
	JLabel label5 = new JLabel(new ImageIcon(image5));
	panel5.add(label5);	
	panel5.setBounds(1170, 745, 205, 115);
	
	JPanel panel6 = new JPanel();
	BufferedImage image6 = ImageIO.read(new File("05.png"));
	JLabel label6 = new JLabel(new ImageIcon(image6));
	panel6.add(label6);	
	panel6.setBounds(227, 732, 205, 115);

	JPanel panel7 = new JPanel();
	BufferedImage image7 = ImageIO.read(new File("06.png"));
	JLabel label7 = new JLabel(new ImageIcon(image7));
	panel7.add(label7);	
	panel7.setBounds(480, 30, 205, 115);

	JPanel panel8 = new JPanel();
	BufferedImage image8 = ImageIO.read(new File("07.png"));
	JLabel label8 = new JLabel(new ImageIcon(image8));
	panel8.add(label8);	
	panel8.setBounds(480, 30, 205, 115);

	JPanel panel9 = new JPanel();
	BufferedImage image9 = ImageIO.read(new File("08.png"));
	JLabel label9 = new JLabel(new ImageIcon(image9));
	panel9.add(label9);	
	panel9.setBounds(480, 30, 205, 115);

	JPanel panel10 = new JPanel();
	BufferedImage image10 = ImageIO.read(new File("09.png"));
	JLabel label10 = new JLabel(new ImageIcon(image10));
	panel10.add(label10);	
	panel10.setBounds(480, 30, 205, 115);

	JPanel panel11 = new JPanel();
	BufferedImage image11 = ImageIO.read(new File("10.png"));
	JLabel label11 = new JLabel(new ImageIcon(image11));
	panel11.add(label11);	
	panel11.setBounds(480, 30, 205, 115);

	mainFrame.add(panel11);
	mainFrame.add(panel10);
	mainFrame.add(panel9);
	mainFrame.add(panel8);
	mainFrame.add(panel7);
	mainFrame.add(panel6);
	mainFrame.add(panel5);
	mainFrame.add(panel4);
	mainFrame.add(panel3);
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

	/*
	Room castingOffice = new Room("Casting Office", 0);
	board.addRoom(castingOffice);
	Room trailers = new Room("Trailers", 0);
	board.addRoom(trailers);
	Room mainStreet = new Room("Main Street", 3);
	board.addRoom(mainStreet);
	setupRoomRoles(mainStreet);
	Room saloon = new Room("Saloon", 2);
	board.addRoom(saloon);
	setupRoomRoles(saloon);
	Room ranch = new Room("Ranch", 2);
	board.addRoom(ranch);
	setupRoomRoles(ranch);
	Room secretHideout = new Room("Secret Hideout", 3);
	board.addRoom(secretHideout);
	setupRoomRoles(secretHideout);
	Room bank = new Room("Bank", 1);
	board.addRoom(bank);
	setupRoomRoles(bank);	
	Room hotel = new Room("Hotel", 3);
	board.addRoom(hotel);
	setupRoomRoles(hotel);	
	Room church = new Room("Church", 2);
	board.addRoom(church);
	setupRoomRoles(church);
	Room jail = new Room("Jail", 1);
	board.addRoom(jail);
	setupRoomRoles(jail);      
	Room trainStation = new Room("Train Station", 3);
	board.addRoom(trainStation);
	setupRoomRoles(trainStation);	
	Room generalStore = new Room("General Store", 2);
	board.addRoom(generalStore);
	setupRoomRoles(generalStore);	

	castingOffice.addNeighbor(trainStation);
	castingOffice.addNeighbor(ranch);
	castingOffice.addNeighbor(secretHideout);
	trailers.addNeighbor(mainStreet);
	trailers.addNeighbor(saloon);
	trailers.addNeighbor(hotel);	
	mainStreet.addNeighbor(trailers);
	mainStreet.addNeighbor(saloon);
	mainStreet.addNeighbor(jail);
	saloon.addNeighbor(mainStreet);
        saloon.addNeighbor(trailers);
	saloon.addNeighbor(bank);
	saloon.addNeighbor(generalStore);
	ranch.addNeighbor(generalStore);
	ranch.addNeighbor(bank);
	ranch.addNeighbor(secretHideout);
	ranch.addNeighbor(castingOffice);
	secretHideout.addNeighbor(ranch);
        secretHideout.addNeighbor(castingOffice);
	secretHideout.addNeighbor(church);
        bank.addNeighbor(saloon);
	bank.addNeighbor(hotel);
	bank.addNeighbor(church);
	bank.addNeighbor(ranch);
	hotel.addNeighbor(trailers);
	hotel.addNeighbor(bank);
	hotel.addNeighbor(church);
	church.addNeighbor(secretHideout);
	church.addNeighbor(bank);
	church.addNeighbor(hotel);
	jail.addNeighbor(trainStation);
	jail.addNeighbor(generalStore);
	jail.addNeighbor(mainStreet);
	trainStation.addNeighbor(jail);
	trainStation.addNeighbor(generalStore);
	trainStation.addNeighbor(castingOffice);
	generalStore.addNeighbor(jail);
        generalStore.addNeighbor(saloon);
        generalStore.addNeighbor(ranch);
	generalStore.addNeighbor(trainStation);
	*/
    }

    /* Calls XmlReader to add scenes to Board unused_scenes arraylist to be used
       when hydrating sets*/
    private static void setupScenes(String[] args, Board board){      	
	ParseCard parsableCard = new ParseCard(board);
	//XmlReader.main(args, board); //adds scenes to board object in XmlReader.java
    }

    // Hard coding in the roles for each Room on the Board object
    private static void setupRoomRoles(Room room){
	/*
	if(room.getName().equals("Main Street")){
	    room.addRole(1, "Railroad Worker", "I'm a steel-drivin' man!");
	    room.addRole(2, "Falls off Roof", "Aaa aii iig ggghh!");
	    room.addRole(2, "Woman in Black Dress", "Well, I'll be!");
	    room.addRole(4, "Mayor McGinty", "People of Deadwood!");
	}
	else if(room.getName().equals("Saloon")){
	    room.addRole(1, "Reluctant Farmer", "I ain't so sure about that!");
	    room.addRole(2, "Woman in Red Dress", "Come up and see me!");
	}
	else if(room.getName().equals("Ranch")){
	    room.addRole(3, "Man Under Horse", "A little help here!");
	    room.addRole(2, "Saucy Fred", "That's what she said!");
	    room.addRole(1, "Shot in Leg", "Ow! Me Leg!");
	}
	else if(room.getName().equals("Secret Hideout")){
	    room.addRole(1, "Clumsy Pit Fighter", "Hit me!");
	    room.addRole(2, "Thug with Knife", "Meet Suzy, my murderin' knife.");
	    room.addRole(3, "Dangerous Tom", "There's two ways we can do this..");
	    room.addRole(4, "Penny, who is Lost", "Oh, Woe! For I am lost!");
	}
	else if(room.getName().equals("Bank")){
	    room.addRole(2, "Suspicious Gentleman", "Can you be more specific?");
	    room.addRole(3, "Flustered Teller", "Would you like a large bill, sir?");
	}
	else if(room.getName().equals("Hotel")){
	    room.addRole(1, "Sleeping Drunkard", "Zzzzzz.. Whiskey!");
	    room.addRole(1, "Faro Player", "Hit me!");
	    room.addRole(2, "Falls from Balcony", "Arrrgghh!!");
	    room.addRole(3, "Australian Bartender", "What'll it be, mate?");
	}
	else if(room.getName().equals("Church")){
	    room.addRole(2, "Crying Woman", "Oh, the humanity!");
	    room.addRole(1, "Dead Man", ".. ..");
	}
	else if(room.getName().equals("Jail")){
	    room.addRole(3, "Feller in Irons", "Ah kilt the wrong man!");
	    room.addRole(2, "Prisoner in Cell", "Zzzzzzz... Whiskey!");
	}
	else if(room.getName().equals("Train Station")){
	    room.addRole(1, "Crusty Prospector", "Aww, peaches!");
	    room.addRole(1, "Dragged by Train", "Omgeezers!");
	    room.addRole(2, "Preacher with Bag", "The lord will provide.");
	    room.addRole(4, "Cyrus the Gunfighter", "Git to fightin' or gitaway!");
	}
	else if(room.getName().equals("General Store")){
	    room.addRole(1, "Man in Overalls", "Looks like a storm's comin' in..");
	    room.addRole(3, "Mister Keach", "Howdy, stranger.");
	}
	*/
    }

}
