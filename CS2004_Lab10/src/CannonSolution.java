
public class CannonSolution {
    public double theta, vzero, tRange;
    public double theta1,vzero1;

    public CannonSolution(double t)
    {
        theta = CS2004.UR(25,55);
        vzero = CS2004.UR(1500,1650);
        theta1 = theta;
        vzero1 = vzero;
        tRange = t;
    }

    public CannonSolution()
    {
        theta = CS2004.UR(25,55);
        vzero = CS2004.UR(1500,1650);
        theta1 = theta;
        vzero1 = vzero;
    }

    public void SmallChange()
    {
        int coin = CS2004.UI(0,1);
        if (coin == 1)
        {
            double x = (double) 30/100;
            theta1 = theta + CS2004.UR(-x, x);
        }
        else
        {
            double x = (double) 150/100;
            vzero1 = vzero + CS2004.UR(-x, x);
        }

        if (theta1 > 55){theta1 = 55;}
        else if (theta1 < 25){theta1 = 25;}

        if (vzero1 > 1650){vzero1 = 1650;}
        else if (vzero1 < 1500){vzero1 = 1500;}
    }

    public double CannonFitness (double angle, double velocity, double TargetRange)
    {
        double fitness;
        double range = Cannon.GetMaxRange(angle, velocity);
        fitness = Math.abs(range-TargetRange);

        return(fitness);
    }

    public void printsol()
    {
        System.out.println("angle = " + theta + ", muzzle velocity = " + vzero + ", range = " + Cannon.GetMaxRange(theta,vzero));
    }

    public void paraprnt()
    {
        System.out.println("Theta = " + theta + ", vzero = " + vzero + ", tRange = " + tRange);
        System.out.println("Theta1 = " + theta1 + ", vzero1 = " + vzero1);
    }
}
