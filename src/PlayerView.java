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
    private int panelOffSet;

    public PlayerView(PlayerResources r, int playerNum){
	super(null);
	setLayout(null);

	panelOffSet = (playerNum-1) * 5;
	
	p1 = new JLabel();
	add(p1, 0);
	p1.setBounds(0, 0, 40, 40);
	setBounds(1060 + panelOffSet, 242, 40, 40);
	p1.setIcon(r.getIcon(playerNum, 1));
	p1.setVisible(true);
    }

    public void playerMoved(Player p){
	int xOffSet = 0;
	int yOffSet = 0;
	if(p.getCurrentRoom().getName().equals("Bank") || p.getCurrentRoom().getName().equals("Casting Office")){
	    yOffSet = panelOffSet;
	}
	else{
	    xOffSet = panelOffSet;
	}
	setBounds(p.getCurrentRoom().getBlankSpace().get(0) - 200 + xOffSet, p.getCurrentRoom().getBlankSpace().get(1) + yOffSet, 40, 40);
    }

    public void roleTaken(Player p){
	setBounds(p.getRole().getArea().get(0), p.getRole().getArea().get(1), 40, 40);
    }

    public void updateScore(Player p){
	PlayerResources r = PlayerResources.getInstance();
	p1.setIcon(r.getIcon(p.getPid(), p.getRank()));
    }

}
