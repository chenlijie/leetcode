package easy;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Guess_Number_Higher_or_Lower_374 {


    static int s = 4;
    static int guess(int num) {
        if (num == s)
            return 0;
        if (num > s)
            return -1;

        return 1;
    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid = 1;

        while(low <= high) {
            mid = (low+high)/2;
            int t = guess(mid);
            if(t == 0) {
                break;
            } else if(t == 1) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
