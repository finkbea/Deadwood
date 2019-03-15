import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.util.concurrent.*;
import java.awt.Color;

public class Controller extends JPanel {

    private Board board;
    private Executor executor;
    
    public Controller(Board b){
	board = b;
	executor = Executors.newSingleThreadExecutor();	
    }

    public void actClick(){
	executor.execute(() -> {
		if(GameKeeper.isCommandLegal(board, board.getCurrentPlayerID(), "act") == true){
		    GameKeeper.actInput("", board.getCurrentPlayerID(), board);
		}		
	    });
    }

    public void rehearseClick(){
	executor.execute(() -> {
		if(GameKeeper.isCommandLegal(board, board.getCurrentPlayerID(), "rehearse") == true){
		    GameKeeper.rehearseInput("", board.getCurrentPlayerID(), board);		    
		}		
	    });
    }

    public void moveClick(){
	executor.execute(() -> System.out.println("do move stuff"));
    }

    public void endClick(){
	executor.execute(() -> {
		board.getPlayer(board.getCurrentPlayerID()).resetMove();
		board.getPlayer(board.getCurrentPlayerID()).resetAction();
		board.setCurrentPlayerID(board.getCurrentPlayerID() + 1);		
	    });
    }

    public void d1Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 0, 2) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(2);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(0, -4);
		}
	    });

    }

    public void d2Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 0, 3) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(3);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(0, -10);
		}
	    });
    }

    public void d3Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 0, 4) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(4);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(0, -18);
		}
	    });
    }

    public void d4Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 0, 5) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(5);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(0, -28);
		}
	    });
    }

    public void d5Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 0, 6) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(6);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(0, -40);
		}
	    });
    }

    public void c1Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 1, 2) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(2);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(1, -5);
		}
	    });
    }

    public void c2Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 1, 3) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(3);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(1, -10);
		}
	    });
    }

    public void c3Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 1, 4) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(4);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(1, -15);
		}
	    });
    }

    public void c4Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 1, 5) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(5);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(1, -20);
		}
	    });
    }

    public void c5Click(){
	executor.execute(() -> {
		if(GameKeeper.getPlayerFunds(board.getPlayer(board.getCurrentPlayerID()), 1, 6) == 1
		   && board.getPlayer(board.getCurrentPlayerID()).getCurrentRoom().getName().equals("Casting Office")){
		    board.getPlayer(board.getCurrentPlayerID()).setRank(6);
		    board.getPlayer(board.getCurrentPlayerID()).addCurrency(1, -25);
		}
	    });
    }
    
    public void roomClick(String roomName){
	executor.execute(() -> {
		String cmd = "move "+ roomName;
		if(GameKeeper.isCommandLegal(board, board.getCurrentPlayerID(), cmd) == true){
		    GameKeeper.moveInput(board.getRoom(roomName).getName(), board.getCurrentPlayerID(), board);
	        }
	    });
    }

    public void roleClick(String roleName){
	executor.execute(() -> {
		String cmd = "work " + roleName;
		if(GameKeeper.isCommandLegal(board, board.getCurrentPlayerID(), cmd) == true){
		    GameKeeper.workInput(roleName, board.getCurrentPlayerID(), board);
		}
	    });	
    }
}
