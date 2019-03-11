import java.util.LinkedList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.Color;
import java.util.*;
import java.util.concurrent.*;

public class ShotCounterView extends JPanel implements Room.Listener{

  private JLabel shotCounter;
  private ArrayList<Integer> area;

  public ShotCounterView(ShotCounterResources s, ArrayList<Integer> n){
    super(null);
    setLayout(null);
    shotCounter = new JLabel();
    this.area=n;

    add(shotCounter, 0);
    shotCounter.setBounds(0, 0, n.get(2), n.get(3));
    //setBounds(n.get(0), n.get(1), n.get(2), n.get(3));
    //shotCounter.setIcon(s.getIcon());
    //setBackground(Color.blue);
    setOpaque(false);


    setVisible(true);
    //shotCounter.setVisible(true);

  }

  public void enter(ArrayList<Integer> n){
    ShotCounterResources s = ShotCounterResources.getInstance();
    shotCounter.setIcon(s.getIcon());
    setBounds(area.get(0),area.get(1),area.get(2),area.get(3));
    }
  public void over(){
  }
  public void incrementShots(){
    //setVisible(false);
  }
}
