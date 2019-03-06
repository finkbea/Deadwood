import java.util.LinkedList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.Color;

public class PlayerView extends JPanel implements Player.Listener{

    private JLabel p1;

    public PlayerView(){
	super(null);

	try{
	    //BufferedImage image = ImageIO.read(new File("resources/dice/b1.png"));
	    p1 = new JLabel();//new ImageIcon(image));
	    add(p1, 0);
	    p1.setBounds(0, 0, 40, 40);
	    setBounds(1100, 400, 40, 40);
	    setVisible(true);
	}
	catch(Exception e){
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    public synchronized void playerMoved(Player p){
	p1.setBounds(p.getCurrentRoom().getBlankSpace().get(0), p.getCurrentRoom().getBlankSpace().get(1), 40, 40);
    }
    public synchronized void roleTaken(Player p){
	p1.setBounds(p.getRole().getArea().get(0), p.getRole().getArea().get(1), 40, 40);
    }

    public synchronized void changeUpgrade(Player p){
	PlayerResources r = PlayerResources.getInstance();
	p1.setIcon(r.getIcon(p.getPid(), p.getRank()));
    }
}
