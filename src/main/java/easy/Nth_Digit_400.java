package easy;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Nth_Digit_400 {

    /*
    1 - 9  -> 9*1=9
    10 - 99 -> 90*2=180
    100 - 999 -> 900*3=2700
    1000 - 9999 -> 9000*4=36000
    10000 - 99999 -> 90000*5=450000

    2889
    10000 10001
     */

    public static int findNthDigit(int n) {

        int total = 0;
        int preTotal = 0;
        int digits = 1;
        int base = 1;

        while (n > total) {
            preTotal = total;
            total += 9*base*digits;
            digits++;
            base *= 10;
            if (base == 1000000000) {
                break;
            }
        }

        base /= 10;
        digits--;

        int num = (n-preTotal)/digits + base - 1;
        int left = (n-preTotal)%digits;

        if (left == 0) {
            return num%10;
        } else {
            num++;
            return Integer.valueOf(String.valueOf(num).substring(left-1, left));
        }

    }

    public static void main(String[] args) {
        System.out.println(1000000000);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(findNthDigit(1000000000));
    }
}
