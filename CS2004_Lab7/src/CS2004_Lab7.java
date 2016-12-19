import java.util.Arrays;
import java.util.Random;
import java.lang.Object;

public class CS2004_Lab7 {
    public static void main(String[] args) {
        double g[][] = {{0, 1, 2}, {1, 0, 3}, {2, 3, 0}};
        double mst[][] = MST.PrimsMST(g);

        System.out.println(g[0][2]);

        System.out.println("Exercise 1: Preliminaries");//------------------------------------------------------------------------

        PrintArray(g);
        System.out.println();
        PrintArray(mst);
        System.out.println();

        System.out.println("Exercise 2: A Larger Example"); //---------------------------------------------------------------------

        double roobie[][] = {{0, 1, 2, 3, 0}, {1, 0, 6, 0, 5}, {2, 6, 0, 4, 1}, {3, 0, 4, 0, 2}, {0, 5, 1, 2, 0}};
        mst = MST.PrimsMST(roobie);

        PrintArray(roobie);
        System.out.println();
        PrintArray(mst);
        System.out.println();

        System.out.println("Exercise 3: Experimental Analysis"); //----------------------------------------------------------------

        long StartTime, EndTime, ElapsedTime;
        int n = 500;             // Length of randomly generated array
        double rndArr[][] = new double[n][n];
        rndArr = RandomArray(n);

//      Save the time before the algorithm run
        StartTime=System.nanoTime();

        mst = MST.PrimsMST(rndArr);

//      Save the time after the run
        EndTime=System.nanoTime();

//        PrintArray(rndArr);
//        System.out.println();
//        PrintArray(mst);

//      Calculate the difference
        ElapsedTime= EndTime- StartTime;

//      Print it out
        System.out.println();
        System.out.println("The algorithm took " + ElapsedTime + " nanoseconds to run.");
    }

    public static double[][]RandomArray(int n)
    {
        Random rnd = new Random();
        int rndInt;

        int i,j;
        int min = 0;     //minimum value of generated numbers
        int max = 100;
        double rndarr[][] = new double[n][n];
        for (i =0; i < n; i++)
        {
            for (j = i; j < n; j++)
            {
                if (i == j)
                {
                    rndarr[i][j] = 0;
                }
                else
                {
                    rndInt = rnd.nextInt((max - min) + 1) + min;
                    rndarr[i][j] = rndInt;
                    rndarr[j][i] = rndInt;
                }
            }
        }
        return(rndarr);
    }

    public static void PrintArray(double[][] arr)
    {
        int i,j;
        int x = arr.length;
        for (i = 0; i < x; i++)
        {
            System.out.print("[");
            for (j = 0; j < x; j++)
            {
                System.out.print(arr[i][j]);
                if ((x - j) > 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
