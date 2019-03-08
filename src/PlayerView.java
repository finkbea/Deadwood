import java.util.LinkedList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.Color;
import java.util.concurrent.*;
import java.util.ArrayList;

public class PlayerView extends JPanel implements Player.Listener{

    private JLabel p1;

    public PlayerView(PlayerResources r, int playerNum){	
	super(null);
	setLayout(null);
	
	p1 = new JLabel();
	add(p1, 0);
	p1.setBounds(0, 0, 40, 40);
	setBounds(1060, 242, 40, 40);
	p1.setIcon(r.getIcon(playerNum, 1));
	p1.setVisible(true);				
    }

    public void playerMoved(Player p){
	//p1.setBounds(p.getCurrentRoom().getBlankSpace().get(0), p.getCurrentRoom().getBlankSpace().get(1), 40, 40);
	//p2.setBounds(500, 500,40,40);
	setBounds(p.getCurrentRoom().getBlankSpace().get(0) - 200, p.getCurrentRoom().getBlankSpace().get(1), 40, 40);
	
	//setLocation(1000, 600);
	//setBounds(1210, 465, 40, 40);
	//p1.setBounds(1000, 240, 40, 40);
	//changeUpgrade(p);
	System.out.println("MOVING PLAYER DICE");
    }

    public void roleTaken(Player p){
	setBounds(p.getRole().getArea().get(0), p.getRole().getArea().get(1), 40, 40);
    }

    public void changeUpgrade(Player p){
	PlayerResources r = PlayerResources.getInstance();
	p1.setIcon(r.getIcon(p.getPid(), p.getRank()));
    }
}
