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

    public void d1Click(){
	System.out.println("d1 click");
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
    
    public void tsClick(){
	executor.execute(() -> GameKeeper.moveInput("Train Station", board.getCurrentPlayerID(), board));
    }

    public void shClick(){
	executor.execute(() -> GameKeeper.moveInput("Secret Hideout", board.getCurrentPlayerID(), board));
    }

    public void cClick(){
	executor.execute(() -> GameKeeper.moveInput("Church", board.getCurrentPlayerID(), board));
    }

    public void hClick(){
	executor.execute(() -> GameKeeper.moveInput("Hotel", board.getCurrentPlayerID(), board));
    }

    public void msClick(){
	executor.execute(() -> GameKeeper.moveInput("Main Street", board.getCurrentPlayerID(), board));
    }

    public void jClick(){
	executor.execute(() -> GameKeeper.moveInput("Jail", board.getCurrentPlayerID(), board));
    }

    public void gsClick(){
	executor.execute(() -> GameKeeper.moveInput("General Store", board.getCurrentPlayerID(), board));
    }

    public void rClick(){
	executor.execute(() -> GameKeeper.moveInput("Ranch", board.getCurrentPlayerID(), board));
    }

    public void bClick(){
	executor.execute(() -> GameKeeper.moveInput("Bank", board.getCurrentPlayerID(), board));
    }

    public void sClick(){
	executor.execute(() -> GameKeeper.moveInput("Saloon", board.getCurrentPlayerID(), board));
    }

    public void tClick(){
	executor.execute(() -> GameKeeper.moveInput("Trailers", board.getCurrentPlayerID(), board));
    }

    public void coClick(){
	executor.execute(() -> GameKeeper.moveInput("Casting Office", board.getCurrentPlayerID(), board));
    }
    
}
