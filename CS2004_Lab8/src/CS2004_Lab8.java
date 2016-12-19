import java.util.ArrayList;

public class CS2004_Lab8 {
    public static void main (String[] args)
    {

        System.out.println("8.3 Exercise 2: The CS2004 Class");
        for(int i=0;i<10;++i)
        {
            int x = CS2004.UI(-1, 1);
            System.out.println(x);
        }

        System.out.println("8.4 Exercise 3: The ScalesSolution Class");

        ScalesSolution s = new ScalesSolution("10101");
        s.println();

        s = new ScalesSolution("10101x");
        s.println();

        System.out.println();
        System.out.println("Testing the example");
        System.out.println();

        //Creating the example arraylist
        ArrayList<Double> weights = new ArrayList<Double>();
        weights.add(1.0);
        weights.add(2.0);
        weights.add(3.0);
        weights.add(4.0);
        weights.add(10.0);

        ScalesSolution test = new ScalesSolution(weights.size());

        //loop to repeatedly generate and evaluate solutions
        for (int i =0;i < 2;i++)
        {
            test = new ScalesSolution(weights.size());
            System.out.print("Solution string = ");
            test.print();
            System.out.print(", ");
            double fitval;
            fitval = test.ScalesFitness(weights);
            System.out.println("Fitness = " + fitval);
        }

        System.out.println();
        System.out.println("8.5 Exercise 4: Reading in Data");

        ArrayList<Double> prime = new ArrayList<Double>(CS2004.ReadNumberFile("C:\\Users\\Diwash\\Desktop\\1000 Primes.txt"));
        System.out.println(prime.size() + " values in file");
        System.out.println(prime.get(5)+ " is the 6th prime number");
        System.out.println();

        int x = prime.size();

        ScalesSolution primesol = new ScalesSolution(x);

        x = 250;			//solution string length
        double average = 0;
        int repeat = 100;
        double fitval;
        System.out.println("Scale solution on prime arraylist of length " + repeat);

        for (int i = 0; i < repeat; i++)
        {
            primesol = new ScalesSolution(x);

            System.out.print("Solution string = ");
            primesol.print();
            System.out.print(", ");
            fitval = primesol.ScalesFitness(prime);
            System.out.println("Fitness = " + fitval);

            average = average + fitval;
        }
        average = average/repeat;
        System.out.println("Average fitness value from " + repeat + " iterations is " + average);
    }
}

