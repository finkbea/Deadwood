import java.util.LinkedList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.Color;

public class SceneResources{

    private ImageIcon[] big;
    static SceneResources instance;    

    public SceneResources(){
	big = new ImageIcon[40];
	final Class cls = SceneResources.class;
	String fn = "";
	
	for (int i = 0; i < 40; i++){
	    if(i < 9){
		fn = String.format("resources/cards/0%d.png", i+1);
	    }
	    else{
		fn = String.format("resources/cards/%d.png", i+1);
	    }
	    try (InputStream r = cls.getResourceAsStream(fn)) {
		big[i] = new ImageIcon (ImageIO.read(r));
	    }
	    catch (IOException e) {
		System.err.println("fn=\"" + fn + "\"");
		e.printStackTrace();
		System.exit(1);
	    }	
	}
    }

    public ImageIcon getScene(int sceneNum){
	return big[sceneNum-1];
    }

    public static SceneResources getInstance() {
	if (instance == null)
	    instance = new SceneResources();
	return instance;
    }
}
