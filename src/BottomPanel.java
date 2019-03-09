import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*;
import java.awt.BorderLayout;
import java.util.concurrent.*;

// Creates whole bottom panel with buttons
public class BottomPanel{

    private class ButtonMouseListener implements MouseListener{
	public void mouseClicked(MouseEvent event){
	    System.out.println("clicked button");
	}
	public void mouseExited(MouseEvent event){}
	public void mouseEntered(MouseEvent event){}
	public void mousePressed(MouseEvent event){
	    System.out.println("Pressed button");
	}
	public void mouseReleased(MouseEvent event){}
	
    }
    
    public BottomPanel(JFrame mainFrame) throws IOException{
	JPanel bottomPanel = new JPanel();
	bottomPanel.setBounds(200, 900, 1200, 200);
	bottomPanel.setBackground(Color.decode("#D5A458"));
	bottomPanel.setLayout(null);

	JButton a_b = new JButton();
	a_b.setBounds(60, 60, 150, 100);
	a_b.setVisible(true);
	bottomPanel.add(a_b);
	a_b.setLayout(null);
	a_b.setBackground(Color.decode("#79CEDC"));
	JLabel act = new JLabel("Act");
	act.setBounds(60, 40, 150, 15);
	a_b.add(act);
	a_b.addMouseListener(new ButtonMouseListener());

	JButton r_b = new JButton();
	r_b.setBounds(230, 60, 150, 100);
	r_b.setVisible(true);
	bottomPanel.add(r_b);
	r_b.setLayout(null);
	r_b.setBackground(Color.decode("#79CEDC"));
	JLabel rehearse = new JLabel("Rehearse");
	rehearse.setBounds(40, 40, 100, 10);
	r_b.add(rehearse);
	r_b.addMouseListener(new ButtonMouseListener());

	JButton u_b = new JButton();
	u_b.setBounds(400, 60, 150, 100);
	u_b.setVisible(true);
	bottomPanel.add(u_b);
	u_b.setLayout(null);
	JLabel upgrade = new JLabel("Upgrade");
	upgrade.setBounds(40, 40, 100, 15);
	u_b.add(upgrade);
	u_b.addMouseListener(new ButtonMouseListener());
	u_b.setBackground(Color.decode("#79CEDC"));

	JButton e_b = new JButton();
	e_b.setBounds(950, 60, 150, 100);
	e_b.setVisible(true);
	bottomPanel.add(e_b);
	e_b.setLayout(null);
	JLabel end = new JLabel("End Turn");
	end.setBounds(45, 40, 100, 15);
	e_b.add(end);
	e_b.addMouseListener(new ButtonMouseListener());
	e_b.setBackground(Color.decode("#79CEDC"));

	JButton m_b = new JButton();
	m_b.setBounds(570, 60, 150, 100);
	m_b.setVisible(true);
	bottomPanel.add(m_b);
	m_b.setLayout(null);
	JLabel move = new JLabel("Move");
	move.setBounds(50, 40, 100, 15);
	m_b.add(move);
	m_b.addMouseListener(new ButtonMouseListener());
	m_b.setBackground(Color.decode("#79CEDC"));

	mainFrame.add(bottomPanel);
    }
}
