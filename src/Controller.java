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
	System.out.println("d2 click");
    }

    public void d3Click(){
	System.out.println("d3 click");
    }

    public void d4Click(){
	System.out.println("d4 click");
    }

    public void d5Click(){
	System.out.println("d5 click");
    }

    public void c1Click(){
	System.out.println("c1 click");
    }

    public void c2Click(){
	System.out.println("c2 click");
    }

    public void c3Click(){
	System.out.println("c3 click");
    }

    public void c4Click(){
	System.out.println("c4 click");
    }

    public void c5Click(){
	System.out.println("c5 click");
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
