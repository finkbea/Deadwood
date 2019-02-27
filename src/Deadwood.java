public class Deadwood{

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
