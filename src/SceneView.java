import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*; 

public class SceneView extends JPanel{

    private JLabel scene1;
    private JLabel scene2;
    private JLabel scene3;
    private JLabel scene4;
    private JLabel scene5;
    private JLabel scene6;
    private JLabel scene7;
    private JLabel scene8;
    private JLabel scene9;
    private JLabel scene10;

    SceneView(){
	super(null);

	setSize(700, 167);
	setDoubleBuffered(true);

	scene1 = new JLabel();
	add(scene1);
	scene1.setBounds(0,0,100,167);

	setVisible(true);
	setFocusable(true);
    }

    public JLabel getScene(int i){
	
    }
}
