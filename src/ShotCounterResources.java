import java.util.LinkedList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.Color;

public class ShotCounterResources{

    private ImageIcon icon;
    static ShotCounterResources instance;

    public ShotCounterResources(){
	final Class cls = ShotCounterResources.class;
	
	String fn = String.format("resources/shot.png");
	try (InputStream r = cls.getResourceAsStream(fn)) {
	    icon = new ImageIcon (ImageIO.read(r));
	}
	catch (IOException e) {
	    System.err.println("fn=\"" + fn + "\"");
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    public ImageIcon getIcon(){
	return icon;
    }

    public static ShotCounterResources getInstance() {
	if (instance == null)
	    instance = new ShotCounterResources();
	return instance;
    }
}
