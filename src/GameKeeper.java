import java.util.*;
//import java.util.Random;

public class GameKeeper{

    public static void startGame(Board board){
	System.out.println("Get ready to rumble! Starting game!");
	int turn;
	resetPlayers(board);
	
	hydrateSets(board);
	turn = 1;
	while(turn <= board.getNumPlayers()){
	    listener(board, turn);
	    turn++;
	}
    }

    private static void hydrateSets(Board board){
	board.hydrateSets();
    }
    
    private static int updateTurn(int turn){
	return(turn+1);
    }

    private static void listener(Board board, int turn){
	String command="";
	Scanner sc;
	int turnEnd = 0;
	while(turnEnd == 0){
	    sc = new Scanner(System.in);
	    command = sc.nextLine();
	    turnEnd = (inputAdmin(command, turn, board));	    
	    //System.out.println(command);
	}
    }

    private static int inputAdmin(String command, int turn, Board board){
	int turnEnd = 0;
	if(command.equals("end")){
	    turnEnd = 1;
	}
	else if(command.equals("who")){
	    Player temp = board.getPlayer(turn);
	    System.out.println("Player "+turn+": ($:"+temp.getDollars()+", cr:"+temp.getCredits()+
			       ", rank:"+temp.getRank()+")");
	    System.out.println("also need to add compatibility if the current player is working on any parts");
	}
	else if(command.equals("where")){
	    Player temp = board.getPlayer(turn);
	    Scene temp_scene = temp.getCurrentRoom().getScene();
	    System.out.println("in "+temp.getCurrentRoom().getName()+" shooting "+temp_scene);
	    System.out.println("TODO: make sure its returning the scene properly..");
	}
	else if(command.contains("move")){
	    Player temp = board.getPlayer(turn);
	    String desired_room_string = getDesiredRoom(command);
	    Room desired_room = board.getRoom(desired_room_string);
	    temp.updateRoom(desired_room);
	    System.out.println("todo: need to check if room is neighboring room first");
	}
	else if(command.equals("rehearse")){
	    Player temp = board.getPlayer(turn);
	    temp.rehearse();
	    System.out.println("TODO: make sure in a role");
	}
	else if(command.equals("act")){
	    Player temp = board.getPlayer(turn);
	    int roll = rollDice(1);	   
	    int budget = temp.getCurrentRoom().getScene().getBudget();

	    if(roll < budget){
		System.out.println("fail roll");
	    }
	    else if(roll >= budget){
		System.out.println("success roll");
	    }
	    System.out.println("TODO: make sure player is in a part, and did not just move");
	}
	else if(command.contains("upgrade")){
	    Player temp = board.getPlayer(turn);
	    int money_type = getMoneyType(command);
	    int new_rank = getNewRank(command);

	    temp.updateRankAndMoney(new_rank, money_type);
	    System.out.println("new rank: "+temp.getRank());
	    
	    System.out.println("todo: make sure we're in casting office to upgrade and make sure we have the funds to do the transaction and make sure 2 < newrank < 6");	    
	}
	else if(command.contains("work")){
	    Player temp = board.getPlayer(turn);
	    String desired_role_string = getDesiredRoleString(command);
	    Role role = findRole(desired_role_string, temp);      
	    
	    temp.setRole(role);

	    System.out.println("player just took the role: "+temp.getRole().getName());
	    System.out.println("need to make sure not in another role, and role is not already taken");
	}
	else{
	    System.out.println("Command not recognized, please try again. ");
	}
	return(turnEnd);
    }

    private static void resetPlayers(Board board){
	int pnum = 1;
	int i = 0;
	while(i < board.getPlayerListSize()){
	    board.getPlayer(pnum).updateRoom(board.getTrailers());
	    board.getPlayer(pnum).resetRehearseTokens();
	    pnum++;
	    i++;
	}
    }

    private static String getDesiredRoom(String command){
	String temp = "";
	String[] tokens = command.split(" ");
	if(tokens.length > 2){
	    temp += tokens[1] + " " + tokens[2];
	}
	else{
	    temp += tokens[1];
	}
	return temp;
    }

    // returns 0 for dollars, 1 for credits
    private static int getMoneyType(String command){
	int type = 0;
	String temp = "";
	String[] tokens = command.split(" ");	
	temp += tokens[1];
	if(temp.equals("$")){
	    type = 0;
	}
	else if(temp.equals("cr")){
	    type = 1;
	}
	else{
	    System.out.println("Bad money type. You messed things up. Everything is messed up now. Nice.");
	}
	return type;
    }

    private static int getNewRank(String command){
	int type;
	String temp = "";
	String[] tokens = command.split(" ");	
	temp += tokens[2];
	type = Integer.parseInt(temp);
	
	return type;
    }

    private static int rollDice(int numberOfDice){
	Random rand = new Random();
	int roll = rand.nextInt(7);
	return roll;
    }

    private static String getDesiredRoleString(String command){
	String temp = "";
	String[] tokens = command.split(" ");

	if(tokens.length > 2){
	    temp += tokens[1] + " " + tokens[2];
	}
	else{
	    temp += tokens[1];
	}

	System.out.println("Role: "+temp);
	return temp;
    }

    private static Role findRole(String desired_role, Player p){
	Role role = new Role(1, "Fake Role", "You messed something up and now the roles are messed up");
	int found = 0;
	Room room = p.getCurrentRoom();
	for(int i = 0; i < room.getNumberOfRoles(); i++){
	    if(room.getRoles().get(i).getName().equals(desired_role)){
		role = room.getRoles().get(i);
		found = 1;
	    }
	}
	if(found == 0){
	    Scene scene = room.getScene();
	    for(int i = 0; i < scene.getNumberOfRoles(); i++){
		if(scene.getRoles().get(i).getName().equals(desired_role)){
		    role = scene.getRoles().get(i);
		    found = 1;
		}
	    }
	}
	if(found == 0){
	    System.out.println("You input bad role.. things are messed up now. nice. ");
	}
	return role;
    }
}
