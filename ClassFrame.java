/* ClassFrame.java
 */
package mypisd;

import javax.swing.*;
import java.awt.*;

public class ClassFrame extends JFrame
{
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static Class DEFAULT_CLASS = new Class();
	private static ClassPanel DEFAULT_CLASS_PANEL = new ClassPanel();
	
	private Class c;
	private ClassPanel panel;
	
	public ClassFrame()
	{
		this(DEFAULT_CLASS, DEFAULT_CLASS_PANEL);
	}
	
    public ClassFrame(Class c, ClassPanel panel)
    {
    	this.c = c;
    	this.panel = panel;
    	setLocation(0, 0);
    	setSize(screenSize);
    	setExtendedState(this.MAXIMIZED_BOTH);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setVisible(true);
    }
}