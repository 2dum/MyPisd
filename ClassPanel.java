package mypisd;

import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.util.*;

public class ClassPanel extends JPanel {
	
	private JPanel panel;
	private BufferedImage myPISDLogo;
	private Student stu;
	protected static Calendar cal;
	private static TimeZone = TimeZone.getTimeZone(TimeZone.getID());
	
    public ClassPanel()
    {
    	panel = new JPanel();
    	stu = new Student();
    	try {
    		myPISDLogo = ImageIO.read(new File("Logo.jpg"));
    	}
    	catch (IOException e){
    		System.out.println("File not found.");
    	}
    	cal = new Calendar(TimeZone.getTimeZone(TimeZone.getID()), new Locale(Locale.ENGLISH, Locale.US));    	
    }
    
    
    protected void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	g.drawImage(myPISDLogo, 0, 0, null);
    	g.drawString(stu.getName(), getWidth() - stu.getName().length(), getHeight() - stu.getName().length());
    }
    
    
}