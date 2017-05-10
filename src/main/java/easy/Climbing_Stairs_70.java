package easy;

/**
 * Created by chenlijie on 5/9/17.
 */
public class Climbing_Stairs_70 {

    public int climbStairs(int n) {

        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        int[] k = new int[n];
        k[0] = 1;
        k[1] = 2;

        for (int i = 2; i < n; i++) {
            k[i] = k[i-1] + k[i-2];
        }

        return k[n-1];
    }
}
