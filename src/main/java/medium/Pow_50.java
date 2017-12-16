package medium;

/**
 * Created by chenlijie on 12/7/17.
 */
public class Pow_50 {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        else if (n == 1)
            return x;
        else if (n == -1)
            return 1/x;

        double res = myPow(x, n/2);
        x = n > 0 ? x : 1/x;

        return n%2 == 0 ?  res*res : res*res*x;
    }


    public static void main(String[] args) {
        Pow_50 pw = new Pow_50();
        System.out.println(pw.myPow(0.0, -3));
        System.out.println(10/1.0);
        System.out.println(Float.POSITIVE_INFINITY);
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);

//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(0-Integer.MIN_VALUE);
//        int x = -10;
//        System.out.println(-x);
    }
}
