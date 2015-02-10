/* Student.java
 */

package mypisd;

import java.util.*;

public class Student
{
    private static final String DEFAULT_FIRST_NAME = "Firstname";
    private static final String DEFAULT_LAST_NAME = "Lastname";
    private static final int DEFAULT_ID = 0;
    private static final int DEFAULT_GRADE_LEVEL = 0;
    
    private String firstName;
    private String lastName;
    private int id;
    private int gradeLevel;
    private Map<String, Grade[]> gradebook; /* we might want to put a lot of this stuff into a whole new
                                             * Gradebook class, so methods like addClass don't just refer
                                             * to grades */
    
    public Student()
    {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_ID, DEFAULT_GRADE_LEVEL);
    }
    
    public Student(String firstName, String lastName, int id, int gradeLevel)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gradeLevel = gradeLevel;
        gradebook = new TreeMap<String, Grade[]>();
    }
    
    public void addClass(String className)
    {
        Grade[] grades = new Grade[8];
        for (int k = 0; k < grades.length; k++)
        {
            if (k == 3 || k == 7)
                grades[k] = new ExamGrade();
            else
                grades[k] = new SixWeeksGrade();
        }
        gradebook.put(className, grades);
    }
    
    public void addGrade(String className, int index, int weight, int grade)
    {
        Grade g = gradebook.get(className)[index];
        g.add(weight, grade);
    }
    
    public int getSixWeeksGrade(String className, int sixWeeks)
    {
        int index = -1;
        switch (sixWeeks)
        {
            case 1: index = 0;
                break;
            case 2: index = 1;
                break;
            case 3: index = 2;
                break;
            case 4:
            case 5:
            case 6: index = sixWeeks;
        }
        return Math.round((float) gradebook.get(className)[index].getGrade());
    }
    
    public int getExamGrade(String className, int semester)
    {
        int index = -1;
        if (semester == 0)
            index = 3;
        else
            index = 7;
        return Math.round((float) gradebook.get(className)[index].getGrade());
    }
    
    public int getSemesterGrade(String className, int semester)
    {
        double total = 0;
        int count = 0, s = -1;
        if (semester == 0)
            s = 0;
        else
            s = 4;
        for (int k = s; k < s + 4; k++)
            {
                if (gradebook.get(className)[k].getGrade() != 0)
                {
                    total += gradebook.get(className)[k].getGrade();
                    count++;
                }
            }
        if (count == 0)
            return 0;
        return Math.round((float) total / count);
    }
}
