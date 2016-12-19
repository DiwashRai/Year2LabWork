import java.util.ArrayList;

public class CS2004_Lab14 {

    public static void main(String args[])
    {
        //Creating the expected arraylist
        ArrayList<Integer> ExArr = new ArrayList<Integer>();
        for(int i=1; i<= 100; i++)
        {
            if ((0 < i) && (i <= 25)){ExArr.add(1);}
            else if ((25 < i) && (i <= 75)){ExArr.add(2);}
            else if ((75 < i) && (i <= 100)){ExArr.add(3);}
            else{System.out.println("error!");}
        }

        //Creating and reading ClusterLab arraylist
        double[][] readfile = new double[99][2];
        readfile = KMeans.ReadArrayFile("C:\\Users\\Diwash\\Desktop\\ClusterLab.txt" , ",");

        //Creating and running the kmeans obj
        KMeans kmeans = new KMeans(readfile,3,100);
        ArrayList<Integer> result = new ArrayList<Integer>();
        result = kmeans.RunIter(3,10, ExArr,true);


        //Outputting the result arraylist
        System.out.println();
        for(int i=1; i<100; i++)
        {
            System.out.println(result.get(i));
        }
    }
}
