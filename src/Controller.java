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
	executor.execute(() -> GameKeeper.actInput("", board.getCurrentPlayerID(), board));
    }

    public void rehearseClick(){
	executor.execute(() -> GameKeeper.rehearseInput("", board.getCurrentPlayerID(), board));
    }

    public void upgradeClick(){
	executor.execute(() -> GameKeeper.upgradeInput("", board.getCurrentPlayerID(), board));
    }

    public void moveClick(){
	executor.execute(() -> System.out.println("do move stuff"));
    }

    public void endClick(){
	executor.execute(() -> board.setCurrentPlayerID(board.getCurrentPlayerID() + 1));
    }

    public void clickScene(Room room){
	executor.execute(() -> System.out.println(room.getName()));
    }
}
