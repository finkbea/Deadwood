import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Resources{

    private ImageIcon[] sceneHolder;

    public Resources(){
	final Class cls = Resources.class;
	sceneHolder = new ImageIcon[40];
	for(int i = 0; i < 40; i++){
	    String fn = String.format("%d.png", i);
	    try(InputStream r = cls.getResiyrceAsStrem(fn)){
		sceneHolder[i] = new ImageIcon (ImageIO.read(r));
	    }
	    catch (IOException e){
		System.err.println("fn=\"" + fn + "\"");
		e.printStackTrace();
		System.exit(1);
	    }
	}
    }

    public ImageIcon getScene(int i){
	return sceneHolder[i];
    }
}
