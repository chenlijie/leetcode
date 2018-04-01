package zillow;

public class ReverseInteger {

    //2582 258
    //285
    static int reverse(int x) {
//        int sign = x >= 0 ? 1 : -1;
//        x = Math.abs(x);
        int num = 0;

        while (x > 0) {
            if (num > Integer.MAX_VALUE/10 || num < Integer.MIN_VALUE/10) {
                return 0;
            }
            num = 10*num + x % 10;
            x /= 10;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(reverse(Integer.MIN_VALUE));

//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Math.abs(Integer.MIN_VALUE + 1));
//
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE + 1));
    }
}
