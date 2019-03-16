import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*;
import java.awt.BorderLayout;
import java.util.concurrent.*;

// Creates whole bottom panel with buttons
public class BottomPanel implements Player.Listener, Board.Listener{

    private JPanel bottomPanel;
    private JButton a_b, r_b, e_b;

    public BottomPanel(JFrame mainFrame, Controller controller) throws IOException{
	bottomPanel = new JPanel();
	bottomPanel.setBounds(200, 900, 1200, 200);
	bottomPanel.setBackground(Color.decode("#D5A458"));
	bottomPanel.setLayout(null);

	a_b = new JButton();
	a_b.setBounds(60, 60, 150, 100);
	a_b.setVisible(true);
	bottomPanel.add(a_b);
	a_b.setLayout(null);
	a_b.setBackground(Color.decode("#808080"));
	JLabel act = new JLabel("Act");//this gets called whenever the player does anything to change any of their stats, all of their stats are then updated on the stat panel.
	act.setBounds(60, 40, 150, 15);
	a_b.add(act);
	a_b.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseClicked(MouseEvent e){
		    actClick(controller);
		}
	    });
  a_b.setEnabled(false);

	r_b = new JButton();
	r_b.setBounds(230, 60, 150, 100);
	r_b.setVisible(true);
	bottomPanel.add(r_b);
	r_b.setLayout(null);
	r_b.setBackground(Color.decode("#808080"));
	JLabel rehearse = new JLabel("Rehearse");
	rehearse.setBounds(40, 40, 100, 10);
	r_b.add(rehearse);
	r_b.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseClicked(MouseEvent e){
		    rehearseClick(controller);
		}
	    });
  r_b.setEnabled(false);

	e_b = new JButton();
	e_b.setBounds(950, 60, 150, 100);
	e_b.setVisible(true);
	bottomPanel.add(e_b);
	e_b.setLayout(null);
	JLabel end = new JLabel("End Turn");
	end.setBounds(45, 40, 100, 15);
	e_b.add(end);
	e_b.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseClicked(MouseEvent e){
		    endClick(controller);
		}
	    });
	e_b.setBackground(Color.decode("#79CEDC"));

	mainFrame.add(bottomPanel);
    }

    private synchronized void actClick(Controller controller){
      if(a_b.isEnabled()==true){
	controller.actClick();
  a_b.setEnabled(false);
  r_b.setEnabled(false);
  a_b.setBackground(Color.decode("#808080"));
  r_b.setBackground(Color.decode("#808080"));
}
    }

    private synchronized void rehearseClick(Controller controller){
      if(r_b.isEnabled()==true){
	controller.rehearseClick();
  a_b.setEnabled(false);
  r_b.setEnabled(false);
  a_b.setBackground(Color.decode("#808080"));
  r_b.setBackground(Color.decode("#808080"));
}
    }

    private synchronized void endClick(Controller controller){
	controller.endClick();
    }

    //this part of the player intebutton.setDisabledIcon(button.getIcon());rface is not used here
    public void playerMoved(Player p){}

    public void roleTaken(Player p){
      if (p.getRole() !=null && p.getActionUsed() == false){
        a_b.setEnabled(true);
        r_b.setEnabled(true);
        a_b.setBackground(Color.decode("#79CEDC"));
        r_b.setBackground(Color.decode("#79CEDC"));
      }
    }


    public void updateScore(Player p){
      if (p.getRole() !=null && p.getActionUsed() == false){
        a_b.setEnabled(true);
        r_b.setEnabled(true);
        a_b.setBackground(Color.decode("#79CEDC"));
        r_b.setBackground(Color.decode("#79CEDC"));
      }
    }

    public void currentPlayer(Player p){
      a_b.setEnabled(false);
      r_b.setEnabled(false);
      a_b.setBackground(Color.decode("#808080"));
      r_b.setBackground(Color.decode("#808080"));
      roleTaken(p);
    }

    //this part of the board interface is not used here
    public void currentPlayerID(int n){}

}
