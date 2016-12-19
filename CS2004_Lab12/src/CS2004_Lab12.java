import java.util.ArrayList;

public class CS2004_Lab12 
{
	public static void main(String args[])
	{
		//Run 10 repeats
		for(int i=0;i<10;++i)
		{
			//Reset the fitness count
			OneMaxChrome.ClearFC();
			//The following parameters are not very good!
			//These are the ones you should try and optimise!
			int popsize = 100;
			double mrate = 0.05;
			double crate = 50;
			//You will not need to change the following
			SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize,10,1000,mrate,crate);
			//Run the GA for 10,000 function calls
			double f = ga.RunSGA(100000,false).GetFitness();
			System.out.println(f);
		}
	}
}
