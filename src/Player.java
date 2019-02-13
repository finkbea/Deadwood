
public class Player{

    private int pid;
    private int dollars;
    private int credits;
    private int rank;
    private Room _room;
    private int rehearseTokens;
    
    Player(int p_id){
	pid = p_id;
	dollars = 0;
	credits = 0;
	rank = 1;
	rehearseTokens = 0;
	System.out.println("Created player with pid of "+p_id);
    }

    public int getPid(){
	return pid;
    }

    public int getDollars(){
	return dollars;
    }

    public int getCredits(){
	return credits;
    }

    public int getRank(){
	return rank;
    }

    public void updateRoom(Room room){
	_room = room;
	System.out.println("updating room to: "+_room.getName());
    }
    
    public Room getCurrentRoom(){
	return _room;
    }

    public void rehearse(){
	rehearseTokens++;
    }

    public int getRehearseTokens(){
	return rehearseTokens;
    }

    public void resetRehearseTokens(){
	rehearseTokens = 0;
    }

    public void updateRankAndMoney(int new_rank, int money_type){
	rank = new_rank;
	
	if(new_rank == 2 && money_type == 0){
	    dollars = dollars - 4;
	}
	else if(new_rank == 2 && money_type == 1){
	    credits = credits - 5;
	}
	else if(new_rank == 3 && money_type == 0){
	    dollars = dollars - 10;
	}
	else if(new_rank == 3 && money_type == 1){
	    credits = credits - 10;
	}	
	else if(new_rank == 4 && money_type == 0){
	    dollars = dollars - 18;
	}
	else if(new_rank == 4 && money_type == 1){
	    credits = credits - 15;
	}
	else if(new_rank == 5 && money_type == 0){
	    dollars = dollars - 28;
	}
	else if(new_rank == 5 && money_type == 1){
	    credits = credits - 20;
	}
	else if(new_rank == 6 && money_type == 0){
	    dollars = dollars - 40;
	}
	else if(new_rank == 6 && money_type == 1){
	    credits = credits - 25;
	}
    }
}
