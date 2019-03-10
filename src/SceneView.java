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

public class SceneView extends JPanel implements Scene.Listener{

    private JLabel scene;
    //public int x, y, h, w;
    //private SceneResources sceneRes;

    public SceneView(SceneResources s, int sceneNum){
	super(null);
	setLayout(null);

	scene = new JLabel();
	add(scene, 0);
	scene.setBounds(0,0,205,115);
  //setBounds(0, 0, 205, 115);
  //scene.setIcon(s.getSceneIcon(1));
	setVisible(true);
    }


  public void showScene(Scene s){
    SceneResources res = SceneResources.getInstance();
    scene.setIcon(res.getSceneIcon(s.getNumber()));
    setBounds(s.getArea().get(0), s.getArea().get(1), s.getArea().get(3), s.getArea().get(2));
    }
    public void closeScene(Scene s){

    }
}
