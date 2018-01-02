package medium;

/**
 * Created by chenlijie on 12/27/17.
 */
public class Divide_Two_Integers_29 {

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;

        boolean negative = (dividend >= 0) ^ (divisor > 0);
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        int ans = 0;

        while (dvd > dvs) {
            long t = dvs;
            int res = 1;

            while (dvd >= (t<<1)) {
                t <<= 1;
                res <<= 1;
            }
            dvd -= t;
            ans += res;
        }

        if (dvd >= dvs)
            ans++;

        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        Divide_Two_Integers_29 d = new Divide_Two_Integers_29();
//        System.out.println(d.divide(Integer.MAX_VALUE,2));
//        System.out.println(d.divide(Integer.MIN_VALUE,1));
//        System.out.println(d.divide(10,3));

//        System.out.println(Math.abs(Integer.MIN_VALUE));
//        System.out.println(-Integer.MIN_VALUE);
//        System.out.println(Integer.bitCount(-Integer.MAX_VALUE));
//        System.out.println(Integer.MIN_VALUE-1);

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += 1<<i;
        }
        System.out.println(ans);
        System.out.println(Integer.bitCount(Integer.MIN_VALUE));
    }
}
