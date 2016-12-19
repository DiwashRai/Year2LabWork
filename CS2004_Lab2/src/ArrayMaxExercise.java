
public class ArrayMaxExercise {
    public static double ArrayMax(double[] a)
    {
        int i;
        double CurrentMax = a[0];
        for (i =1; i < a.length; i++)
        {
            if (a[i]>CurrentMax)
            {
                CurrentMax = a[i];
            }
        }
        return CurrentMax;
    }

    public static int sum(int n)
        {
        double check;
        int partialSum;
        partialSum =0;
        for(int i=1;i<=n;i++)
        {
            partialSum += i;
        }
        check = (n*(n+1))/2;
        if (check == partialSum)
        {
            System.out.println("Result IS as expected");
        }
        else
        {
            System.out.println("Result is NOT as expected");
        }
        return partialSum;
    }

    public static double GeoSum (double a, double N)
    {
        double ans = 1;
        int i;
        double check;
        for (i =1; i<= N;i++)
        {
            ans = ans+(Math.pow(a,i));
        }
        check = 1+((a*(Math.pow(a,N)-1))/(a-1));
        if (check == ans)
        {
            System.out.println("Result IS as expected");
        }
        else
        {
            System.out.println("Result is NOT as expected");
        }
        return ans;
    }

    public static void RunAlgorithm()
    {
        long StartTime, EndTime, ElapsedTime;

        System.out.println("Testing algorithm...");
        System.out.println();

        // Save the time before the algorithm run
        StartTime=System.currentTimeMillis();

        // Run the algorithm
        sum(1000000009);

        // Save the time after the run
        EndTime=System.currentTimeMillis();

        // Calculate the difference
        ElapsedTime= EndTime- StartTime;

        // Print it out
        System.out.println("The algorithm took " + ElapsedTime + " milliseconds to run.");
    }


}
