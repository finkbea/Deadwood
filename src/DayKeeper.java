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

public class DayKeeper{

    Board board;
    int day;

    public DayKeeper(Board board){
	this.board = board;
	day = 1;
	
    }

    public void nextDay(){
	day++;
    }
}
