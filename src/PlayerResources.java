import java.util.LinkedList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.Color;

public class PlayerResources{

  private ImageIcon[] big;
  static PlayerResources instance;
  static char[] color = new char[]{'b', 'o', 'g', 'r', 'y', 'v', 'p', 'c'};

  public PlayerResources(){
    big = new ImageIcon[6];
    final Class cls = PlayerResources.class;
    //player one = blue, p2 = yellow and so on
    int j =0;
    int count =0;
    for (j =0; j<8; j++){
      for (int i =0; i < 6; i++){
        String fn = String.format("%c%d.png", color[j], i);
        try (InputStream r = cls.getResourceAsStream(fn)) {
          big[count+i] = new ImageIcon (ImageIO.read(r));
        }
        catch (IOException e) {
          System.err.println("fn=\"" + fn + "\"");
          e.printStackTrace();
          System.exit(1);
        }
      }
      count+=6;
    }
  }

  public ImageIcon getIcon(int id, int rank){
    int x =rank + ((id-1)*6);
    /*int count =0;
    for (int j=0; j<8; j++){
      if (c==color[j]){
        x+=count;
      }
      count+=6;
    }*/
    return big[x];
  }

  public static PlayerResources getInstance() {
  if (instance == null)
    instance = new PlayerResources();
  return instance;
  }
}
