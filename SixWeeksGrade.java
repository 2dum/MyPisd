/* SixWeeksGrade.java
 */
package mypisd;

import java.util.*;

public class SixWeeksGrade implements Grade
{
    private List<Integer> daily;
    private List<Integer> minor;
    private List<Integer> major;
    private List<Integer> timedWriting;
    
    public SixWeeksGrade()
    {
        daily = new ArrayList<Integer>();
        minor = new ArrayList<Integer>();
        major = new ArrayList<Integer>();
        timedWriting = new ArrayList<Integer>();
    }
    
    public void add(int weight, int grade)
    {
        switch (weight)
        {
            case 0: daily.add(grade);
                break;
            case 1: minor.add(grade);
                break;
            case 2: major.add(grade);
                break;
        }
    }
    
    /* Calculates a Student's six weeks grade.
     */
    public double getGrade()
    {
        int dM = 0, twM = 0, maM = 0, miM = 0;
        if (timedWriting.isEmpty())
            dM = 25;
        else
        {
            dM = 12;
            twM = 13;
        }
        if (minor.isEmpty())
            maM = 75;
        else
        {
            maM = 50;
            miM = 25;
        }
        int num = 0;
        double total = 0;
        for (int i : daily)
        {
            total += (i * dM);
            num += dM;
        }
        for (int i : minor)
        {
            total += (i * miM);
            num += miM;
        }
        for (int i : major)
        {
            total += (i * maM);
            num += maM;
        }
        for (int i : timedWriting)
        {
            total += (i * twM);
            num += twM;
        }
        if (num == 0)
            return 0;
        return total / num;
    }
}
