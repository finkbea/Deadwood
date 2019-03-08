import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*; 

public class SceneView extends JPanel {

    private JLabel scene;

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

}
