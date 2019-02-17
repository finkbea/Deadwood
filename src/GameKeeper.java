import java.util.*;
//import java.util.Random;

public class GameKeeper{

    public static void startGame(Board board){
	System.out.println("Get ready to rumble! Starting game!");
	int turn;
	int day = 1;
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
	    System.out.println("Player "+turn+" turn is over.");
	}
	else if(command.equals("who")){
	    Player temp = board.getPlayer(turn);
	    System.out.print("Player "+turn+": ($:"+temp.getDollars()+", cr:"+temp.getCredits()+
			       ", rank:"+temp.getRank());
	    if(temp.getRole() != null){
		System.out.print(", role:"+temp.getRole().getName()+")\n");
	    }
	    else{
		System.out.print(")\n");
	    }
	}
	else if(command.equals("where")){
	    Player temp = board.getPlayer(turn);
	    if(temp.getCurrentRoom().getScene() != null){
		Scene temp_scene = temp.getCurrentRoom().getScene();
		System.out.println("in "+temp.getCurrentRoom().getName()+" shooting "+temp_scene.getName());
	    }
	    else{
		    System.out.println("in "+temp.getCurrentRoom().getName());
	    }
	}
	else if(command.contains("move")){
	    Player temp = board.getPlayer(turn);
	    String desired_room_string = getDesiredRoom(command);
	    Room desired_room = board.getRoom(desired_room_string);
	    Room current_room = temp.getCurrentRoom();
	    if(current_room.isNeighbor(desired_room) == 1){
		temp.updateRoom(desired_room);
	    }
	    else{
		System.out.println("Room is not neighboring room. Try something else.");
	    }
	    System.out.println("todo:make sure we didn't act/rehearse/move/work already");
	}
	else if(command.equals("rehearse")){
	    Player temp = board.getPlayer(turn);
	    temp.rehearse();
	    System.out.println("TODO: make sure in a role");
	}
	else if(command.equals("act")){
	    Player temp = board.getPlayer(turn);
	    if(temp.getCurrentRoom().getShotCounters() > 0){
		if(temp.getRole() == null){
		    System.out.println("No current role. Try something else.");
		}
		else{
		    int roll = rollDice(1);	   
		    int budget = temp.getCurrentRoom().getScene().getBudget();
		    
		    if(roll < budget){
			payoutFail(temp);
			System.out.println("fail roll");
		    }
		    else if(roll >= budget){
			System.out.println("success roll");
			temp.getCurrentRoom().removeShot();
			payoutSuccess(temp);
			if(temp.getCurrentRoom().getShotCounters() == 0){
			    wrapScene(temp.getCurrentRoom(), board);
			}
		    }
		}
	    }
	    else{
		System.out.println("Scene is wrapped already.");
	    }
	    System.out.println("TODO: make sure player did not just move/rehearse/work");
	}
	else if(command.contains("upgrade")){
	    Player temp = board.getPlayer(turn);	
	    if(!temp.getCurrentRoom().getName().equals("Casting Office")){
		System.out.println("Not in Casting Office. Try again.");
	    }
	    else{
		int money_type = getMoneyType(command);
		int new_rank = getNewRank(command);
		if(new_rank < 2 || new_rank > 6){
		    System.out.println("Bad rank. Try again.");
		}
		else{
		    if(getPlayerFunds(temp, money_type, new_rank) == 0){
			System.out.println("Not enough money for upgrade.");
		    }
		    else{
			temp.updateRankAndMoney(new_rank, money_type);
			System.out.println("new rank: "+temp.getRank());
		    }
		}
	    }
	}
	else if(command.contains("work")){
	    Player temp = board.getPlayer(turn);
	    String desired_role_string = getDesiredRoleString(command);
	    Role role = findRole(desired_role_string, temp);
	    int role_type = getRoleType(desired_role_string, temp);
	    if(temp.getRank() >= role.getRank() && temp.getRole() == null && role.isBeingWorked() == 0){
		temp.setRole(role);
		role.workRole();
		temp.setRoleType(role_type);
		System.out.println("player just took the role: "+temp.getRole().getName());
	    }
	    else{
		System.out.println("The role rank is larger than player rank or "+
		    "the player already has a role or the role is already taken. Try again.");
	    }

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
	    board.getPlayer(pnum).resetRole();
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

	if(tokens.length == 3){
	    temp += tokens[1] + " " + tokens[2];
	}
	else if(tokens.length == 4){
	    temp += tokens[1] + " " + tokens[2] + " " + tokens[3];
	}
	else if(tokens.length == 5){
	    temp += tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
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

    // returns 0 for not enough, 1 for enough funds for rank
    private static int getPlayerFunds(Player temp, int money_type, int new_rank){
	int enough_money = 0;
        if(new_rank == 2 && money_type == 0 && temp.getDollars() >= 4){
	    enough_money = 1;
	}
	else if(new_rank == 2 && money_type == 1 && temp.getCredits() >= 5){
	    enough_money = 1;
	}
	else if(new_rank == 3 && money_type == 0 && temp.getDollars() >= 10){
	    enough_money = 1;
	}
	else if(new_rank == 3 && money_type == 1 && temp.getCredits() >= 10){
	    enough_money = 1;
	}
	else if(new_rank == 4 && money_type == 0 && temp.getDollars() >= 18){
	    enough_money = 1;
	}
	else if(new_rank == 4 && money_type == 1 && temp.getCredits() >= 15){
	    enough_money = 1;
	}
	else if(new_rank == 5 && money_type == 0 && temp.getDollars() >= 28){
	    enough_money = 1;
	}
	else if(new_rank == 5 && money_type == 1 && temp.getCredits() >= 20){
	    enough_money = 1;
	}
	else if(new_rank == 6 && money_type == 0 && temp.getDollars() >= 40){
	    enough_money = 1;
	}
	else if(new_rank == 6 && money_type == 1 && temp.getCredits() >= 25){
	    enough_money = 1;
	}
      
	return enough_money;
    }

    private static void wrapScene(Room room, Board board){
	ArrayList<Player> players_in_room_with_roles = new ArrayList<Player>();
	for(int i = 0; i < board.getPlayerListSize(); i++){
	    if(board.getPlayer(i+1).getCurrentRoom().getName().equals(room.getName())
	       && board.getPlayer(i+1).getRole() != null){		
		players_in_room_with_roles.add(board.getPlayer(i+1));
	    }
	}

	ArrayList<Player> main_role_players = new ArrayList<Player>();
	for(int i = 0; i < board.getPlayerListSize(); i++){
	    if(board.getPlayer(i+1).getRoleType() == 1){
		main_role_players.add(board.getPlayer(i+1));
	    }
	}
	
	if(main_role_players.size() > 0){
	    ArrayList<Integer> rolls = new ArrayList<Integer>();
	    for(int i = 0; i < room.getScene().getBudget(); i++){
		rolls.add(rollDice(1));
	    }
	    Collections.sort(rolls);
	    int j = rolls.size()-1;
	    for(int i = 0; i < rolls.size(); i++){
		main_role_players.get(i).addCurrency(0, rolls.get(j));
		j--;
		if( (i+1) == main_role_players.size() ){
		    i = 0;
		}
	    }
	}
	
	for(int i = 0; i < players_in_room_with_roles.size(); i++){
	    players_in_room_with_roles.get(i).resetRole();
	}

	for(int i = 0; i < main_role_players.size(); i++){
	    main_role_players.get(i).resetRole();
	}
	room.wrapScene();
	
    }

    // returns 0 for room role, 1 for scene role
    private static int getRoleType(String desired_role, Player p){
	int role_type = -1;
	Role role = new Role(1, "Fake Role", "You messed something up and now the roles are messed up");
	int found = 0;
	Room room = p.getCurrentRoom();
	for(int i = 0; i < room.getNumberOfRoles(); i++){
	    if(room.getRoles().get(i).getName().equals(desired_role)){
		role = room.getRoles().get(i);
		found = 1;
		role_type = 0;
	    }
	}
	if(found == 0){
	    Scene scene = room.getScene();
	    for(int i = 0; i < scene.getNumberOfRoles(); i++){
		if(scene.getRoles().get(i).getName().equals(desired_role)){
		    role = scene.getRoles().get(i);
		    found = 1;
		    role_type = 1;
		}
	    }
	}
	if(found == 0){
	    System.out.println("You input bad role.. things are messed up now. nice. ");
	}
	return role_type;
    }

    private static void payoutSuccess(Player p){
	if(p.getRoleType() == 0){
	    p.addCurrency(0, 1);
	    p.addCurrency(1, 1);
	}
	else{
	    p.addCurrency(1, 2);
	}
    }

    private static void payoutFail(Player p){
	if(p.getRoleType() == 0){
	    p.addCurrency(0, 1);
	}
    }
}

