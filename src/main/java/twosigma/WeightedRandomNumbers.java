package twosigma;

import java.util.Random;

public class WeightedRandomNumbers {

//    Weighted Random Number 具体题目及解法可见： http://blog.gainlo.co/index.php/ ... ted-random-numbers/

    static int getRandom(int[] nums) {
        int len = nums.length;
        int[] range = new int[len];

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            range[i] = sum;
        }

        int n = new Random().nextInt(sum);
        int i = 0;
        while (n > range[i]) {
            i++;
        }

        System.out.println("random = " + n + ", num = " + nums[i]);
        return nums[i];
    }

    public static void main(String[] args) {
        //[1 : 0],[2 : 1,2], [3: 3,4,5]
        System.out.println(getRandom(new int[] {1, 2, 3}));
    }
}
