import java.util.ArrayList;

import static java.lang.Math.exp;

public class CS2004_Lab15 {
    public static void main(String args[]) {
        double [][] distance;
        distance = TSP.ReadArrayFile("C:\\Users\\Diwash\\Desktop\\TSP Data\\TSP_48.txt" , " ");

        ArrayList<Integer> OPT;
        OPT = TSP.ReadIntegerFile("C:\\Users\\Diwash\\Desktop\\TSP Data\\TSP_48_OPT.txt");
        System.out.println("Optimal path");
        System.out.println(OPT);
        HC optimal = new HC(OPT);
        double OPTfit = optimal.fitness(distance.length,distance);
        System.out.println(OPTfit);
        double percentage;

/////////////////////////////////////////////////////////Simple Hill Climbing///////////////////////////////////////////////////////
        System.out.println();
        System.out.println("Simple HC solution:");
        HC simple = simpleHC(distance.length,distance, 1000000);    //number of cities, distance array, how many iterations
        percentage = (OPTfit/ simple.fitness(distance.length,distance))*100;
        System.out.println("Percentage efficiency: " + percentage +"%");

///////////////////////////////////////////////////////Stochastic Hill Climbing//////////////////////////////////////////////////////

        System.out.println();
        System.out.println("Stochastic HC solution:");
        HC stochastic = stochasticHC(distance.length,distance, 1000000);    //number of cities, distance array, how many iterations
        percentage = (OPTfit/ stochastic.fitness(distance.length,distance))*100;
        System.out.println("Percentage efficiency: " + percentage +"%");

///////////////////////////////////////////////////////Random Restart Hill Climbing///////////////////////////////////////////////////
        System.out.println();
        System.out.println("Random Restart HC solution:");
        HC restart = restartHC(distance.length,distance, 10,100000);     //number of cities, distance array, how many restarts, iterations per restart
        percentage = (OPTfit/ restart.fitness(distance.length,distance))*100;
        System.out.println("Percentage efficiency: " + percentage +"%");

    }

    public static HC simpleHC (int N, double[][] distance,int iter)
    {
        HC s = new HC(N);
        HC s1;
        double fit;
        double fit1;

        for (int i=0; i < iter; i++)
        {
            s1 = new HC (s.GetSol());
            fit = s.fitness(N,distance);
            s1.Swap();
            fit1 = s1.fitness(N,distance);

            if (fit1 < fit)
            {
                s = s1;
            }
        }
        System.out.println("final solution");
        System.out.println(s.GetSol());
        System.out.println(s.fitness(distance.length,distance));
        return s;
    }

    public static HC stochasticHC (int N, double[][] distance,int iter)
    {
        HC s = new HC(N);
        HC s1;
        double fit, fit1,pr;
        double Tval = 200;

        for (int i=0; i < iter; i++)
        {
            s1 = new HC(s.GetSol());
            fit = s.fitness(N,distance);
            s1.Swap();
            fit1 = s1.fitness(N,distance);

            pr = 1/(1+exp((fit1-fit)/Tval));
            double rand = CS2004.UR(0,1);

            if (fit1 < fit)
            {
                s = s1;
            }
            else if(rand < pr)
            {
                s = s1;
            }
        }
        System.out.println(s.GetSol());
        System.out.println(s.fitness(distance.length,distance));
        return s;
    }

    public static HC restartHC (int N, double[][] distance,int restart, int iter)
    {
        HC best = new HC(0);
        double bestfit = Double.MAX_VALUE;
        HC test;
        double testfit;
        for (int i=0; i < restart; i++)
        {
            HC s = new HC(N);
            HC s1;
            double fit, fit1;

            for (int j=0; j < iter; j++)
            {
                s1 = new HC(s.GetSol());
                fit = s.fitness(N,distance);
                s1.Swap();
                fit1 = s1.fitness(N,distance);

                if (fit1 < fit)
                {
                    s = s1;
                }
            }
//            System.out.println(s.GetSol());   //// Remove comments to see restart steps

            test = s;
            testfit = s.fitness(N,distance);
            if (testfit < bestfit)
            {
                best = test;
                bestfit = test.fitness(N,distance);
            }
        }
        System.out.println(best.GetSol());
        System.out.println(best.fitness(distance.length, distance));
        return best;
    }
}
