import java.util.*;

public class ScalesSolution
{
    private String scasol;
    //Creates a new scales solution based on a string parameter
    //The string parameter is checked to see if it contains all zeros and ones
    //Otherwise the random binary string generator is used (n = length of parameter)
    public ScalesSolution(String s)
    {
        boolean ok = true;
        int n = s.length();
        for(int i=0;i<n;++i)
        {
            char si = s.charAt(i);
            if (si != '0' && si != '1') ok = false;
        }
        if (ok)
        {
            scasol = s;
        }
        else
        {
            scasol = RandomBinaryString(n);
        }
    }
    private static String RandomBinaryString(int n)
    {
        String s = new String();
        for (int i = 0;i < n; i++)
        {
            s = s + CS2004.UI(0, 1);
        }
        return(s);
    }
    public ScalesSolution(int n)
    {
        scasol = RandomBinaryString(n);
    }
    //This is the fitness function for the Scales problem
    //This function returns -1 if the number of weights is less than
    //the size of the current solution
    public double ScalesFitness(ArrayList<Double> weights)
    {
        if (scasol.length() > weights.size()) return(-1);
        double lhs = 0.0,rhs = 0.0;
        int n = scasol.length();

        for (int i =0; i < n; i++)
        {
            if (Character.toString(scasol.charAt(i)).equals("0"))
            {
                lhs = lhs + weights.get(i);
            }
            else
            {
                rhs = rhs + weights.get(i);
            }
        }
//        System.out.print("LHS = " + lhs + ", ");
//        System.out.print("RHS = " + rhs + ", ");
//        System.out.println("Fitness value = " + Math.abs(lhs-rhs));
        return(Math.abs(lhs-rhs));
    }
    //Display the string without a new line
    public void print()
    {
        System.out.print(scasol);
    }
    //Display the string with a new line
    public void println()
    {
        print();
        System.out.println();
    }

    public void SmallChange()
    {
        String x;
        int p = CS2004.UI(0,(scasol.length() - 1));
        x = scasol.substring(0, p);
        if (Character.toString(scasol.charAt(p)).equals("1"))
        {
            x = x + "0";
        }
        else
        {
            x = x + "1";
        }
        x = x + scasol.substring(p+1);

        scasol = x;
    }

    public String GetSol()
    {
        return(scasol);
    }
}