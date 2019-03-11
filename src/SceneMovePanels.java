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

public class SceneMovePanels extends JPanel{

    private ArrayList<JLabel> labelList;
    private Controller c;

    public SceneMovePanels(Board board, Controller controller){
	super(null);
	c = controller;

	ArrayList<Room> roomList = board.getRoomList();
	ArrayList<Integer> area;
	
	labelList = new ArrayList<JLabel>();
	setLayout(null);
	setBounds(0, 0, 1200, 900);
	setOpaque(false);

	JLabel l;

	int i = 0;
	while(i < roomList.size() - 2){
	    System.out.println(Arrays.toString(roomList.get(i).getArea().toArray()));
	    l = new JLabel();
	    add(l, 0);
	    labelList.add(l);
	    l.setBounds(roomList.get(i).getArea().get(0), roomList.get(i).getArea().get(1), roomList.get(i).getArea().get(3), roomList.get(i).getArea().get(2));
	    l.setVisible(true);
	    i++;
	}

	// Trailers
	l = new JLabel();
	add(l, 0);
	labelList.add(l);
	l.setBounds(991, 248, 201, 194);
	l.setVisible(true);

	// Casting Office
	l = new JLabel();
	add(l, 0);
	labelList.add(l);
	l.setBounds(9, 459, 209, 208);
	l.setVisible(true);
	
	i = 0;
	while(i < labelList.size()){
	    switch (i){
		
	    case 0: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.tsClick();
			}
		});
		break;
	    case 1: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.shClick();
			}
		});
		break;
	    case 2: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.cClick();
			}
		});
		break;
	    case 3: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.hClick();
			}
		});
		break;
	    case 4: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.msClick();
			}
		});
		break;
	    case 5: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.jClick();
			}
		});
		break;
	    case 6: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.gsClick();
			}
		});
		break;
	    case 7: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.rClick();
			}
		});
		break;
	    case 8: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.bClick();
			}
		});
		break;
	    case 9: labelList.get(i).addMouseListener(new MouseAdapter(){
		        @Override
			public void mouseClicked(MouseEvent e){
			    c.sClick();
			}
		});
		break;
	    case 10: labelList.get(i).addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent e){
			c.tClick();
		    }
		});
		break;
	    case 11: labelList.get(i).addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent e){
			c.coClick();
		    }
		});
		break;
	    }
	    i++;
	}
    }

}

