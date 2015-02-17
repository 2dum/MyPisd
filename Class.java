/* Class.java
 */
package mypisd;

import java.util.*;

public class Class
{
	private static String DEFAULT_CLASS_NAME = "Classname";
	private static int DEFAULT_CLASS_LEVEL = 0;
	
	private String className;
	private int classLevel; // 0: Regulars, 1: Honors, 2: AP, 3: IB
	
	public Class()
	{
		this(DEFAULT_CLASS_NAME, DEFAULT_CLASS_LEVEL);
	}
	
    public Class(String className, int classLevel)
    {
    	this.className = className;
    	this.classLevel = classLevel;
    }
    
    public String getClassName()
    {
    	return className;
    }
}