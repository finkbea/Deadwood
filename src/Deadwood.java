
public class Deadwood{

    public static void main(String args[]){
	if(args.length != 1){
	    System.out.println("Please specify number of players");
	}
	else{
	    int num_players = Integer.parseInt(args[0]);
	    setupGame(num_players);
	}
    }

    private static void setupGame(int num_players){
	Board board = new Board(num_players);

	int i = 0;
	while(i < num_players){ //Adding players to board object
	    Player new_player = new Player(i+1);
	    board.addPlayer(new_player);
	    i++;
	}

	setupRooms(board);
	setupScenes(board);
    }

    private static void setupRooms(Board board){
	Room castingOffice = new Room("Casting Office");
	board.addRoom(castingOffice);
	Room trailers = new Room("Trailers");
	board.addRoom(trailers);
	Room mainStreet = new Room("Main Street");
	board.addRoom(mainStreet);
	Room saloon = new Room("Saloon");
	board.addRoom(saloon);
	Room ranch = new Room("Ranch");
	board.addRoom(ranch);
	Room secretHideout = new Room("Secret Hideout");
	board.addRoom(secretHideout);
	Room bank = new Room("Bank");
	board.addRoom(bank);
	Room hotel = new Room("Hotel");
	board.addRoom(hotel);
	Room church = new Room("Church");
	board.addRoom(church);
	Room jail = new Room("jail");
	board.addRoom(jail);
	Room trainStation = new Room("Train Station");
	board.addRoom(trainStation);
	Room generalStore = new Room("General Store");
	board.addRoom(generalStore);
    }

    private static void setupScenes(Board board){
	// call Scene to setup scene cards
	// then call something else to store the cards somewhere else?

    }
}
