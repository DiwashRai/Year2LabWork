import java.util.ArrayList;
import java.util.Random;

public class CS2004_Lab6 {
    public static void main (String[] args)
    {
        Integer n = 10;                 // length of randomly generated array
        ArrayList<Integer> rndarrlist = new ArrayList<Integer>(n);
        Integer i;

        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());

        for (i = 0; i < n; i++)
        {
            rndarrlist.add(i, Math.abs(rnd.nextInt() % 256));
        }
        ShowArray(rndarrlist);
        System.out.println(ThreeSorts.SortB(rndarrlist));
        ShowArray(rndarrlist);
        System.out.println(30&16);
    }

    public static void ShowArray (ArrayList<Integer> arr)
    {
        //Shows arraylist values in rows of 10
        int i;
        for (i = 0; i < arr.size(); i++)
        {
            System.out.print(arr.get(i) + ", ");
            if (((i+1)%10) == 0)
            {
                System.out.println();
            }
        }
    }
}
