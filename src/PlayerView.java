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

  setSize(40, 40);
  //setDoubleBuffered(true);

  p1 = new JLabel();
  add(p1);
  p1.setBounds(1260, 242, 40, 40);
  setVisible(true);
  setFocusable(true);
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
