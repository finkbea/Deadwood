// This is its own file because it is long and tedious and looks gross!
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.*;
import java.awt.BorderLayout;

public class CreateBlankAreaPanels{

    // creates the spot for players to stand on when they are in a room but not in a role
    public static void main(JFrame mainFrame) throws IOException{
/*
	JPanel t_s1 = new JPanel();
	t_s1.setBounds(210, 225, 40, 40);
	t_s1.setBackground(Color.red);
	mainFrame.add(t_s1);
	JPanel t_s2 = new JPanel();
	t_s2.setBounds(215, 225, 40, 40);
	t_s2.setBackground(Color.blue);
	mainFrame.add(t_s2);
	JPanel t_s3 = new JPanel();
	t_s3.setBounds(220, 225, 40, 40);
	t_s3.setBackground(Color.green);
	mainFrame.add(t_s3);
	JPanel t_s4 = new JPanel();
	t_s4.setBounds(225, 225, 40, 40);
	t_s4.setBackground(Color.black);
	mainFrame.add(t_s4);
	JPanel t_s5 = new JPanel();
	t_s5.setBounds(230, 225, 40, 40);
	t_s5.setBackground(Color.cyan);
	mainFrame.add(t_s5);
	JPanel t_s6 = new JPanel();
	t_s6.setBounds(235, 225, 40, 40);
	t_s6.setBackground(Color.darkGray);
	mainFrame.add(t_s6);
	JPanel t_s7 = new JPanel();
	t_s7.setBounds(240, 225, 40, 40);
	t_s7.setBackground(Color.gray);
	mainFrame.add(t_s7);
	JPanel t_s8 = new JPanel();
	t_s8.setBounds(245, 225, 40, 40);
	t_s8.setBackground(Color.magenta);
	mainFrame.add(t_s8);

	JPanel j1 = new JPanel();
	j1.setBounds(480, 190, 40, 40);
	j1.setBackground(Color.red);
	mainFrame.add(j1);
	JPanel j2 = new JPanel();
	j2.setBounds(485, 190, 40, 40);
	j2.setBackground(Color.blue);
	mainFrame.add(j2);
	JPanel j3 = new JPanel();
	j3.setBounds(490, 190, 40, 40);
	j3.setBackground(Color.green);
	mainFrame.add(j3);
	JPanel j4 = new JPanel();
	j4.setBounds(495, 190, 40, 40);
	j4.setBackground(Color.black);
	mainFrame.add(j4);
	JPanel j5 = new JPanel();
	j5.setBounds(500, 190, 40, 40);
	j5.setBackground(Color.cyan);
	mainFrame.add(j5);
	JPanel j6 = new JPanel();
	j6.setBounds(505, 190, 40, 40);
	j6.setBackground(Color.darkGray);
	mainFrame.add(j6);
	JPanel j7 = new JPanel();
	j7.setBounds(510, 190, 40, 40);
	j7.setBackground(Color.gray);
	mainFrame.add(j7);
	JPanel j8 = new JPanel();
	j8.setBounds(515, 190, 40, 40);
	j8.setBackground(Color.magenta);
	mainFrame.add(j8);

	JPanel ms1 = new JPanel();
	ms1.setBounds(1260, 192, 40, 40);
	ms1.setBackground(Color.red);
	mainFrame.add(ms1);
	JPanel ms2 = new JPanel();
	ms2.setBounds(1265, 192, 40, 40);
	ms2.setBackground(Color.blue);
	mainFrame.add(ms2);
	JPanel ms3 = new JPanel();
	ms3.setBounds(1270, 192, 40, 40);
	ms3.setBackground(Color.green);
	mainFrame.add(ms3);
	JPanel ms4 = new JPanel();
	ms4.setBounds(1275, 192, 40, 40);
	ms4.setBackground(Color.black);
	mainFrame.add(ms4);
	JPanel ms5 = new JPanel();
	ms5.setBounds(1280, 192, 40, 40);
	ms5.setBackground(Color.cyan);
	mainFrame.add(ms5);
	JPanel ms6 = new JPanel();
	ms6.setBounds(1285, 192, 40, 40);
	ms6.setBackground(Color.darkGray);
	mainFrame.add(ms6);
	JPanel ms7 = new JPanel();
	ms7.setBounds(1290, 192, 40, 40);
	ms7.setBackground(Color.gray);
	mainFrame.add(ms7);
	JPanel ms8 = new JPanel();
	ms8.setBounds(1295, 192, 40, 40);
	ms8.setBackground(Color.magenta);
	mainFrame.add(ms8);

	JPanel co1 = new JPanel();
	co1.setBounds(210, 540, 40, 40);
	co1.setBackground(Color.red);
	mainFrame.add(co1);
	JPanel co2 = new JPanel();
	co2.setBounds(210, 545, 40, 40);
	co2.setBackground(Color.blue);
	mainFrame.add(co2);
	JPanel co3 = new JPanel();
	co3.setBounds(210, 550, 40, 40);
	co3.setBackground(Color.green);
	mainFrame.add(co3);
	JPanel co4 = new JPanel();
	co4.setBounds(210, 555, 40, 40);
	co4.setBackground(Color.black);
	mainFrame.add(co4);
	JPanel co5 = new JPanel();
	co5.setBounds(210, 560, 40, 40);
	co5.setBackground(Color.cyan);
	mainFrame.add(co5);
	JPanel co6 = new JPanel();
	co6.setBounds(210, 565, 40, 40);
	co6.setBackground(Color.darkGray);
	mainFrame.add(co6);
	JPanel co7 = new JPanel();
	co7.setBounds(210, 570, 40, 40);
	co7.setBackground(Color.gray);
	mainFrame.add(co7);
	JPanel co8 = new JPanel();
	co8.setBounds(210, 575, 40, 40);
	co8.setBackground(Color.magenta);
	mainFrame.add(co8);

	JPanel t1 = new JPanel();
	t1.setBounds(1260, 242, 40, 40);
	t1.setBackground(Color.red);
	mainFrame.add(t1);
	JPanel t2 = new JPanel();
	t2.setBounds(1265, 242, 40, 40);
	t2.setBackground(Color.blue);
	mainFrame.add(t2);
	JPanel t3 = new JPanel();
	t3.setBounds(1270, 242, 40, 40);
	t3.setBackground(Color.green);
	mainFrame.add(t3);
	JPanel t4 = new JPanel();
	t4.setBounds(1275, 242, 40, 40);
	t4.setBackground(Color.black);
	mainFrame.add(t4);
	JPanel t5 = new JPanel();
	t5.setBounds(1280, 242, 40, 40);
	t5.setBackground(Color.cyan);
	mainFrame.add(t5);
	JPanel t6 = new JPanel();
	t6.setBounds(1285, 242, 40, 40);
	t6.setBackground(Color.darkGray);
	mainFrame.add(t6);
	JPanel t7 = new JPanel();
	t7.setBounds(1290, 242, 40, 40);
	t7.setBackground(Color.gray);
	mainFrame.add(t7);
	JPanel t8 = new JPanel();
	t8.setBounds(1295, 242, 40, 40);
	t8.setBackground(Color.magenta);
	mainFrame.add(t8);

	JPanel h1 = new JPanel();
	h1.setBounds(1210, 465, 40, 40);
	h1.setBackground(Color.red);
	mainFrame.add(h1);
	JPanel h2 = new JPanel();
	h2.setBounds(1215, 465, 40, 40);
	h2.setBackground(Color.blue);
	mainFrame.add(h2);
	JPanel h3 = new JPanel();
	h3.setBounds(1220, 465, 40, 40);
	h3.setBackground(Color.green);
	mainFrame.add(h3);
	JPanel h4 = new JPanel();
	h4.setBounds(1225, 465, 40, 40);
	h4.setBackground(Color.black);
	mainFrame.add(h4);
	JPanel h5 = new JPanel();
	h5.setBounds(1230, 465, 40, 40);
	h5.setBackground(Color.cyan);
	mainFrame.add(h5);
	JPanel h6 = new JPanel();
	h6.setBounds(1235, 465, 40, 40);
	h6.setBackground(Color.darkGray);
	mainFrame.add(h6);
	JPanel h7 = new JPanel();
	h7.setBounds(1240, 465, 40, 40);
	h7.setBackground(Color.gray);
	mainFrame.add(h7);
	JPanel h8 = new JPanel();
	h8.setBounds(1245, 465, 40, 40);
	h8.setBackground(Color.magenta);
	mainFrame.add(h8);

	JPanel b1 = new JPanel();
	b1.setBounds(1040, 465, 40, 40);
	b1.setBackground(Color.red);
	mainFrame.add(b1);
	JPanel b2 = new JPanel();
	b2.setBounds(1040, 470, 40, 40);
	b2.setBackground(Color.blue);
	mainFrame.add(b2);
	JPanel b3 = new JPanel();
	b3.setBounds(1040, 475, 40, 40);
	b3.setBackground(Color.green);
	mainFrame.add(b3);
	JPanel b4 = new JPanel();
	b4.setBounds(1040, 480, 40, 40);
	b4.setBackground(Color.black);
	mainFrame.add(b4);
	JPanel b5 = new JPanel();
	b5.setBounds(1040, 485, 40, 40);
	b5.setBackground(Color.cyan);
	mainFrame.add(b5);
	JPanel b6 = new JPanel();
	b6.setBounds(1040, 490, 40, 40);
	b6.setBackground(Color.darkGray);
	mainFrame.add(b6);
	JPanel b7 = new JPanel();
	b7.setBounds(1040, 495, 40, 40);
	b7.setBackground(Color.gray);
	mainFrame.add(b7);
	JPanel b8 = new JPanel();
	b8.setBounds(1040, 500, 40, 40);
	b8.setBackground(Color.magenta);
	mainFrame.add(b8);

	JPanel ch1 = new JPanel();
	ch1.setBounds(940, 685, 40, 40);
	ch1.setBackground(Color.red);
	mainFrame.add(ch1);
	JPanel ch2 = new JPanel();
	ch2.setBounds(945, 685, 40, 40);
	ch2.setBackground(Color.blue);
	mainFrame.add(ch2);
	JPanel ch3 = new JPanel();
	ch3.setBounds(950, 685, 40, 40);
	ch3.setBackground(Color.green);
	mainFrame.add(ch3);
	JPanel ch4 = new JPanel();
	ch4.setBounds(955, 685, 40, 40);
	ch4.setBackground(Color.black);
	mainFrame.add(ch4);
	JPanel ch5 = new JPanel();
	ch5.setBounds(960, 685, 40, 40);
	ch5.setBackground(Color.cyan);
	mainFrame.add(ch5);
	JPanel ch6 = new JPanel();
	ch6.setBounds(965, 685, 40, 40);
	ch6.setBackground(Color.darkGray);
	mainFrame.add(ch6);
	JPanel ch7 = new JPanel();
	ch7.setBounds(970, 685, 40, 40);
	ch7.setBackground(Color.gray);
	mainFrame.add(ch7);
	JPanel ch8 = new JPanel();
	ch8.setBounds(975, 685, 40, 40);
	ch8.setBackground(Color.magenta);
	mainFrame.add(ch8);

	JPanel s1 = new JPanel();
	s1.setBounds(940, 225, 40, 40);
	s1.setBackground(Color.red);
	mainFrame.add(s1);
	JPanel s2 = new JPanel();
	s2.setBounds(945, 225, 40, 40);
	s2.setBackground(Color.blue);
	mainFrame.add(s2);
	JPanel s3 = new JPanel();
	s3.setBounds(950, 225, 40, 40);
	s3.setBackground(Color.green);
	mainFrame.add(s3);
	JPanel s4 = new JPanel();
	s4.setBounds(955, 225, 40, 40);
	s4.setBackground(Color.black);
	mainFrame.add(s4);
	JPanel s5 = new JPanel();
	s5.setBounds(960, 225, 40, 40);
	s5.setBackground(Color.cyan);
	mainFrame.add(s5);
	JPanel s6 = new JPanel();
	s6.setBounds(965, 225, 40, 40);
	s6.setBackground(Color.darkGray);
	mainFrame.add(s6);
	JPanel s7 = new JPanel();
	s7.setBounds(970, 225, 40, 40);
	s7.setBackground(Color.gray);
	mainFrame.add(s7);
	JPanel s8 = new JPanel();
	s8.setBounds(975, 225, 40, 40);
	s8.setBackground(Color.magenta);
	mainFrame.add(s8);

	JPanel gs1 = new JPanel();
	gs1.setBounds(490, 410, 40, 40);
	gs1.setBackground(Color.red);
	mainFrame.add(gs1);
	JPanel gs2 = new JPanel();
	gs2.setBounds(495, 410, 40, 40);
	gs2.setBackground(Color.blue);
	mainFrame.add(gs2);
	JPanel gs3 = new JPanel();
	gs3.setBounds(500, 410, 40, 40);
	gs3.setBackground(Color.green);
	mainFrame.add(gs3);
	JPanel gs4 = new JPanel();
	gs4.setBounds(505, 410, 40, 40);
	gs4.setBackground(Color.black);
	mainFrame.add(gs4);
	JPanel gs5 = new JPanel();
	gs5.setBounds(510, 410, 40, 40);
	gs5.setBackground(Color.cyan);
	mainFrame.add(gs5);
	JPanel gs6 = new JPanel();
	gs6.setBounds(515, 410, 40, 40);
	gs6.setBackground(Color.darkGray);
	mainFrame.add(gs6);
	JPanel gs7 = new JPanel();
	gs7.setBounds(520, 410, 40, 40);
	gs7.setBackground(Color.gray);
	mainFrame.add(gs7);
	JPanel gs8 = new JPanel();
	gs8.setBounds(525, 410, 40, 40);
	gs8.setBackground(Color.magenta);
	mainFrame.add(gs8);

	JPanel ranch1 = new JPanel();
	ranch1.setBounds(470, 660, 40, 40);
	ranch1.setBackground(Color.red);
	mainFrame.add(ranch1);
	JPanel ranch2 = new JPanel();
	ranch2.setBounds(475, 660, 40, 40);
	ranch2.setBackground(Color.blue);
	mainFrame.add(ranch2);
	JPanel ranch3 = new JPanel();
	ranch3.setBounds(480, 660, 40, 40);
	ranch3.setBackground(Color.green);
	mainFrame.add(ranch3);
	JPanel ranch4 = new JPanel();
	ranch4.setBounds(485, 660, 40, 40);
	ranch4.setBackground(Color.black);
	mainFrame.add(ranch4);
	JPanel ranch5 = new JPanel();
	ranch5.setBounds(490, 660, 40, 40);
	ranch5.setBackground(Color.cyan);
	mainFrame.add(ranch5);
	JPanel ranch6 = new JPanel();
	ranch6.setBounds(495, 660, 40, 40);
	ranch6.setBackground(Color.darkGray);
	mainFrame.add(ranch6);
	JPanel ranch7 = new JPanel();
	ranch7.setBounds(500, 660, 40, 40);
	ranch7.setBackground(Color.gray);
	mainFrame.add(ranch7);
	JPanel ranch8 = new JPanel();
	ranch8.setBounds(505, 660, 40, 40);
	ranch8.setBackground(Color.magenta);
	mainFrame.add(ranch8);

	JPanel sec_hid1 = new JPanel();
	sec_hid1.setBounds(470, 850, 40, 40);
	sec_hid1.setBackground(Color.red);
	mainFrame.add(sec_hid1);
	JPanel sec_hid2 = new JPanel();
	sec_hid2.setBounds(475, 850, 40, 40);
	sec_hid2.setBackground(Color.blue);
	mainFrame.add(sec_hid2);
	JPanel sec_hid3 = new JPanel();
	sec_hid3.setBounds(480, 850, 40, 40);
	sec_hid3.setBackground(Color.green);
	mainFrame.add(sec_hid3);
	JPanel sec_hid4 = new JPanel();
	sec_hid4.setBounds(485, 850, 40, 40);
	sec_hid4.setBackground(Color.black);
	mainFrame.add(sec_hid4);
	JPanel sec_hid5 = new JPanel();
	sec_hid5.setBounds(490, 850, 40, 40);
	sec_hid5.setBackground(Color.cyan);
	mainFrame.add(sec_hid5);
	JPanel sec_hid6 = new JPanel();
	sec_hid6.setBounds(495, 850, 40, 40);
	sec_hid6.setBackground(Color.darkGray);
	mainFrame.add(sec_hid6);
	JPanel sec_hid7 = new JPanel();
	sec_hid7.setBounds(500, 850, 40, 40);
	sec_hid7.setBackground(Color.gray);
	mainFrame.add(sec_hid7);
	JPanel sec_hid8 = new JPanel();
	sec_hid8.setBounds(505, 850, 40, 40);
	sec_hid8.setBackground(Color.magenta);
	mainFrame.add(sec_hid8);
  */
    }
}