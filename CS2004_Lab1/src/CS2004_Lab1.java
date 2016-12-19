
public class CS2004_Lab1 {
    public static void main(String[] args)
    {
        ILoveCS2004 lovecs = new ILoveCS2004();
        lovecs.love();

        Numeric numeric = new Numeric();
        System.out.println(numeric.approxEqual(4,4));

        double x = 64;
        RootApproximator root = new RootApproximator(x);
        System.out.println(root.getRoot());

        RootApproximationTest rootapprox = new RootApproximationTest();
        rootapprox.roottest();
    }

}
