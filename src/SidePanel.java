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

public class SidePanel extends JPanel implements Player.Listener{

  private JPanel sidePanel;
  private ArrayList<JLabel> names;
  private ArrayList<JLabel> scores;
  private ArrayList<JLabel> ranks;
  private ArrayList<JLabel> dollars;
  private ArrayList<JLabel> credits;
  private ArrayList<JLabel> rehearses;

  public SidePanel(JFrame mainFrame, ArrayList<Player> players) throws IOException {
    names = new ArrayList<JLabel>();
    scores = new ArrayList<JLabel>();
    ranks = new ArrayList<JLabel>();
    dollars = new ArrayList<JLabel>();
    credits = new ArrayList<JLabel>();
    rehearses = new ArrayList<JLabel>();
    sidePanel = new JPanel();
    setLayout(null);
    setBounds(0, 0, 200, 900);
    Color[] backGroundColor = new Color[]{Color.blue, Color.orange, Color.green, Color.red, Color.yellow, Color.magenta, Color.pink, Color.cyan};
    //sidePanel.setBackground(backGroundColor[board.getCurrentPlayerID()]);
    setBackground(Color.decode("#0F2043"));

    JLabel statPanel = new JLabel("Stat Panel:");
    statPanel.setBounds(20,0,160,30);
    statPanel.setForeground(Color.white);
    add(statPanel);
    //JLabel playerStats;
    for (int i =0; i<players.size(); i++){
      JLabel name = new JLabel("Player: "+players.get(i).getPid()+"");
      name.setBounds(20,-70+(100*(i+1)),160,15);
      name.setForeground(backGroundColor[i]);
      names.add(name);

      JLabel score = new JLabel("Score: "+players.get(i).getScore());
      score.setBounds(20,-55+(100*(i+1)),160,15);
      score.setForeground(backGroundColor[i]);
      scores.add(score);

      JLabel rank = new JLabel("Rank: "+players.get(i).getRank()+"");
      rank.setBounds(20,-40+(100*(i+1)),160,15);
      rank.setForeground(backGroundColor[i]);
      ranks.add(rank);

      JLabel dollar = new JLabel("Dollars: "+players.get(i).getDollars());
      dollar.setBounds(20,-25+(100*(i+1)),160,15);
      dollar.setForeground(backGroundColor[i]);
      dollars.add(dollar);

      JLabel credit = new JLabel("Credits: "+players.get(i).getCredits());
      credit.setBounds(20,-10+(100*(i+1)),160,15);
      credit.setForeground(backGroundColor[i]);
      credits.add(credit);

      JLabel rehearse = new JLabel("Times Rehearsed: "+players.get(i).getRehearseTokens());
      rehearse.setBounds(20,5+(100*(i+1)),160,15);
      rehearse.setForeground(backGroundColor[i]);
      rehearses.add(rehearse);

      add(name);
      add(score);
      add(rank);
      add(dollar);
      add(credit);
      add(rehearse);
    }
    setVisible(true);
  }
  public void playerMoved(Player p){

  }
  public void roleTaken(Player p){

  }

  public void updateScore(Player p){
    int x = p.getPid()-1;
    scores.get(x).setText("Score: "+p.getScore());
    ranks.get(x).setText("Rank: "+p.getRank());
    dollars.get(x).setText("Dollars: "+p.getDollars());
    credits.get(x).setText("Credits: "+p.getCredits());
    rehearses.get(x).setText("Times Rehearsed: "+p.getRehearseTokens());
  }
}
