import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*;
import java.awt.BorderLayout;

public class CreateShotCountersPanels{

    public static void main(JFrame mainFrame, ShotCounterResources sc){
	sc = ShotCounterResources.getInstance();
	JLabel shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	
	JPanel shotCounter1 = new JPanel();
	shotCounter1.setBounds(236, 11, 47, 47);
	mainFrame.add(shotCounter1);
	shotCounter1.add(shotCounter);
	shotCounter1.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter2 = new JPanel();
	shotCounter2.setBounds(289, 11, 47, 47);
	mainFrame.add(shotCounter2);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter2.add(shotCounter);
	shotCounter2.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter3 = new JPanel();
	shotCounter3.setBounds(341, 11, 47, 47);
	mainFrame.add(shotCounter3);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter3.add(shotCounter);
	shotCounter3.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter4 = new JPanel();
	shotCounter4.setBounds(442, 764, 47, 47);
	mainFrame.add(shotCounter4);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter4.add(shotCounter);
	shotCounter4.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter5 = new JPanel();
	shotCounter5.setBounds(499, 764, 47, 47);
	mainFrame.add(shotCounter5);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter5.add(shotCounter);
	shotCounter5.setBackground(Color.decode("#FDF5E6"));

	JPanel shotCounter6 = new JPanel();
	shotCounter6.setBounds(554, 764, 47, 47);
	mainFrame.add(shotCounter6);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter6.add(shotCounter);
	shotCounter6.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter7 = new JPanel();
	shotCounter7.setBounds(823, 675, 47, 47);
	mainFrame.add(shotCounter7);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter7.add(shotCounter);
	shotCounter7.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter8 = new JPanel();
	shotCounter8.setBounds(882, 675, 47, 47);
	mainFrame.add(shotCounter8);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter8.add(shotCounter);
	shotCounter8.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter9 = new JPanel();
	shotCounter9.setBounds(1205, 683, 47, 47);
	mainFrame.add(shotCounter9);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter9.add(shotCounter);
	shotCounter9.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter10 = new JPanel();
	shotCounter10.setBounds(1258, 683, 47, 47);
	mainFrame.add(shotCounter10);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter10.add(shotCounter);
	shotCounter10.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter11 = new JPanel();
	shotCounter11.setBounds(1311, 683, 47, 47);
	mainFrame.add(shotCounter11);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter11.add(shotCounter);
	shotCounter11.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter12 = new JPanel();
	shotCounter12.setBounds(1112, 23, 47, 47);
	mainFrame.add(shotCounter12);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter12.add(shotCounter);
	shotCounter12.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter13 = new JPanel();
	shotCounter13.setBounds(1058, 23, 47, 47);
	mainFrame.add(shotCounter13);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter13.add(shotCounter);
	shotCounter13.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter14 = new JPanel();
	shotCounter14.setBounds(1004, 23, 47, 47);
	mainFrame.add(shotCounter14);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter14.add(shotCounter);
	shotCounter14.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter15 = new JPanel();
	shotCounter15.setBounds(642, 156, 47, 47);
	mainFrame.add(shotCounter15);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter15.add(shotCounter);
	shotCounter15.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter16 = new JPanel();
	shotCounter16.setBounds(513, 277, 47, 47);
	mainFrame.add(shotCounter16);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter16.add(shotCounter);
	shotCounter16.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter17 = new JPanel();
	shotCounter17.setBounds(513, 330, 47, 47);
	mainFrame.add(shotCounter17);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter17.add(shotCounter);
	shotCounter17.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter18 = new JPanel();
	shotCounter18.setBounds(672, 473, 47, 47);
	mainFrame.add(shotCounter18);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter18.add(shotCounter);
	shotCounter18.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter19 = new JPanel();
	shotCounter19.setBounds(725, 473, 47, 47);
	mainFrame.add(shotCounter19);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter19.add(shotCounter);
	shotCounter19.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter20 = new JPanel();
	shotCounter20.setBounds(1040, 549, 47, 47);
	mainFrame.add(shotCounter20);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter20.add(shotCounter);
	shotCounter20.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter21 = new JPanel();
	shotCounter21.setBounds(826, 216, 47, 47);
	mainFrame.add(shotCounter21);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter21.add(shotCounter);
	shotCounter21.setBackground(Color.decode("#FDF5E6"));
	
	JPanel shotCounter22 = new JPanel();
	shotCounter22.setBounds(879, 216, 47, 47);
	mainFrame.add(shotCounter22);
	shotCounter = new JLabel();
	shotCounter.setBounds(0, 0, 42, 42);
	shotCounter.setIcon(sc.getIcon());
	shotCounter.setVisible(true);
	shotCounter22.add(shotCounter);
	shotCounter22.setBackground(Color.decode("#FDF5E6"));
    }

}
