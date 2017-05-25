package medium;

import java.util.Random;

/**
 * Created by chenlijie on 5/14/17.
 */
public class Shuffle_an_Array_384 {

    private int[] copy;

    public Shuffle_an_Array_384(int[] nums) {
        copy = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return copy;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        random.ints(10);
        return copy;
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(2));
    }
}
