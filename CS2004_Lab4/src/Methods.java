
public class Methods {
    public static double[] PrefixAverages1(double[] X)
    {
        double A[] = new double[X.length];
        int i,j;
        double s;
        for (i = 0; i < X.length; i++)
        {
            s = X[0];
            for(j = 1; j <= i; j++)
            {
                s = s + X[j];
            }
            A[i] = s/(i+1);
        }
        return A;
    }

    public static double[] PrefixAverages2(double[] X)
    {
        double A[] = new double[X.length];
        double s = 0;
        int i;
        for (i = 0; i < X.length; i++)
        {
            s = s + X[i];
            A[i] = s/(i + 1);
        }
        return A;
    }

    public static double[] NN_algorithm(double[] Y)
    {
        double A[] = new double[Y.length];
        int i,j;
        double s;
        for (i = 0; i < Y.length; i++)
        {
            s = Y[0];
            for(j = 1; j <= i; j++)
            {
                s = s + Y[j];
            }
            A[i] = s/(i+1);
        }
        return A;
    }

    public static double[] N_algorithm(double[] Y)
    {
        double A[] = new double[Y.length];
        double s = 0;
        int i;
        for (i = 0; i < Y.length; i++)
        {
            s = s + Y[i];
            A[i] = s/(i + 1);
        }
        return A;
    }
}
