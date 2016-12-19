import java.util.Random;

public class CS2004_Lab4 {
    public static void main (String[] args)
    {
        int i;
        double X[] = {7, 3, -1, 2, 9 ,0, 0.8, 52, 2.2, 900};
        double arr[];

        arr = Methods.PrefixAverages2(X);

        System.out.println("4.4) Exercise 1");
        System.out.println();

        for (i = 0; i < X.length;i++)
        {
            System.out.println(arr[i]);
        }

//      Generate an array of a set size and populate it randomly
        int arraysize = 10000;
        double min = 0;     //minimum value of generated numbers
        double max = 1000;   //maximum value of generated numbers
        double[] Y = new double[arraysize];

        Random rnd = new Random();
        for (i = 0; i < arraysize; i++)
        {
            Y[i] = min + (rnd.nextDouble()*(max - min));
        }

        double testarr[];
        long StartTime, EndTime, ElapsedTime;

//      Save the time before the algorithm run
        StartTime=System.nanoTime();

//      Run the algorithm
        testarr = Methods.N_algorithm(Y);

//      Save the time after the run
        EndTime=System.nanoTime();

        System.out.println();
        System.out.println("Algorithm test. Array Y");
        System.out.println();

        for (i = 0; i < Y.length;i++)
        {
            System.out.println(testarr[i]);
        }

//      Calculate the difference
        ElapsedTime= EndTime- StartTime;

//      Print it out
        System.out.println();
        System.out.println("The algorithm took " + ElapsedTime + " nanoseconds to run.");



    }
}

