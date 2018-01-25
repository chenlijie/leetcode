package linkedin;

public class MySqrt {


    static int mysqrt2(int x) {
        if (x <= 1)
            return x;

        int ans = 1;
        int lo = 1;
        int hi = x/2;

        while (lo <= hi) {
            int mi = lo + (hi - lo)/2;

            if (x/mi >= mi) {
                ans = mi;
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return ans;
    }

    static float mysqrt(int x) {
        if (x <= 1)
            return x;


        double lo = mysqrt2(x);
        double hi = lo + 1;
        double ans = lo;
        int cnt = 1;

        while (lo <= hi) {
//            System.out.println(cnt++);
            double mi = lo + (hi - lo)/2;

            if (x/mi >= mi) {
                ans = mi;
                lo = mi + 0.001;
            } else {
                hi = mi - 0.001;
            }
        }
        return Math.round(ans* 1000.0) / 1000.0f;
    }

    public static void main(String[] args) {
//        System.out.println(Math.round(mysqrt(8) * 1000.0f)/1000.0f);
        System.out.println(Math.sqrt(3));
        System.out.println(mysqrt(3));
//        System.out.println(2.827f == Math.round(mysqrt(8) * 1000.0f)/1000.0f);
//        System.out.println(Math.round(1.9));
//        System.out.println(Math.round(1.1));
//        System.out.println(2.828*2.828);
    }
}
