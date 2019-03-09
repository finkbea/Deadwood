import java.util.LinkedList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*;
import java.util.concurrent.*;

public class SceneView extends JPanel implements Scene.Listener{

    private JLabel scene;
    private SceneResources sceneRes;

    public SceneView(SceneResources s, int sceneNum){
	super(null);
	setLayout(null);

	sceneRes = s;
	scene = new JLabel();
	add(scene, 0);
	scene.setBounds(0,0,205,115);	
	setVisible(true);
    }

    public void enteredRoom(){	
    }

    public void showScene(int sceneNum){
	scene.setIcon(sceneRes.getSceneIcon(sceneNum));
    }
}
