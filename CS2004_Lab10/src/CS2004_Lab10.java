import java.util.ArrayList;

public class CS2004_Lab10 {
    public static void main (String[] args){
    	
    	System.out.println("10.3 Exercise 1: The Cannon Class");
        double r = Cannon.GetMaxRange(40.0,1575.0);
        System.out.println(r);
        ArrayList<Double> xt = Cannon.GetX();
        ArrayList<Double> yt = Cannon.GetY();
        System.out.println(xt.size());
        System.out.println(yt.size());
        System.out.println();
        
        System.out.println("10.4.4 Small Change Operator test");
        CannonSolution test = new CannonSolution(1550);
        test.SmallChange();
        test.paraprnt();
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////         Maximum Range       ///////////////////////////////////////////////////////////////////////////////////////////////

        int maxiter = 1000;
        CannonSolution max = new CannonSolution();

        for (int i = 0; i < maxiter; i++)
        {
            max.SmallChange();
            if (Cannon.GetMaxRange(max.theta1, max.vzero1)> Cannon.GetMaxRange(max.theta,max.vzero))
            {
                max.theta = max.theta1;
                max.vzero = max.vzero1;
            }
            else
            {
                max.theta1 = max.theta;
                max.vzero1 = max.vzero;
            }
        }
        System.out.print("Maximum range parameters:     ");
        max.printsol();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////         Minimum Range       ///////////////////////////////////////////////////////////////////////////////////////////////

        int miniter = 1000;
        CannonSolution min = new CannonSolution();

        for (int i = 0; i < miniter; i++)
        {
            min.SmallChange();
            if (Cannon.GetMaxRange(min.theta1, min.vzero1) < Cannon.GetMaxRange(min.theta,min.vzero))
            {
                min.theta = min.theta1;
                min.vzero = min.vzero1;
            }
            else
            {
                min.theta1 = min.theta;
                min.vzero1 = min.vzero;
            }
        }
        System.out.print("Minimum range parameters:     ");
        min.printsol();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////         Target Range       ////////////////////////////////////////////////////////////////////////////////////////////////

        int targetiter = 1000;
        double targetrange = 85000;
        double avg = 0;
        int repeat = 1;

        for (int i = 0; i < repeat; i++)
        {
        	CannonSolution target = new CannonSolution();
        	for (int j = 0; j < targetiter; j++)
            {
                target.SmallChange();
                if (target.CannonFitness(target.theta1,target.vzero1,targetrange) < target.CannonFitness(target.theta,target.vzero,targetrange))
                {
                    target.theta = target.theta1;
                    target.vzero = target.vzero1;
                }
                else
                {
                    target.theta1 = target.theta;
                    target.vzero1 = target.vzero;
                }
            }
            System.out.print("Target range parameters:     ");
            target.printsol();
            avg = avg + target.CannonFitness(target.theta,target.vzero,targetrange);
//            System.out.println("Fitness = " + target.CannonFitness(target.theta,target.vzero,targetrange));
        }
        avg = avg/repeat;
//        System.out.println("Average  = " +  avg);
    }
}
