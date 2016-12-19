import java.util.ArrayList;

public class HC {
    private ArrayList<Integer> sol = new ArrayList<Integer>();

    public HC(ArrayList<Integer> list)
    {
        sol = list;
    }

    public HC(int n)
    {
        sol = RandPerm(n);
    }

    public static ArrayList<Integer> RandPerm(int N)
    {
        ArrayList<Integer> P = new ArrayList<Integer>();
        for (int i = 0; i < N; i++)
        {
            P.add((i));
        }

        ArrayList<Integer> T = new ArrayList<Integer>();

        while (P.size() > 0)
        {
            int i = CS2004.UI(0, P.size()-1);
            T.add(P.get(i));
            P.remove(i);
        }
        return T;
    }

    public void Swap()
    {
        int i =0;
        int j= 0 ;
        while (i == j)
        {
            i = CS2004.UI(0,sol.size() -1);
            j = CS2004.UI(0,sol.size() -1);
        }
        int temp = sol.get(i);
        sol.set(i,sol.get(j));
        sol.set(j,temp);
    }

    public double getfitness(int N, ArrayList<Integer> T, double[][] D)
    {
        double s = 0;
        for (int i = 0; i < (N-1); i++ )
        {
            int a = T.get(i);
            int b = T.get(i+1);
            s = s + D[a][b];
        }
        int endcity = T.get(T.size()-1);
        int startcity = T.get(0);
        s = s + D[endcity][startcity];
        return s;
    }

    public double fitness(int N, double[][] D)
    {
        double s = 0;
        for (int i = 0; i < (N-1); i++ )
        {
            int a = sol.get(i);
            int b = sol.get(i+1);
            s = s + D[a][b];
        }
        int endcity = sol.get(sol.size()-1);
        int startcity = sol.get(0);
        s = s + D[endcity][startcity];
        return s;
    }

    public void print()
    {
        System.out.println(sol);
    }

    public ArrayList<Integer> GetSol()
    {
        ArrayList<Integer> clone = new ArrayList<Integer>(sol.size());
        for (int i = 0; i < sol.size();i++)
        {
            clone.add(sol.get(i));
        }
        return(clone);
    }
}
