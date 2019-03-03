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

  setDoubleBuffered(true);

  p1 = new JLabel();
  add(p1);
  p1.setBounds(700, 300, 40, 40);
  setVisible(true);
setFocusable(true);
  }

  public void changeUpgrade(Player p){
    PlayerResources r = PlayerResources.getInstance();
    p1.setIcon(r.getIcon(p.getPid(), p.getRank()));
  }
}
