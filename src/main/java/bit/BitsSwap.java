package bit;

/**
 * Created by chenlijie on 9/27/17.
 */
public class BitsSwap {

    public static int swap2(int n) {

        int left = 0;
        int right = 0;

        for (int i = 0; i < 31; i++) {
            if (i % 2 == 0) {
                right += 1 << i;
            } else {
                left += 1 <<i;
            }
        }

        System.out.println((right));
        System.out.println(((int)Math.pow(4, 16)-1)/3);

        System.out.println((left));
        System.out.println(((int)Math.pow(4, 16)-1)*2/3);


        return ((n & right)<<1) | ((n & left)>>>1);
    }

    public static int swap(int n) {
        return ((n & (((int)Math.pow(4, 16)-1)/3)<<1)) | ((n & (((int)Math.pow(4, 16)-1)*2/3))>>>1);
    }


    /*
    0001 0010
    0101 0101
    0001 0000
    0010 0000

    0001 0010
    1010 1010
    0000 0001

    0001 0010

    0000 1010
     */
    public static void main(String[] args) {
//        System.out.println(swap(10));
//        System.out.println((1 << 31));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.toBinaryString(-2147483648));

        int x = 7;
//        System.out.println(-x);

        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(-x));

//        System.out.println(0xaaaaaaaa);
//        System.out.println(0x55555555);
//
//        System.out.println(Integer.toBinaryString(0xaaaaaaaa));
//        System.out.println(Integer.toBinaryString(0x55555555));

    }
}
