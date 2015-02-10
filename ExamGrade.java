/* ExamGrade.java
 */
package mypisd;

import java.util.*;

public class ExamGrade implements Grade
{
    private List<Integer> grades;
    
    public ExamGrade()
    {
        grades = new ArrayList<Integer>();
    }
    
    public void add(int weight, int grade)
    {
        int num = weight;
        while (num > 0)
        {
            grades.add(grade);
            num--;
        }
    }
    
    public double getGrade()
    {
        double total = 0;
        for (int i : grades)
            total += i;
        return total / grades.size();
    }
}
