
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class CS2004_Lab5 {
    public static void main (String[] args)
    {
        Data x = new Data("Fred",41);
        Data y = new Data("Jo", 43);
        Data z = new Data("Zoe", 37);

        LinkedList<Data> array = new LinkedList<Data>();

        array.add(x);
        array.add(y);
        array.add(z);

        PrintCollection(array);

        Data a = new Data("Harry",78);
        array.add(2,a);
        PrintCollection(array);

        ArrayList<Data> ArrayA = new ArrayList<Data>();
        ArrayList<Data> ArrayB = new ArrayList<Data>();

        ArrayA.add(x);
        ArrayA.add(y);
        ArrayA.add(z);

        System.out.println();
        PrintCollection(ArrayA);
        ArrayB = ArrayA;
        PrintCollection(ArrayB);
        ArrayA.remove(1);
        PrintCollection(ArrayB);

        ArrayList<Data> ArrayC = new ArrayList<Data>();
        ArrayC.add(x);
        ArrayC.add(y);
        ArrayC.add(z);
        ArrayList<Data> ArrayD = new ArrayList<Data>();

        System.out.println();
        PrintCollection(ArrayC);
        ArrayD = (ArrayList<Data>)ArrayC.clone();
        ArrayC.remove(1);
        PrintCollection(ArrayC);
        PrintCollection(ArrayD);

        Stack<Data> stack = new Stack<Data>();
        stack.push(x);
        stack.push(y);
        stack.push(z);

        System.out.println();

        while(stack.isEmpty() == false)
        {
            stack.pop().Print();
        }
        System.out.println(stack.size());

        ArrayBlockingQueue<Data> q = new ArrayBlockingQueue<Data>(10);
        q.add(x);
        q.add(y);
        q.add(z);
        System.out.println();
        PrintCollection(q);

        while(q.isEmpty() == false)
        {
            q.poll().Print();
        }
        System.out.println(q.size());

        for(int i=0;i<20;++i)
        {
            q.offer(new Data("Test:"+String.valueOf(i),i));
        }
        PrintCollection(q);

    }

    public static void PrintCollection(Collection<Data> c)
    {
        for (Iterator<Data> iter = c.iterator(); iter.hasNext();)
        {
            Data x = (Data)iter.next();
            x.Print();
        }
        System.out.println();
    }

}
