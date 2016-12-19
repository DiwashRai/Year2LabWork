import java.util.ArrayList;

public class CS2004_Lab9 {
    public static void main (String[] args)
    {
        System.out.println("9.3 Exercise 1: Small Change Method");

        // Testing the small change method in the ScalesSolution class
        ScalesSolution s = new ScalesSolution("11111");
        s.println();
        s.SmallChange();
        s.println();
        System.out.println();

        System.out.println("9.4 Exercise 2: Hill Climbing Method");
        System.out.println("9.4.1 Testing getSol");
        // Testing the GetSol method which lets you copy a solution
        ScalesSolution s1 = new ScalesSolution(10);
        s1.println();
        ScalesSolution s2 = new ScalesSolution(s1.GetSol());
        s2.println();

        // Creating the example array for testing
        ArrayList eg  = new ArrayList<Double>();
        eg.add(1.0);
        eg.add(2.0);
        eg.add(3.0);
        eg.add(4.0);
        eg.add(10.0);


        // Implementing the random change hill climbing algorithm on the example array
        int egIter = 10;
        System.out.println("9.4.2 Implementing RMHC on the example array");
        ScalesSolution solution = RMHC(eg, eg.size(),egIter);
        System.out.print(egIter + " iterations solutions = ");
        solution.println();
        System.out.println();

        System.out.println("9.5 Exercise 3: Reading in Data and Running Some Experiments");
        ArrayList<Double> prime = new ArrayList<Double>(CS2004.ReadNumberFile("C:\\Users\\Diwash\\Desktop\\1000 Primes.txt"));

        //Checking file is being read properly
        System.out.println(prime.size() + " values in file");
        System.out.println(prime.get(5)+ " is the 6th prime number");
        System.out.println();

        int primeIter = 10000;
        solution = RMHC(prime, 100,primeIter);
        solution.println();
        double solfit = solution.ScalesFitness(prime);
        System.out.println("Solution fitness = " + solfit);
        System.out.println();

        System.out.println("9.5 Exercise 3: Reading in Data and Running Some Experiments");

        double avgfit = 0; //variable to calculate average fitness when RMHC is repeated
        long avgtime = 0;
        int repeat = 10;
        long StartTime, EndTime, ElapsedTime;
        long StartRunTime, StopRunTime, TotalRunTime;
        StartRunTime = System.nanoTime();
        for (int i = 0; i < repeat; i++)
        {
            //      Save the time before the algorithm run
            StartTime=System.nanoTime();

            solution = RMHC(prime, prime.size(), primeIter);
            solfit = solution.ScalesFitness(prime);

            //      Save the time after the run
            EndTime=System.nanoTime();

            //Calculate elapsed time
            ElapsedTime= EndTime- StartTime;

            avgfit = avgfit + solfit;
            avgtime = avgtime + ElapsedTime;

            System.out.println("Solution fitness = " + solfit + "    |   Time taken: " + ElapsedTime);
        }
        avgfit = avgfit/repeat;       //calculates average fitness of all the repetitions
        avgtime = avgtime/repeat;
        StopRunTime = System.nanoTime();
        TotalRunTime = (StopRunTime - StartRunTime)/1000000000;

        System.out.println();
        System.out.println("Average fitness = " + avgfit+ "    |   Average time: " + avgtime);
        System.out.println("Total run time in seconds = " + TotalRunTime);
    }

    public static ScalesSolution RMHC(ArrayList<Double> weights,int n,int iter)
    {
        ScalesSolution sol = new ScalesSolution(n);
        ScalesSolution sol1;
        double fit, fit1;

        for (int i = 0; i < iter; i++)
        {
            sol1 = new ScalesSolution(sol.GetSol());
            fit = sol.ScalesFitness(weights);
            sol1.SmallChange();
            fit1 = sol1.ScalesFitness(weights);


            // Print outs to monitor each iteration as it happens. Comment out if not needed

//            System.out.println("Iterations no: " + i);
//            sol.print();
//            System.out.println("     Fitness = " + fit);
//            sol1.print();
//            System.out.println("     Fitness = " + fit1);

            if (fit1 < fit)
            {
                sol = sol1;
            }
        }

        return(sol);
    }
}
